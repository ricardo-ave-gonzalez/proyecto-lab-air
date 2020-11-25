/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "Cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCodeCliente", query = "SELECT c FROM Cliente c WHERE c.codeCliente = :codeCliente"),
    @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Cliente.findBySexo", query = "SELECT c FROM Cliente c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Cliente.findByCategoria", query = "SELECT c FROM Cliente c WHERE c.categoria = :categoria")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "codeCliente")
    private String codeCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 9)
    @Column(name = "sexo")
    private String sexo;
    @Size(max = 15)
    @Column(name = "categoria")
    private String categoria;
    @JoinColumn(name = "codeAvion", referencedColumnName = "codeAvion")
    @ManyToOne(optional = false)
    private Avion codeAvion;
    @JoinColumn(name = "codeVuelo", referencedColumnName = "codeVuelo")
    @ManyToOne(optional = false)
    private Vuelo codeVuelo;

    public Cliente() {
    }

    public Cliente(String codeCliente) {
        this.codeCliente = codeCliente;
    }

    public Cliente(String nombre, String apellido, String telefono, String sexo, String categoria, Avion codeAvion, Vuelo codeVuelo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.sexo = sexo;
        this.categoria = categoria;
        this.codeAvion = codeAvion;
        this.codeVuelo = codeVuelo;
    }

    public Cliente(String codeCliente, String nombre, String apellido, String telefono, String sexo, String categoria, Avion codeAvion, Vuelo codeVuelo) {
        this.codeCliente = codeCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.sexo = sexo;
        this.categoria = categoria;
        this.codeAvion = codeAvion;
        this.codeVuelo = codeVuelo;
    }

    public String getCodeCliente() {
        return codeCliente;
    }

    public void setCodeCliente(String codeCliente) {
        this.codeCliente = codeCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Avion getCodeAvion() {
        return codeAvion;
    }

    public void setCodeAvion(Avion codeAvion) {
        this.codeAvion = codeAvion;
    }

    public Vuelo getCodeVuelo() {
        return codeVuelo;
    }

    public void setCodeVuelo(Vuelo codeVuelo) {
        this.codeVuelo = codeVuelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeCliente != null ? codeCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codeCliente == null && other.codeCliente != null) || (this.codeCliente != null && !this.codeCliente.equals(other.codeCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codeCliente=" + codeCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", sexo=" + sexo + ", categoria=" + categoria + ", codeAvion=" + codeAvion + ", codeVuelo=" + codeVuelo + '}';
    }
    
}
