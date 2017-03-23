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
    
    public void deposit(double amount){
        if (accountFacade.hasCapacityLimit("maik")) {
            //do deposit at once
        } else{
            //check amount to capacity
            //if amount + balance > capacity throw insufficient funds exception
            //else deposit
        }
    }
    
    public void withdraw(double amount){
        if (amount > accountFacade.getBalance("maik")) {
            //throw insufficient funds
        } else{
            //do withdraw
        }
    }
    
    public void transfer(String toAccount, double amount) {
        throw new UnsupportedOperationException("transfer method not done");
    }
    
    public double getBalance(String account) {
        return accountFacade.getBalance(account);
    }
    
    public List<Transaxion> getHistory(String account) {
        return transaxionFacade.findTransaxionsByAccountName(account);
    }
    
    public Account findAccount(String name) {
        return accountFacade.find(name);
    }
    
}
