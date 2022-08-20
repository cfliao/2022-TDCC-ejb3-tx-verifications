package tdcc.category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoryManagerBean implements CategoryManager {

    // 不能使用ejb-jar.xml，否則所有injection的annotation都不會有注入行為
    @PersistenceContext(unitName = "category")
    private EntityManager em;

    public Category findByCategoryId(String id) {
        return em.find(Category.class, id);
        //TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c WHERE c.categoryId = :id", Category.class).setParameter("id", id);
        //return query.getSingleResult();
    }

    @Override
    public Category update(Category category) {
        em.joinTransaction();
        Category result = em.merge(category);
        return result;
    }

}
