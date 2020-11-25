package com.deverlop.java.test;
import com.deverlop.java.model.Aeropuerto;
import com.deverlop.java.repositories.interfaces.I_AeropuertoRepository;
import com.deverlop.java.repositories.jpa.AeropuertoRepository;
import static com.deverlop.java.utiles.Utiles.genId;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestAeropuerto {

    public static EntityManager em;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");
        I_AeropuertoRepository ar = new AeropuertoRepository(emf);
        //EntityManager em = contenedorJPA.getEntityManager();
         Aeropuerto aeropuerto = new Aeropuerto(
                    genId(),
                    "Aeropuertos Argentina 2000 S.A.",
                    "Capital Federal", "Argentina");
            Aeropuerto aeropuerto1 = new Aeropuerto(genId(),
                    "Aeroparque Internacional Jorge Newbery",
                    "Capital Federal", "Argentina");
            Aeropuerto aeropuerto2 = new Aeropuerto(genId(),
                    "Ezeiza International Airport",
                    "Ezeiza", "Argentina");
            Aeropuerto aeropuerto3 = new Aeropuerto(genId(),
                    "Aeropuerto El Palomar",
                    "El Palomar", "Argentina");
            System.out.println(aeropuerto);
            System.out.println(aeropuerto1);
            System.out.println(aeropuerto2);
            System.out.println(aeropuerto3);
            ar.save(aeropuerto);
            ar.save(aeropuerto1);
            ar.save(aeropuerto2);
            ar.save(aeropuerto3);
    }
}
