package com.deverlop.java.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author richie
 */
@Entity
@Table(name = "Avion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avion.findAll", query = "SELECT a FROM Avion a"),
    @NamedQuery(name = "Avion.findByCodeAvion", query = "SELECT a FROM Avion a WHERE a.codeAvion = :codeAvion"),
    @NamedQuery(name = "Avion.findByModelo", query = "SELECT a FROM Avion a WHERE a.modelo = :modelo"),
    @NamedQuery(name = "Avion.findByCapacidad", query = "SELECT a FROM Avion a WHERE a.capacidad = :capacidad")})
public class Avion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "codeAvion")
    private String codeAvion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "capacidad")
    private String capacidad;
    @JoinColumn(name = "codeAerolinea", referencedColumnName = "codeAerolinea")
    @ManyToOne(optional = false)
    private Aerolinea codeAerolinea;

    public Avion() {
    }

    public Avion(String modelo, String capacidad, Aerolinea codeAerolinea) {
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.codeAerolinea = codeAerolinea;
    }

    public Avion(String codeAvion, String modelo, String capacidad, Aerolinea codeAerolinea) {
        this.codeAvion = codeAvion;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.codeAerolinea = codeAerolinea;
    }

    public String getCodeAvion() {
        return codeAvion;
    }

    public void setCodeAvion(String codeAvion) {
        this.codeAvion = codeAvion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public Aerolinea getCodeAerolinea() {
        return codeAerolinea;
    }

    public void setCodeAerolinea(Aerolinea codeAerolinea) {
        this.codeAerolinea = codeAerolinea;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeAvion != null ? codeAvion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avion)) {
            return false;
        }
        Avion other = (Avion) object;
        if ((this.codeAvion == null && other.codeAvion != null) || (this.codeAvion != null && !this.codeAvion.equals(other.codeAvion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Avion{" + "codeAvion=" + codeAvion + ", modelo=" + modelo + ", capacidad=" + capacidad + ", codeAerolinea=" + codeAerolinea + '}';
    }

}
