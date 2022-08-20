## Examples for verifying cross JPA-PU transactions ##

* SLSB Service 1: CategoryManager backed by a standalone JPA PU
* SLSB Service 2: ProductManager backed by a standalone JPA PU
* SLCB Service 3: IntegrationService

A client triggers the invoke() method of the IntegrationService remotely. Then, The invoke() method calls 
CategoryManager.update() and ProductManager.update(). Two cases:
1. the operations are completed without errors, can observe that the values are changed in DB
2. uncomment the "somethingWrong()" method in IntegrationService.invoke(). Both modifications are withdrawn.

The IntegrationService.recover() can be used to recover the database back to the original states.

### Findings ###
* Once ejb-jar.xml is used; All resource injections are disabled.
* There is some problems when using @Inject (CDI). So we use @Resource(lookup="...") to bind the callee session beans.
* Many problems when using jakarta's namespace; So we fall back to verify the tx issues using javax namespace for now.
* JBoss EAP 7.4 use Hibernate 5.3.20.Final; It is better to develop Apps using this version. Here is a complete list of JBosss EAP component versions: https://access.redhat.com/articles/112673 
