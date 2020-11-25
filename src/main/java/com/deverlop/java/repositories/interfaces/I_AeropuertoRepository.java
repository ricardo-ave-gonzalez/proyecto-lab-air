package com.deverlop.java.repositories.interfaces;

import com.deverlop.java.model.Aeropuerto;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author richie
 */
public interface I_AeropuertoRepository {
    void save(Aeropuerto aeropuerto);
    void remove(Aeropuerto aeropuerto);
    void update(Aeropuerto aeropuerto);
    List<Aeropuerto> getAll();
    default Stream<Aeropuerto> getStream(){
        return getAll().stream();
    }
}
