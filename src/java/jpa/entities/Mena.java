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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Frapko
 */
@Entity
@Table(name = "mena")
@NamedQueries({
    @NamedQuery(name = "Mena.findAll", query = "SELECT m FROM Mena m"),
    @NamedQuery(name = "Mena.findById", query = "SELECT m FROM Mena m WHERE m.id = :id"),
    @NamedQuery(name = "Mena.findByNazov", query = "SELECT m FROM Mena m WHERE m.nazov = :nazov"),
    @NamedQuery(name = "Mena.findByZnacka", query = "SELECT m FROM Mena m WHERE m.znacka = :znacka")})
public class Mena implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nazov")
    private String nazov;
    @Basic(optional = false)
    @Column(name = "znacka")
    private String znacka;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mena")
    private Collection<Faktura> fakturaCollection;

    public Mena() {
    }

    public Mena(Integer id) {
        this.id = id;
    }

    public Mena(Integer id, String nazov, String znacka) {
        this.id = id;
        this.nazov = nazov;
        this.znacka = znacka;
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

    public String getZnacka() {
        return znacka;
    }

    public void setZnacka(String znacka) {
        this.znacka = znacka;
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
        if (!(object instanceof Mena)) {
            return false;
        }
        Mena other = (Mena) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Mena[id=" + id + "]";
    }

}
