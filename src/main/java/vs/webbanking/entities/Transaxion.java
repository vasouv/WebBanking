package vs.webbanking.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vasouv
 */
@Entity
@Table(name = "TRANSAXIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaxion.findAll", query = "SELECT t FROM Transaxion t")
    , @NamedQuery(name = "Transaxion.findByTxid", query = "SELECT t FROM Transaxion t WHERE t.txid = :txid")
    , @NamedQuery(name = "Transaxion.findByTxdate", query = "SELECT t FROM Transaxion t WHERE t.txdate = :txdate")
    , @NamedQuery(name = "Transaxion.findByAmount", query = "SELECT t FROM Transaxion t WHERE t.amount = :amount")
    , @NamedQuery(name = "Transaxion.findByBalance", query = "SELECT t FROM Transaxion t WHERE t.balance = :balance")
    , @NamedQuery(name = "Transaxion.findByDescription", query = "SELECT t FROM Transaxion t WHERE t.description = :description")})
public class Transaxion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TXID")
    private Integer txid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TXDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date txdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BALANCE")
    private double balance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "ACCOUNTID", referencedColumnName = "ACCID")
    @ManyToOne(optional = false)
    private Account accountid;

    public Transaxion() {
    }

    public Transaxion(Integer txid) {
        this.txid = txid;
    }

    public Transaxion(Integer txid, Date txdate, double amount, double balance, String description) {
        this.txid = txid;
        this.txdate = txdate;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Integer getTxid() {
        return txid;
    }

    public void setTxid(Integer txid) {
        this.txid = txid;
    }

    public Date getTxdate() {
        return txdate;
    }

    public void setTxdate(Date txdate) {
        this.txdate = txdate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccountid() {
        return accountid;
    }

    public void setAccountid(Account accountid) {
        this.accountid = accountid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (txid != null ? txid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaxion)) {
            return false;
        }
        Transaxion other = (Transaxion) object;
        if ((this.txid == null && other.txid != null) || (this.txid != null && !this.txid.equals(other.txid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vs.webbanking.entities.Transaxion[ txid=" + txid + " ]";
    }
    
}
