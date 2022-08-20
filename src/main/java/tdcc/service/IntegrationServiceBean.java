package tdcc.service;

import tdcc.category.Category;
import tdcc.category.CategoryManager;
import tdcc.product.Product;
import tdcc.product.ProductManager;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class IntegrationServiceBean implements IntegrationService {

    @Resource(lookup = "java:app/ejb3-tx-1.0-SNAPSHOT/ProductManagerBean!tdcc.product.ProductManager")
    private ProductManager productManager;

    @Resource(lookup = "java:app/ejb3-tx-1.0-SNAPSHOT/CategoryManagerBean!tdcc.category.CategoryManager")
    private CategoryManager categoryManager;

    @Resource
    private SessionContext sessionContext;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void invoke() {
        try {
            Category birdsCategory = categoryManager.findByCategoryId("BIRDS");
            birdsCategory.setName("birds1");
            System.out.println(categoryManager.update(birdsCategory));
            //somethingWrong(); 發出錯誤
            Product finchProduct = productManager.findById("AV-SB-02");
            finchProduct.setName("Finch1");
            System.out.println(productManager.update(finchProduct));
        } catch (Exception ex) {
            sessionContext.setRollbackOnly();
            ex.printStackTrace();
        }
    }


    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void recover() {
        try {
            Category birdsCategory = categoryManager.findByCategoryId("BIRDS");
            birdsCategory.setName("birds");
            System.out.println(categoryManager.update(birdsCategory));
            Product finchProduct = productManager.findById("AV-SB-02");
            finchProduct.setName("Finch");
            System.out.println(productManager.update(finchProduct));
        } catch (Exception ex) {
            sessionContext.setRollbackOnly();
            ex.printStackTrace();
        }
    }

    public void somethingWrong() throws Exception {
        throw new Exception("Test");
    }
}
