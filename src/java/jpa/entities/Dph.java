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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Frapko
 */
@Entity
@Table(name = "dph")
@NamedQueries({
    @NamedQuery(name = "Dph.findAll", query = "SELECT d FROM Dph d"),
    @NamedQuery(name = "Dph.findById", query = "SELECT d FROM Dph d WHERE d.id = :id"),
    @NamedQuery(name = "Dph.findByNazov", query = "SELECT d FROM Dph d WHERE d.nazov = :nazov"),
    @NamedQuery(name = "Dph.findByHodnota", query = "SELECT d FROM Dph d WHERE d.hodnota = :hodnota")})
public class Dph implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nazov")
    private String nazov;
    @Basic(optional = false)
    @Column(name = "hodnota")
    private short hodnota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dph")
    private Collection<Tovar> tovarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dph")
    private Collection<RiadokFaktury> riadokFakturyCollection;

    public Dph() {
    }

    public Dph(Integer id) {
        this.id = id;
    }

    public Dph(Integer id, String nazov, short hodnota) {
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

    public short getHodnota() {
        return hodnota;
    }

    public void setHodnota(short hodnota) {
        this.hodnota = hodnota;
    }

    public Collection<Tovar> getTovarCollection() {
        return tovarCollection;
    }

    public void setTovarCollection(Collection<Tovar> tovarCollection) {
        this.tovarCollection = tovarCollection;
    }

    public Collection<RiadokFaktury> getRiadokFakturyCollection() {
        return riadokFakturyCollection;
    }

    public void setRiadokFakturyCollection(Collection<RiadokFaktury> riadokFakturyCollection) {
        this.riadokFakturyCollection = riadokFakturyCollection;
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
        if (!(object instanceof Dph)) {
            return false;
        }
        Dph other = (Dph) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Dph[id=" + id + "]";
    }

}
