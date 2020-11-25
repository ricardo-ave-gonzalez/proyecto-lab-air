package com.deverlop.java.test;

import com.deverlop.java.model.Aerolinea;
import com.deverlop.java.components.ContenedorJPA;
import com.deverlop.java.model.Aeropuerto;
import com.deverlop.java.repositories.interfaces.I_AerolineaRepository;
import com.deverlop.java.repositories.jpa.AerolineaRepository;
import static com.deverlop.java.utiles.Utiles.genId;
import static com.deverlop.java.utiles.Utiles.ver;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author richie
 */
public class TestAerolinea {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");
        I_AerolineaRepository ar = new AerolineaRepository(emf);
        ContenedorJPA contenedorJPA = new ContenedorJPA();
        EntityManager em = contenedorJPA.getEntityManager();
        
        Aeropuerto AA = em.find(Aeropuerto.class, "37056034-beac-47d7-8d8e-b59ad348be98");
        Aeropuerto JorgeNewbery = em.find(Aeropuerto.class, "e7024fd2-e6aa-47e7-a9ad-92c0951887c4");
        Aeropuerto ezeiza = em.find(Aeropuerto.class, "658f81fd-686b-469a-a4d3-b9c6fe75bc04");
        Aeropuerto palomar = em.find(Aeropuerto.class, "5f748e2a-1998-4caf-9b88-23589f4c95fe");
        //================================================================================================
        Aerolinea aerolinea = new Aerolinea(genId(), "Aerolineas Argentinas", AA);
        Aerolinea aerolinea2 = new Aerolinea(genId(), "Austral Líneas Aéreas", JorgeNewbery);
        Aerolinea aerolinea3 = new Aerolinea(genId(), "Andes Líneas Aéreas", JorgeNewbery);
        Aerolinea aerolinea4 = new Aerolinea(genId(), "Flybondi", palomar);
        Aerolinea aerolinea5 = new Aerolinea(genId(), "JetSmart Chile", palomar);
        Aerolinea aerolinea6 = new Aerolinea(genId(), "JetSmart Argentina", palomar);
        Aerolinea aerolinea7 = new Aerolinea(genId(), "Aerolíneas Argentinas", ezeiza);
        Aerolinea aerolinea8 = new Aerolinea(genId(), "Air Canada", ezeiza);
        Aerolinea aerolinea9 = new Aerolinea(genId(), "Air Europa", ezeiza);
        Aerolinea aerolinea10 = new Aerolinea(genId(), "Air Francea", ezeiza);
        ar.save(aerolinea);
        ar.save(aerolinea2);
        ar.save(aerolinea3);
        ar.save(aerolinea4);
        ar.save(aerolinea5);
        ar.save(aerolinea6);
        ar.save(aerolinea7);
        ar.save(aerolinea8);
        ar.save(aerolinea9);
        ar.save(aerolinea10);
        ver(aerolinea2);
        ver(aerolinea3);
        ver(aerolinea4);
        ver(aerolinea5);
        ver(aerolinea6);
        ver(aerolinea7);
        ver(aerolinea8);
        ver(aerolinea9);
        ver(aerolinea10);
        
    }
    
}
