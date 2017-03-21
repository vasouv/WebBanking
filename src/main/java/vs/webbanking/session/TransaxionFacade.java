package vs.webbanking.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import vs.webbanking.entities.Transaxion;

/**
 *
 * @author vasouv
 */
@Stateless
public class TransaxionFacade extends AbstractFacade<Transaxion> {

    @PersistenceContext(unitName = "vs_WebBanking_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaxionFacade() {
        super(Transaxion.class);
    }
    
    public List<Transaxion> findTransaxionsByAccountName(String name) {
        List<Transaxion> tr = em.createQuery("SELECT tr FROM Transaxion tr WHERE tr.accountid.owner = :ownerName")
                .setParameter("ownerName", name)
                .getResultList();
        System.out.println("EJB transaxions retrieved: " + tr.size());
        return tr;
    }
    
    public List<Transaxion> findDefaultTransaxions() {
        List<Transaxion> tr = em.createQuery("SELECT tr FROM Transaxion tr")
                .getResultList();
        System.out.println("EJB transaxions retrieved: " + tr.size());
        return tr;
    }
    
}
