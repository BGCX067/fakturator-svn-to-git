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
@Table(name = "forma_uhrady")
@NamedQueries({
    @NamedQuery(name = "FormaUhrady.findAll", query = "SELECT f FROM FormaUhrady f"),
    @NamedQuery(name = "FormaUhrady.findById", query = "SELECT f FROM FormaUhrady f WHERE f.id = :id"),
    @NamedQuery(name = "FormaUhrady.findByNazov", query = "SELECT f FROM FormaUhrady f WHERE f.nazov = :nazov")})
public class FormaUhrady implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nazov")
    private String nazov;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaUhrady")
    private Collection<Faktura> fakturaCollection;

    public FormaUhrady() {
    }

    public FormaUhrady(Integer id) {
        this.id = id;
    }

    public FormaUhrady(Integer id, String nazov) {
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
        if (!(object instanceof FormaUhrady)) {
            return false;
        }
        FormaUhrady other = (FormaUhrady) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.FormaUhrady[id=" + id + "]";
    }

}
