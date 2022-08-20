package tdcc.category.backup;

import tdcc.category.CategoryManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CategoryServiceImpl implements CategoryService {

    //@EJB(lookup = "ejb3-tx-1.0-SNAPSHOT/CategoryManager!tdcc.category.CategoryManager")
    private CategoryManager categoryManager;

    @Override
    public void call() {
        try {
            Context context = new InitialContext();
            categoryManager = (CategoryManager) context.lookup("java:global/ejb3-tx-1.0-SNAPSHOT/CategoryManager");
            categoryManager.findByCategoryId("BIRDS");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
