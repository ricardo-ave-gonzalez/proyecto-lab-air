package com.deverlop.java.repositories.interfaces;

import com.deverlop.java.model.Ticket;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author richie
 */
public interface I_TicketRepository {
    void save(Ticket ticket);
    void remove(Ticket ticket);
    void update(Ticket ticket);
    List<Ticket> getAll();
    default Stream<Ticket> getStream(){
        return getAll().stream();
    }
}
