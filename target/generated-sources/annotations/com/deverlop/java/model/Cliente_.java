package com.deverlop.java.model;

import com.deverlop.java.model.Avion;
import com.deverlop.java.model.Vuelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-11-11T18:55:16")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> codeCliente;
    public static volatile SingularAttribute<Cliente, String> apellido;
    public static volatile SingularAttribute<Cliente, String> categoria;
    public static volatile SingularAttribute<Cliente, Vuelo> codeVuelo;
    public static volatile SingularAttribute<Cliente, Avion> codeAvion;
    public static volatile SingularAttribute<Cliente, String> telefono;
    public static volatile SingularAttribute<Cliente, String> sexo;
    public static volatile SingularAttribute<Cliente, String> nombre;

}