package com.deverlop.java.repositories.jpa;

import com.deverlop.java.model.Avion;
import com.deverlop.java.repositories.interfaces.I_AvionRepository;
import static com.deverlop.java.utiles.Utiles.ver;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author richie
 */
public class AvionRepository implements I_AvionRepository{

    private EntityManagerFactory emf;

    public AvionRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public void save(Avion avion) {
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try  {
            if(avion==null) return;
            em.getTransaction().begin();
            em.persist(avion);
            em.getTransaction().commit();
            em.close(); 
        } catch (Exception ex) {
            ver("Se produjo un error: ", ex.getMessage());
            try { tx.rollback(); } catch (Exception ex2) {} 
        }   
    }

    @Override
    public void remove(Avion avion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Avion avion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Avion> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
