package vs.webbanking.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vasouv
 */
@Entity
@Table(name = "ACCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByAccid", query = "SELECT a FROM Account a WHERE a.accid = :accid")
    , @NamedQuery(name = "Account.findByOwner", query = "SELECT a FROM Account a WHERE a.owner = :owner")
    , @NamedQuery(name = "Account.findByCapacity", query = "SELECT a FROM Account a WHERE a.capacity = :capacity")
    , @NamedQuery(name = "Account.findByBalance", query = "SELECT a FROM Account a WHERE a.balance = :balance")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCID")
    private Integer accid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "OWNER")
    private String owner;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACITY")
    private double capacity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BALANCE")
    private double balance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toaccount")
    private List<Transaxion> transaxionsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromaccount")
    private List<Transaxion> transaxionsList1;

    public Account() {
    }

    public Account(Integer accid) {
        this.accid = accid;
    }

    public Account(Integer accid, String owner, double capacity, double balance) {
        this.accid = accid;
        this.owner = owner;
        this.capacity = capacity;
        this.balance = balance;
    }

    public Integer getAccid() {
        return accid;
    }

    public void setAccid(Integer accid) {
        this.accid = accid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @XmlTransient
    public List<Transaxion> getTransaxionsList() {
        return transaxionsList;
    }

    public void setTransaxionsList(List<Transaxion> transaxionsList) {
        this.transaxionsList = transaxionsList;
    }

    @XmlTransient
    public List<Transaxion> getTransaxionsList1() {
        return transaxionsList1;
    }

    public void setTransaxionsList1(List<Transaxion> transaxionsList1) {
        this.transaxionsList1 = transaxionsList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accid != null ? accid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accid == null && other.accid != null) || (this.accid != null && !this.accid.equals(other.accid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vs.webbanking.entities.Account[ accid=" + accid + " ]";
    }
    
}
