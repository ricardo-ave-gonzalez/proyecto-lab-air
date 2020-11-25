package com.deverlop.java.repositories.jpa;

import com.deverlop.java.model.Aeropuerto;
import com.deverlop.java.repositories.interfaces.I_AeropuertoRepository;
import static com.deverlop.java.utiles.Utiles.ver;
import java.util.List;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class AeropuertoRepository implements I_AeropuertoRepository{
    
    private EntityManagerFactory emf;

    public AeropuertoRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public void save(Aeropuerto aeropuerto) {
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try  {
            if(aeropuerto==null) return;
            em.getTransaction().begin();
            em.persist(aeropuerto);
            em.getTransaction().commit();
            em.close(); 
        } catch (Exception ex) {
            ver("Se produjo un error: ", ex.getMessage());
            try { tx.rollback(); } catch (Exception ex2) {} 
        }   
    }

    @Override
    public void remove(Aeropuerto aeropuerto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Aeropuerto aeropuerto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aeropuerto> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stream<Aeropuerto> getStream() {
        return I_AeropuertoRepository.super.getStream(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
