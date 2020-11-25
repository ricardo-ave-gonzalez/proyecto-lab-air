package com.deverlop.java.test;

import com.deverlop.java.components.ContenedorJPA;
import com.deverlop.java.enums.categoria;
import static com.deverlop.java.enums.categoria.PRIMERA_CLASE;
import com.deverlop.java.enums.sexo;
import static com.deverlop.java.enums.sexo.MASCULINO;
import com.deverlop.java.model.Avion;
import com.deverlop.java.model.Cliente;
import com.deverlop.java.model.Vuelo;
import com.deverlop.java.repositories.interfaces.I_ClienteRepository;
import com.deverlop.java.repositories.jpa.ClienteRepository;
import static com.deverlop.java.utiles.Utiles.genId;
import static com.deverlop.java.utiles.Utiles.ver;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author richie
 */
public class TestCliente {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");
        I_ClienteRepository cr = new ClienteRepository(emf);
        ContenedorJPA contenedorJPA = new ContenedorJPA();
        EntityManager em = contenedorJPA.getEntityManager();
        
        //obtener objeto vuelo y avion
        Vuelo vuelo = em.find(Vuelo.class, "1029fd12-b820-467f-93d9-84116ac4941c");
        Avion flybondi = em.find(Avion.class, "e28381ab-c70b-4c7e-beb8-cb27c2f71356");
        
        
        Cliente cliente = new Cliente(
                genId(),
                "ricardo",
                "Gonzalez",
                "1134343434",
                "MASCULINO",
                "PRIMERA_CLASE",
                flybondi,
                vuelo
        );
        cr.save(cliente);
        ver(cliente);
        
        Cliente cliente2 = new Cliente(genId(), "Jasinto", "Ferroira", "232222", "FEMENINO","PRIMERA_CLASE",flybondi, vuelo);
        cr.save(cliente2);
        ver(cliente2);
        
        
        //Cliente{codeCliente=d04cbffa-ffd8-4d45-a9eb-c9603a61673a, nombre=ricardo, 
        //apellido=Gonzalez, telefono=1134343434, sexo=MASCULINO, categoria=PRIMERA_CLASE, codeAvion=Avion{codeAvion=e28381ab-c70b-4c7e-beb8-cb27c2f71356, 
        //modelo=Boeing 737-800, capacidad=189, codeAerolinea=Aerolinea{codeAerolinea=3eac2055-e2d4-47ee-8b35-2a3518cf6220, nameAerolinea=Flybondi, 
        //codeAeropuerto=Aeropuerto{codeAeropuerto=5f748e2a-1998-4caf-9b88-23589f4c95fe, nameAeropuerto=Aeropuerto El Palomar, ciudad=El Palomar, 
        //pais=Argentina}}}, codeVuelo=Vuelo{codeVuelo=1029fd12-b820-467f-93d9-84116ac4941c, datetimeSalida=Tue Nov 03 13:30:00 ART 2020, 
        //datetimeArrival=Tue Nov 03 13:30:00 ART 2020, destinoAeropuerto=Aeropuerto{codeAeropuerto=5f748e2a-1998-4caf-9b88-23589f4c95fe, 
        //nameAeropuerto=Aeropuerto El Palomar, ciudad=El Palomar, pais=Argentina}, salidaAeropuerto=Aeropuerto{codeAeropuerto=658f81fd-686b-469a-a4d3-b9c6fe75bc04, 
        //nameAeropuerto=Ezeiza International Airport, ciudad=Ezeiza, pais=Argentina}}}
    }
}
