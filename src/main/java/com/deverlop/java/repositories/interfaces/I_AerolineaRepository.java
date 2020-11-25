package com.deverlop.java.repositories.interfaces;

import com.deverlop.java.model.Aerolinea;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author richie
 */
public interface I_AerolineaRepository {
    void save(Aerolinea aerolinea);
    void remove(Aerolinea aerolinea);
    void update(Aerolinea aerolinea);
    List<Aerolinea> getAll();
    default Stream<Aerolinea> getStream(){
        return getAll().stream();
    }
}
