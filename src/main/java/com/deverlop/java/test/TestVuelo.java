package com.deverlop.java.test;

import com.deverlop.java.components.ContenedorJPA;
import com.deverlop.java.model.Aeropuerto;
import com.deverlop.java.model.Vuelo;
import com.deverlop.java.repositories.interfaces.I_VueloRepository;
import com.deverlop.java.repositories.jpa.VueloRepository;
import static com.deverlop.java.utiles.Utiles.genId;
import static com.deverlop.java.utiles.Utiles.ver;
import java.time.Instant;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author richie
 */
public class TestVuelo {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");
        ContenedorJPA contenedorJPA = new ContenedorJPA();
        EntityManager em = contenedorJPA.getEntityManager();
        I_VueloRepository vr = new VueloRepository(emf);
        
        Aeropuerto AA = em.find(Aeropuerto.class, "37056034-beac-47d7-8d8e-b59ad348be98");
        Aeropuerto JorgeNewbery = em.find(Aeropuerto.class, "e7024fd2-e6aa-47e7-a9ad-92c0951887c4");
        Aeropuerto ezeiza = em.find(Aeropuerto.class, "658f81fd-686b-469a-a4d3-b9c6fe75bc04");
        Aeropuerto palomar = em.find(Aeropuerto.class, "5f748e2a-1998-4caf-9b88-23589f4c95fe");
        
        Date fecha=new Date("2020/11/03 13:30:00");
        
        Vuelo vuelo = new Vuelo(genId(), fecha, fecha, palomar, ezeiza);
        vr.save(vuelo);
        ver(vuelo);
        
    }
}
