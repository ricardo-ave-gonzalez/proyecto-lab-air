package com.deverlop.java.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author richie
 */
@Entity
@Table(name = "Ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findByCodeTicket", query = "SELECT t FROM Ticket t WHERE t.codeTicket = :codeTicket"),
    @NamedQuery(name = "Ticket.findByTipoDePago", query = "SELECT t FROM Ticket t WHERE t.tipoDePago = :tipoDePago")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "codeTicket")
    private String codeTicket;
    @Size(max = 11)
    @Column(name = "tipoDePago")
    private String tipoDePago;
    @JoinColumn(name = "codeCliente", referencedColumnName = "codeCliente")
    @ManyToOne(optional = false)
    private Cliente codeCliente;
    @JoinColumn(name = "codeVuelo", referencedColumnName = "codeVuelo")
    @ManyToOne(optional = false)
    private Vuelo codeVuelo;

    public Ticket() {
    }

    public Ticket(String codeTicket, String tipoDePago, Cliente codeCliente, Vuelo codeVuelo) {
        this.codeTicket = codeTicket;
        this.tipoDePago = tipoDePago;
        this.codeCliente = codeCliente;
        this.codeVuelo = codeVuelo;
    }

    public Ticket(String tipoDePago, Cliente codeCliente, Vuelo codeVuelo) {
        this.tipoDePago = tipoDePago;
        this.codeCliente = codeCliente;
        this.codeVuelo = codeVuelo;
    }

    public String getCodeTicket() {
        return codeTicket;
    }

    public void setCodeTicket(String codeTicket) {
        this.codeTicket = codeTicket;
    }

    public String getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public Cliente getCodeCliente() {
        return codeCliente;
    }

    public void setCodeCliente(Cliente codeCliente) {
        this.codeCliente = codeCliente;
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
        hash += (codeTicket != null ? codeTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.codeTicket == null && other.codeTicket != null) || (this.codeTicket != null && !this.codeTicket.equals(other.codeTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ticket{" + "codeTicket=" + codeTicket + ", tipoDePago=" + tipoDePago + ", codeCliente=" + codeCliente + ", codeVuelo=" + codeVuelo + '}';
    }
    
}
