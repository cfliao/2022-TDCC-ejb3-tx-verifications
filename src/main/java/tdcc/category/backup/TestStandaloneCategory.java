package tdcc.category.backup;

import tdcc.category.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestStandaloneCategory {

    private EntityManager em;

    public TestStandaloneCategory(EntityManager em) {
        this.em = em;
    }

    public Category findByCategoryId(String id) {
        TypedQuery<Category> query =
                em.createQuery("SELECT c FROM Category c WHERE c.categoryId = :id", Category.class)
                        .setParameter("id", id);
        return query.getSingleResult();
    }

    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        TestStandaloneCategory tester = new TestStandaloneCategory(em);

        System.out.println(tester.findByCategoryId("CATS"));
        System.out.println(tester.findByCategoryId("BIRDS"));

        em.close();
        emf.close();
    }
}
