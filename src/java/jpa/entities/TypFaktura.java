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
@Table(name = "typ_faktura")
@NamedQueries({
    @NamedQuery(name = "TypFaktura.findAll", query = "SELECT t FROM TypFaktura t"),
    @NamedQuery(name = "TypFaktura.findById", query = "SELECT t FROM TypFaktura t WHERE t.id = :id"),
    @NamedQuery(name = "TypFaktura.findByNazov", query = "SELECT t FROM TypFaktura t WHERE t.nazov = :nazov")})
public class TypFaktura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nazov")
    private String nazov;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typFaktura")
    private Collection<Faktura> fakturaCollection;

    public TypFaktura() {
    }

    public TypFaktura(Integer id) {
        this.id = id;
    }

    public TypFaktura(Integer id, String nazov) {
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
        if (!(object instanceof TypFaktura)) {
            return false;
        }
        TypFaktura other = (TypFaktura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TypFaktura[id=" + id + "]";
    }

}
