package com.deverlop.java.test;

import com.deverlop.java.components.ContenedorJPA;
import com.deverlop.java.model.Aerolinea;
import com.deverlop.java.model.Avion;
import com.deverlop.java.repositories.interfaces.I_AvionRepository;
import com.deverlop.java.repositories.jpa.AvionRepository;
import static com.deverlop.java.utiles.Utiles.genId;
import static com.deverlop.java.utiles.Utiles.ver;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author richie
 */
public class TestAvion {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");
        I_AvionRepository ar = new AvionRepository(emf);
        ContenedorJPA contenedorJPA = new ContenedorJPA();
        EntityManager em = contenedorJPA.getEntityManager();
        
        Aerolinea flybondi = em.find(Aerolinea.class, "3eac2055-e2d4-47ee-8b35-2a3518cf6220");
        Aerolinea airEuropa = em.find(Aerolinea.class, "3d722c4d-0855-4634-9e26-3f560d4f1d2a");
        Aerolinea jetSmart = em.find(Aerolinea.class, "3b8ff412-8d51-41d9-b82e-bad55ba813ed");
        Aerolinea AA = em.find(Aerolinea.class, "0857a65e-f925-4e6e-b580-0eac1034b235");
        
        Avion avion = new Avion(genId(), "Boeing 737-800", "189", flybondi);
        Avion avion1 = new Avion(genId(), "Boeing 787", "250", airEuropa);
        Avion avion2 = new Avion(genId(), "Airbus A320", "186", jetSmart);
        Avion avion3 = new Avion(genId(), "Embraer 190", "190", AA);
        
        ar.save(avion);
        ar.save(avion1);
        ar.save(avion2);
        ar.save(avion3);
    
        ver(avion);
        ver(avion1);
        ver(avion2);
        ver(avion3);
    }
}
