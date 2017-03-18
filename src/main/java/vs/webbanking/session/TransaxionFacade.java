package vs.webbanking.session;

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
    
}
