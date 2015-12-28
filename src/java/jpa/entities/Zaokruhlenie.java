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
@Table(name = "zaokruhlenie")
@NamedQueries({
    @NamedQuery(name = "Zaokruhlenie.findAll", query = "SELECT z FROM Zaokruhlenie z"),
    @NamedQuery(name = "Zaokruhlenie.findById", query = "SELECT z FROM Zaokruhlenie z WHERE z.id = :id"),
    @NamedQuery(name = "Zaokruhlenie.findByNazov", query = "SELECT z FROM Zaokruhlenie z WHERE z.nazov = :nazov"),
    @NamedQuery(name = "Zaokruhlenie.findByHodnota", query = "SELECT z FROM Zaokruhlenie z WHERE z.hodnota = :hodnota")})
public class Zaokruhlenie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nazov")
    private String nazov;
    @Basic(optional = false)
    @Column(name = "hodnota")
    private int hodnota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zaokruhlenie")
    private Collection<Dodavatel> dodavatelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zaokruhlenie")
    private Collection<Faktura> fakturaCollection;

    public Zaokruhlenie() {
    }

    public Zaokruhlenie(Integer id) {
        this.id = id;
    }

    public Zaokruhlenie(Integer id, String nazov, int hodnota) {
        this.id = id;
        this.nazov = nazov;
        this.hodnota = hodnota;
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

    public int getHodnota() {
        return hodnota;
    }

    public void setHodnota(int hodnota) {
        this.hodnota = hodnota;
    }

    public Collection<Dodavatel> getDodavatelCollection() {
        return dodavatelCollection;
    }

    public void setDodavatelCollection(Collection<Dodavatel> dodavatelCollection) {
        this.dodavatelCollection = dodavatelCollection;
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
        if (!(object instanceof Zaokruhlenie)) {
            return false;
        }
        Zaokruhlenie other = (Zaokruhlenie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Zaokruhlenie[id=" + id + "]";
    }

}
