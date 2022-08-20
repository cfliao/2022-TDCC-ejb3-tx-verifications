package tdcc.product;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class TestInContainerProduct {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
        InitialContext ic;
        ic = new InitialContext(properties);
        ProductManager pm = (ProductManager) ic.lookup("/ejb3-tx-1.0-SNAPSHOT/ProductManagerBean!tdcc.product.ProductManager");
        //testUpdate(pm);
        //recoverUpdate(pm);
        testFindById(pm);
    }

    public static void testUpdate(ProductManager cm) {
        Product p = cm.findById("AV-SB-02");
        p.setName("Finch1");
        System.out.println(cm.update(p));
    }

    public static void recoverUpdate(ProductManager cm) {
        Product p = cm.findById("AV-SB-02");
        p.setName("Finch");
        System.out.println(cm.update(p));
    }


    public static void testFindById(ProductManager pm) {
        System.out.println(pm.findById("AV-CB-01"));
    }


}
