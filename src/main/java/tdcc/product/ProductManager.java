package tdcc.product;

import javax.ejb.Remote;

@Remote
public interface ProductManager {
    public Product findById(String id);
    public Product update(Product product);
}
