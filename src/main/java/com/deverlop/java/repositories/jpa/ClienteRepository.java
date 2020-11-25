package com.deverlop.java.repositories.jpa;

import com.deverlop.java.model.Cliente;
import com.deverlop.java.repositories.interfaces.I_ClienteRepository;
import static com.deverlop.java.utiles.Utiles.ver;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author richie
 */
public class ClienteRepository implements I_ClienteRepository{
    
    private EntityManagerFactory emf;

    public ClienteRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public void save(Cliente cliente) {
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try  {
            if(cliente==null) return;
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            em.close(); 
        } catch (Exception ex) {
            ver("Se produjo un error: ", ex.getMessage());
            try { tx.rollback(); } catch (Exception ex2) {} 
        } 
    }

    @Override
    public void remove(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
