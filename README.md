## Examples for verifying cross JPA-PU transactions ##

* SLSB Service 1: CategoryManager backed by a standalone JPA PU
* SLSB Service 2: ProductManager backed by a standalone JPA PU
* SLCB Service 3: IntegrationService

A client triggers the invoke() method of the IntegrationService remotely. Then, The invoke() method calls 
CategoryManager.update() and ProductManager.update(). Two cases:
1. the operations are completed without errors, can observe that the values are changed in DB
2. uncomment the "somethingWrong()" method in IntegrationService.invoke(). Both modifications are withdrawn.

The IntegrationService.recover() can be used to recover the database back to the original states.

### Observations ###
* Once ejb-jar.xml is used; All resource injections are disabled.
* There is some problems when using @Inject (CDI). So we use @Resource(lookup="...") to bind the callee session beans.
* Many problems when using jakarta's namespace; So we fallback to verify the tx issues using javax namespace for now.