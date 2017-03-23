package vs.webbanking.session;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import vs.webbanking.entities.Account;
import vs.webbanking.entities.Transaxion;

/**
 *
 * @author vasouv
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> {

    @PersistenceContext(unitName = "vs_WebBanking_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }
    
    public double getBalance(String ownerName) {
        Account acc = (Account) em.createNamedQuery("Account.findByOwner")
                .setParameter("owner", ownerName)
                .getSingleResult();
        
        return acc.getBalance();
    }
    
    public Account find(String ownerName) {
        Account acc = (Account) em.createNamedQuery("Account.findByOwner")
                .setParameter("owner", ownerName)
                .getSingleResult();
        
        return acc;
    }
    
    public boolean hasCapacityLimit(String ownerName){
        Account acc = find(ownerName);
        return acc.getCapacity() != 0.0;
    }
    
}
