package tdcc.category;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class TestInContainerCategory {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
        InitialContext ic;
        ic = new InitialContext(properties);
        CategoryManager cm = (CategoryManager) ic.lookup("ejb3-tx-1.0-SNAPSHOT/CategoryManagerBean!tdcc.category.CategoryManager");
        testFindById(cm);
    }

    public static void testUpdate(CategoryManager cm) {
        Category catsCategory = cm.findByCategoryId("CATS");
        catsCategory.setName("Cats1");
        System.out.println(cm.update(catsCategory));
    }

    public static void recoverUpdate(CategoryManager cm) {
        Category catsCategory = cm.findByCategoryId("CATS");
        catsCategory.setName("Cats");
        System.out.println(cm.update(catsCategory));
    }

    public static void testFindById(CategoryManager cm) {
        System.out.println(cm.findByCategoryId("CATS"));
    }

}
