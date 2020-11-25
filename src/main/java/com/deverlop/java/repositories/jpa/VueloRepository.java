package com.deverlop.java.repositories.jpa;

import com.deverlop.java.model.Vuelo;
import com.deverlop.java.repositories.interfaces.I_VueloRepository;
import static com.deverlop.java.utiles.Utiles.ver;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author richie
 */
public class VueloRepository implements I_VueloRepository{

    private EntityManagerFactory emf;

    public VueloRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public void save(Vuelo vuelo) {
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try  {
            if(vuelo==null) return;
            em.getTransaction().begin();
            em.persist(vuelo);
            em.getTransaction().commit();
            em.close(); 
        } catch (Exception ex) {
            ver("Se produjo un error: ", ex.getMessage());
            try { tx.rollback(); } catch (Exception ex2) {} 
        }
    }

    @Override
    public void remove(Vuelo vuelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Vuelo vuelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vuelo> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
