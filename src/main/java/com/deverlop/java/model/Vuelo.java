package com.deverlop.java.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author richie
 */
@Entity
@Table(name = "Vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v"),
    @NamedQuery(name = "Vuelo.findByCodeVuelo", query = "SELECT v FROM Vuelo v WHERE v.codeVuelo = :codeVuelo"),
    @NamedQuery(name = "Vuelo.findByDatetimeSalida", query = "SELECT v FROM Vuelo v WHERE v.datetimeSalida = :datetimeSalida"),
    @NamedQuery(name = "Vuelo.findByDatetimeArrival", query = "SELECT v FROM Vuelo v WHERE v.datetimeArrival = :datetimeArrival")})
public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "codeVuelo")
    private String codeVuelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datetimeSalida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimeSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datetimeArrival")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimeArrival;
    @JoinColumn(name = "destinoAeropuerto", referencedColumnName = "codeAeropuerto")
    @ManyToOne(optional = false)
    private Aeropuerto destinoAeropuerto;
    @JoinColumn(name = "salidaAeropuerto", referencedColumnName = "codeAeropuerto")
    @ManyToOne(optional = false)
    private Aeropuerto salidaAeropuerto;

    public Vuelo() {
    }

    public Vuelo(Date datetimeSalida, Date datetimeArrival, Aeropuerto destinoAeropuerto, Aeropuerto salidaAeropuerto) {
        this.datetimeSalida = datetimeSalida;
        this.datetimeArrival = datetimeArrival;
        this.destinoAeropuerto = destinoAeropuerto;
        this.salidaAeropuerto = salidaAeropuerto;
    }

    public Vuelo(String codeVuelo, Date datetimeSalida, Date datetimeArrival, Aeropuerto destinoAeropuerto, Aeropuerto salidaAeropuerto) {
        this.codeVuelo = codeVuelo;
        this.datetimeSalida = datetimeSalida;
        this.datetimeArrival = datetimeArrival;
        this.destinoAeropuerto = destinoAeropuerto;
        this.salidaAeropuerto = salidaAeropuerto;
    }
    
    public String getCodeVuelo() {
        return codeVuelo;
    }

    public void setCodeVuelo(String codeVuelo) {
        this.codeVuelo = codeVuelo;
    }

    public Date getDatetimeSalida() {
        return datetimeSalida;
    }

    public void setDatetimeSalida(Date datetimeSalida) {
        this.datetimeSalida = datetimeSalida;
    }

    public Date getDatetimeArrival() {
        return datetimeArrival;
    }

    public void setDatetimeArrival(Date datetimeArrival) {
        this.datetimeArrival = datetimeArrival;
    }
    
    public Aeropuerto getDestinoAeropuerto() {
        return destinoAeropuerto;
    }

    public void setDestinoAeropuerto(Aeropuerto destinoAeropuerto) {
        this.destinoAeropuerto = destinoAeropuerto;
    }

    public Aeropuerto getSalidaAeropuerto() {
        return salidaAeropuerto;
    }

    public void setSalidaAeropuerto(Aeropuerto salidaAeropuerto) {
        this.salidaAeropuerto = salidaAeropuerto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeVuelo != null ? codeVuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.codeVuelo == null && other.codeVuelo != null) || (this.codeVuelo != null && !this.codeVuelo.equals(other.codeVuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "codeVuelo=" + codeVuelo + ", datetimeSalida=" + datetimeSalida + ", datetimeArrival=" + datetimeArrival + ", destinoAeropuerto=" + destinoAeropuerto + ", salidaAeropuerto=" + salidaAeropuerto + '}';
    }
    
}
