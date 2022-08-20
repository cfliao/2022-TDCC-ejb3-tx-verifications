package tdcc.service;

import javax.ejb.Remote;

@Remote
public interface IntegrationService {
    public void invoke();
    public void recover();
}
