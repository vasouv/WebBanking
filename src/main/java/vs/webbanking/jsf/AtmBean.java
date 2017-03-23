package vs.webbanking.jsf;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import vs.webbanking.session.AccountController;

/**
 *
 * @author vasouv
 */
@Named
@SessionScoped
public class AtmBean implements Serializable {
    
    private double amount;
    private String actionToExecute;
    private String accountName = "maik";
    
    @EJB
    private AccountController accountController;

    public AtmBean() {
        amount = 0.0;
    }
    
    public void handleAtmAction(){
        switch (actionToExecute) {
            case "deposit":
                System.out.println("Deposit selected");
                accountController.deposit(amount);
                break;
            case "withdraw":
                System.out.println("Withdraw selected");
                accountController.withdraw(amount);
                break;
            default:
                System.out.println("Please select something");
                break;
        }
    }

    /*
     * ACCESSORS 
     */
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getActionToExecute() {
        return actionToExecute;
    }

    public void setActionToExecute(String actionToExecute) {
        this.actionToExecute = actionToExecute;
    }
    
}
