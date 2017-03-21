package vs.webbanking.session;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import vs.webbanking.entities.Account;
import vs.webbanking.entities.Transaxion;

/**
 *
 * @author vasouv
 */
@Named
@Stateless
public class AccountController {
    
    @EJB
    private AccountFacade accountFacade;
    
    @EJB
    private TransaxionFacade transaxionFacade;
    
    public String deposit(double amount){
        throw new UnsupportedOperationException("deposit method not done");
    }
    
    public String withdraw(double amount){
        throw new UnsupportedOperationException("withdraw method not done");
    }
    
    public String transfer(String toAccount, double amount) {
        throw new UnsupportedOperationException("transfer method not done");
    }
    
    public double getBalance(String account) {
        return accountFacade.getBalance(account);
    }
    
    public List<Transaxion> getHistory(String account) {
        return transaxionFacade.findTransaxionsByAccountName(account);
//        return transaxionFacade.findDefaultTransaxions();
    }
    
}
