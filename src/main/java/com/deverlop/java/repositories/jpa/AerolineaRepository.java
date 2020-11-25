package com.deverlop.java.repositories.jpa;

import com.deverlop.java.model.Aerolinea;
import com.deverlop.java.repositories.interfaces.I_AerolineaRepository;
import static com.deverlop.java.utiles.Utiles.ver;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author richie
 */
public class AerolineaRepository implements I_AerolineaRepository{

    private EntityManagerFactory emf;

    public AerolineaRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public void save(Aerolinea aerolinea) {
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try  {
            if(aerolinea==null) return;
            em.getTransaction().begin();
            em.persist(aerolinea);
            em.getTransaction().commit();
            em.close(); 
        } catch (Exception ex) {
            ver("Se produjo un error: ", ex.getMessage());
            try { tx.rollback(); } catch (Exception ex2) {} 
        }
    }

    @Override
    public void remove(Aerolinea aerolinea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Aerolinea aerolinea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aerolinea> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
