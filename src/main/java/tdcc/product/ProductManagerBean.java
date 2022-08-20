package tdcc.product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductManagerBean implements ProductManager {

    @PersistenceContext(unitName = "product")
    private EntityManager em;

    @Override
    public Product findById(String id) {
        return em.find(Product.class, id);
    }

    @Override
    public Product update(Product product) {
        em.joinTransaction();
        Product result = em.merge(product);
        return result;
    }
}
