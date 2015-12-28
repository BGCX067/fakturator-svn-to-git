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
@Table(name = "kategoria")
@NamedQueries({
    @NamedQuery(name = "Kategoria.findAll", query = "SELECT k FROM Kategoria k"),
    @NamedQuery(name = "Kategoria.findById", query = "SELECT k FROM Kategoria k WHERE k.id = :id"),
    @NamedQuery(name = "Kategoria.findByNazovKategorie", query = "SELECT k FROM Kategoria k WHERE k.nazovKategorie = :nazovKategorie"),
    @NamedQuery(name = "Kategoria.findByZmazana", query = "SELECT k FROM Kategoria k WHERE k.zmazana = :zmazana")})
public class Kategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nazov_kategorie")
    private String nazovKategorie;
    @Basic(optional = false)
    @Column(name = "zmazana")
    private boolean zmazana;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategoria")
    private Collection<Tovar> tovarCollection;
    @JoinColumn(name = "dodavatel_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dodavatel dodavatel;

    public Kategoria() {
    }

    public Kategoria(Integer id) {
        this.id = id;
    }

    public Kategoria(Integer id, String nazovKategorie, boolean zmazana) {
        this.id = id;
        this.nazovKategorie = nazovKategorie;
        this.zmazana = zmazana;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazovKategorie() {
        return nazovKategorie;
    }

    public void setNazovKategorie(String nazovKategorie) {
        this.nazovKategorie = nazovKategorie;
    }

    public boolean getZmazana() {
        return zmazana;
    }

    public void setZmazana(boolean zmazana) {
        this.zmazana = zmazana;
    }

    public Collection<Tovar> getTovarCollection() {
        return tovarCollection;
    }

    public void setTovarCollection(Collection<Tovar> tovarCollection) {
        this.tovarCollection = tovarCollection;
    }

    public Dodavatel getDodavatel() {
        return dodavatel;
    }

    public void setDodavatel(Dodavatel dodavatel) {
        this.dodavatel = dodavatel;
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
        if (!(object instanceof Kategoria)) {
            return false;
        }
        Kategoria other = (Kategoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Kategoria[id=" + id + "]";
    }

}
