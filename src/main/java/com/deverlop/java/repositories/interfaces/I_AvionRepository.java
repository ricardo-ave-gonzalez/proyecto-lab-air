package com.deverlop.java.repositories.interfaces;

import com.deverlop.java.model.Avion;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author richie
 */
public interface I_AvionRepository {
    void save(Avion avion);
    void remove(Avion avion);
    void update(Avion avion);
    List<Avion> getAll();
    default Stream<Avion> getStream(){
        return getAll().stream();
    }
}
