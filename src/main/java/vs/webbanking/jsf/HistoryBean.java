package vs.webbanking.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import vs.webbanking.entities.Transaxion;
import vs.webbanking.session.AccountController;

/**
 *
 * @author vasouv
 */
@Named
@SessionScoped
public class HistoryBean implements Serializable {

    private double balance;
    private List<Transaxion> transaxionList;
    
    @EJB
    private AccountController accCon;

    public HistoryBean() {
        balance = 0.0;
        transaxionList = new ArrayList();
    }

    @PostConstruct
    public void init() {
        balance = accCon.getBalance("chris");
        transaxionList.addAll(accCon.getHistory("chris"));
        System.out.println(transaxionList.size());
    }

    public double getBalance() {
        return accCon.getBalance("chris");
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaxion> getTransaxionList() {
        return accCon.getHistory("chris");
    }

    public void setTransaxionList(List<Transaxion> transaxionList) {
        this.transaxionList = transaxionList;
    }

}
