package com.deverlop.java.repositories.interfaces;

import com.deverlop.java.model.Cliente;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author richie
 */
public interface I_ClienteRepository {
    void save(Cliente cliente);
    void remove(Cliente cliente);
    void update(Cliente cliente);
    List<Cliente> getAll();
    default Stream<Cliente> getStream(){
        return getAll().stream();
    }
}
