/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Frapko
 */
@Entity
@Table(name = "projekt")
@NamedQueries({
    @NamedQuery(name = "Projekt.findAll", query = "SELECT p FROM Projekt p"),
    @NamedQuery(name = "Projekt.findById", query = "SELECT p FROM Projekt p WHERE p.id = :id"),
    @NamedQuery(name = "Projekt.findByNazov", query = "SELECT p FROM Projekt p WHERE p.nazov = :nazov")})
public class Projekt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nazov")
    private String nazov;
    @JoinColumn(name = "dodavatel_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dodavatel dodavatel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projekt")
    private Collection<Faktura> fakturaCollection;

    public Projekt() {
    }

    public Projekt(Integer id) {
        this.id = id;
    }

    public Projekt(Integer id, String nazov) {
        this.id = id;
        this.nazov = nazov;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public Dodavatel getDodavatel() {
        return dodavatel;
    }

    public void setDodavatel(Dodavatel dodavatel) {
        this.dodavatel = dodavatel;
    }

    public Collection<Faktura> getFakturaCollection() {
        return fakturaCollection;
    }

    public void setFakturaCollection(Collection<Faktura> fakturaCollection) {
        this.fakturaCollection = fakturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projekt)) {
            return false;
        }
        Projekt other = (Projekt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Projekt[id=" + id + "]";
    }

}
