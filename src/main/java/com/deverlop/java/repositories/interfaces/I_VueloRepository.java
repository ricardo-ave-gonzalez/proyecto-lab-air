package com.deverlop.java.repositories.interfaces;

import com.deverlop.java.model.Vuelo;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author richie
 */
public interface I_VueloRepository {
    void save(Vuelo vuelo);
    void remove(Vuelo vuelo);
    void update(Vuelo vuelo);
    List<Vuelo> getAll();
    default Stream<Vuelo> getStream(){
        return getAll().stream();
    }
}
