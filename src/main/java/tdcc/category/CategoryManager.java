package tdcc.category;

import javax.ejb.Remote;

@Remote
public interface CategoryManager {
    public Category findByCategoryId(String id);
    public Category update(Category category);
}
