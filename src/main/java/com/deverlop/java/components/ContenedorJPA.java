package com.deverlop.java.components;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContenedorJPA {

    private EntityManager entityManager;

    public ContenedorJPA() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("mariadb");
        entityManager = emf.createEntityManager();
    }

    public EntityManager getEntityManager() {

        return entityManager;
    }

}
