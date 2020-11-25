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
@Table(name = "Aerolinea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aerolinea.findAll", query = "SELECT a FROM Aerolinea a"),
    @NamedQuery(name = "Aerolinea.findByCodeAerolinea", query = "SELECT a FROM Aerolinea a WHERE a.codeAerolinea = :codeAerolinea"),
    @NamedQuery(name = "Aerolinea.findByNameAerolinea", query = "SELECT a FROM Aerolinea a WHERE a.nameAerolinea = :nameAerolinea")})
public class Aerolinea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "codeAerolinea")
    private String codeAerolinea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nameAerolinea")
    private String nameAerolinea;
    @JoinColumn(name = "codeAeropuerto", referencedColumnName = "codeAeropuerto")
    @ManyToOne(optional = false)
    private Aeropuerto codeAeropuerto;

    public Aerolinea() {
    }
    
    public Aerolinea(String nameAerolinea, Aeropuerto codeAeropuerto) {
        this.nameAerolinea = nameAerolinea;
        this.codeAeropuerto = codeAeropuerto;
    }

    public Aerolinea(String codeAerolinea, String nameAerolinea, Aeropuerto codeAeropuerto) {
        this.codeAerolinea = codeAerolinea;
        this.nameAerolinea = nameAerolinea;
        this.codeAeropuerto = codeAeropuerto;
    }

    public String getCodeAerolinea() {
        return codeAerolinea;
    }

    public void setCodeAerolinea(String codeAerolinea) {
        this.codeAerolinea = codeAerolinea;
    }

    public String getNameAerolinea() {
        return nameAerolinea;
    }

    public void setNameAerolinea(String nameAerolinea) {
        this.nameAerolinea = nameAerolinea;
    }

    public Aeropuerto getCodeAeropuerto() {
        return codeAeropuerto;
    }

    public void setCodeAeropuerto(Aeropuerto codeAeropuerto) {
        this.codeAeropuerto = codeAeropuerto;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeAerolinea != null ? codeAerolinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aerolinea)) {
            return false;
        }
        Aerolinea other = (Aerolinea) object;
        if ((this.codeAerolinea == null && other.codeAerolinea != null) || (this.codeAerolinea != null && !this.codeAerolinea.equals(other.codeAerolinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aerolinea{" + "codeAerolinea=" + codeAerolinea + ", nameAerolinea=" + nameAerolinea + ", codeAeropuerto=" + codeAeropuerto + '}';
    }
    
}
