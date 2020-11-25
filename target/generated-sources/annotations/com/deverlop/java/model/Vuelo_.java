package com.deverlop.java.model;

import com.deverlop.java.model.Aeropuerto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-11-11T18:55:16")
@StaticMetamodel(Vuelo.class)
public class Vuelo_ { 

    public static volatile SingularAttribute<Vuelo, Aeropuerto> salidaAeropuerto;
    public static volatile SingularAttribute<Vuelo, Aeropuerto> destinoAeropuerto;
    public static volatile SingularAttribute<Vuelo, String> codeVuelo;
    public static volatile SingularAttribute<Vuelo, Date> datetimeSalida;
    public static volatile SingularAttribute<Vuelo, Date> datetimeArrival;

}