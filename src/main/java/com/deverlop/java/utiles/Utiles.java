package com.deverlop.java.utiles;

import org.apache.commons.io.FileUtils;

import javax.persistence.EntityTransaction;
import java.io.File;
import java.util.UUID;

interface CorrerSinChequearEx {
    void run() throws Exception;
}

public class Utiles {
    public static String genId() {
        return UUID.randomUUID().toString();
    }
    public static void ver(Object ...params) {
        for (Object o : params) {
            System.out.println(o);
        }
    }
    public static void throwIfTrue(Boolean condicion, String mensaje) {
        if (condicion) {
            throw new RuntimeException(mensaje);
        }
    }
    public static void throwIfTrue(Boolean condicion, RuntimeException ex) {
        if (condicion) {
            throw ex;
        }
    }
    public static void dormir(int ds) {
        try { Thread.sleep(ds*100); } catch (Exception ex) {}
    }
    public static int[] crearArray(int cantidad) {
        int[] intArray = new int[cantidad];
        for (int x=0; x < cantidad;x++) {
            intArray[x] = x;
        }
        return intArray;
    }
    public static void tryCatch(EntityTransaction tx, Runnable porcionCodigo) {
        try {
            tx.begin();
            porcionCodigo.run();
            tx.commit();
        }
        catch (Exception ex) {
            ver("Se produjo un error: ", ex.getMessage());
            try { tx.rollback(); } catch (Exception ex2) {}
        }
    }
    public static void tryCatch(Runnable porcionCodigo) {
        try {
            ver("Voy a realizar una consulta");
            porcionCodigo.run();
            ver("Fin realizacion consulta exitosa");
        }
        catch (Exception ex) {
            ver("Se produjo un error: ", ex.getMessage());
        }
    }
    public static void intentar(Runnable porcionCodigo, String mensaje) {
        try {
            porcionCodigo.run();
        }
        catch (Exception ex) {
            throw new RuntimeException(mensaje);
        }
    }
    public static void deschequear(CorrerSinChequearEx correrSinChequearEx) {
        try {
            correrSinChequearEx.run();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void toFile(String ...texto) {
        String todoElTexto = String.join(" - ",texto);
        String url = "/home/richie/Hibernate/clase3/output.log";

        deschequear(()->{
            System.out.println(todoElTexto);
            FileUtils.write(new File(url), todoElTexto, "utf-8", true);
            FileUtils.write(new File(url), System.lineSeparator(), "utf-8", true);
        });
    }
}
