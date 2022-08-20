package tdcc.service;

import tdcc.product.Product;
import tdcc.product.ProductManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class TestInContainerTransaction {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
        InitialContext ic;
        ic = new InitialContext(properties);
        IntegrationService service = (IntegrationService) ic.lookup("ejb3-tx-1.0-SNAPSHOT/IntegrationServiceBean!tdcc.service.IntegrationService");
        //service.invoke();
        //service.recover();
    }



}
