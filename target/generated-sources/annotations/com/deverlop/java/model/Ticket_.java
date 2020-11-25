package com.deverlop.java.model;

import com.deverlop.java.model.Cliente;
import com.deverlop.java.model.Vuelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-11-11T18:55:16")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, String> tipoDePago;
    public static volatile SingularAttribute<Ticket, String> codeTicket;
    public static volatile SingularAttribute<Ticket, Cliente> codeCliente;
    public static volatile SingularAttribute<Ticket, Vuelo> codeVuelo;

}