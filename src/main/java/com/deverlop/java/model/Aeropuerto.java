package com.deverlop.java.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Aeropuerto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aeropuerto.findAll", query = "SELECT a FROM Aeropuerto a"),
    @NamedQuery(name = "Aeropuerto.findByCodeAeropuerto", query = "SELECT a FROM Aeropuerto a WHERE a.codeAeropuerto = :codeAeropuerto"),
    @NamedQuery(name = "Aeropuerto.findByNameAeropuerto", query = "SELECT a FROM Aeropuerto a WHERE a.nameAeropuerto = :nameAeropuerto"),
    @NamedQuery(name = "Aeropuerto.findByCiudad", query = "SELECT a FROM Aeropuerto a WHERE a.ciudad = :ciudad"),
    @NamedQuery(name = "Aeropuerto.findByPais", query = "SELECT a FROM Aeropuerto a WHERE a.pais = :pais")})
public class Aeropuerto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "codeAeropuerto")
    private String codeAeropuerto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NameAeropuerto")
    private String nameAeropuerto;
    @Size(max = 32)
    @Column(name = "Ciudad")
    private String ciudad;
    @Size(max = 32)
    @Column(name = "Pais")
    private String pais;

    public Aeropuerto() {
    }

    public Aeropuerto(String codeAeropuerto, String nameAeropuerto, String ciudad, String pais) {
        this.codeAeropuerto = codeAeropuerto;
        this.nameAeropuerto = nameAeropuerto;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public Aeropuerto(String nameAeropuerto, String ciudad, String pais) {
        this.nameAeropuerto = nameAeropuerto;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public String getCodeAeropuerto() {
        return codeAeropuerto;
    }

    public void setCodeAeropuerto(String codeAeropuerto) {
        this.codeAeropuerto = codeAeropuerto;
    }

    public String getNameAeropuerto() {
        return nameAeropuerto;
    }

    public void setNameAeropuerto(String nameAeropuerto) {
        this.nameAeropuerto = nameAeropuerto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeAeropuerto != null ? codeAeropuerto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aeropuerto)) {
            return false;
        }
        Aeropuerto other = (Aeropuerto) object;
        if ((this.codeAeropuerto == null && other.codeAeropuerto != null) || (this.codeAeropuerto != null && !this.codeAeropuerto.equals(other.codeAeropuerto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aeropuerto{" + "codeAeropuerto=" + codeAeropuerto + ", nameAeropuerto=" + nameAeropuerto + ", ciudad=" + ciudad + ", pais=" + pais + '}';
    }
    
}
