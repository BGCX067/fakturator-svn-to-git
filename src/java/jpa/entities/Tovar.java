/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tovar")
@NamedQueries({
    @NamedQuery(name = "Tovar.findAll", query = "SELECT t FROM Tovar t"),
    @NamedQuery(name = "Tovar.findById", query = "SELECT t FROM Tovar t WHERE t.id = :id"),
    @NamedQuery(name = "Tovar.findByNazov", query = "SELECT t FROM Tovar t WHERE t.nazov = :nazov"),
    @NamedQuery(name = "Tovar.findByMnozstvoNaSklade", query = "SELECT t FROM Tovar t WHERE t.mnozstvoNaSklade = :mnozstvoNaSklade"),
    @NamedQuery(name = "Tovar.findByMernaJednotka", query = "SELECT t FROM Tovar t WHERE t.mernaJednotka = :mernaJednotka"),
    @NamedQuery(name = "Tovar.findByCenaBezDph", query = "SELECT t FROM Tovar t WHERE t.cenaBezDph = :cenaBezDph"),
    @NamedQuery(name = "Tovar.findByPoznamka", query = "SELECT t FROM Tovar t WHERE t.poznamka = :poznamka"),
    @NamedQuery(name = "Tovar.findByZmazany", query = "SELECT t FROM Tovar t WHERE t.zmazany = :zmazany")})
public class Tovar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nazov")
    private String nazov;
    @Basic(optional = false)
    @Column(name = "mnozstvo_na_sklade")
    private int mnozstvoNaSklade;
    @Basic(optional = false)
    @Column(name = "merna_jednotka")
    private String mernaJednotka;
    @Basic(optional = false)
    @Column(name = "cena_bez_dph")
    private BigDecimal cenaBezDph;
    @Column(name = "poznamka")
    private String poznamka;
    @Basic(optional = false)
    @Column(name = "zmazany")
    private boolean zmazany;
    @JoinColumn(name = "kategoria_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Kategoria kategoria;
    @JoinColumn(name = "dph_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dph dph;
    @JoinColumn(name = "dodavatel_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dodavatel dodavatel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tovar")
    private Collection<RiadokFaktury> riadokFakturyCollection;

    public Tovar() {
    }

    public Tovar(Integer id) {
        this.id = id;
    }

    public Tovar(Integer id, String nazov, int mnozstvoNaSklade, String mernaJednotka, BigDecimal cenaBezDph, boolean zmazany) {
        this.id = id;
        this.nazov = nazov;
        this.mnozstvoNaSklade = mnozstvoNaSklade;
        this.mernaJednotka = mernaJednotka;
        this.cenaBezDph = cenaBezDph;
        this.zmazany = zmazany;
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

    public int getMnozstvoNaSklade() {
        return mnozstvoNaSklade;
    }

    public void setMnozstvoNaSklade(int mnozstvoNaSklade) {
        this.mnozstvoNaSklade = mnozstvoNaSklade;
    }

    public String getMernaJednotka() {
        return mernaJednotka;
    }

    public void setMernaJednotka(String mernaJednotka) {
        this.mernaJednotka = mernaJednotka;
    }

    public BigDecimal getCenaBezDph() {
        return cenaBezDph;
    }

    public void setCenaBezDph(BigDecimal cenaBezDph) {
        this.cenaBezDph = cenaBezDph;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    public boolean getZmazany() {
        return zmazany;
    }

    public void setZmazany(boolean zmazany) {
        this.zmazany = zmazany;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    public Dph getDph() {
        return dph;
    }

    public void setDph(Dph dph) {
        this.dph = dph;
    }

    public Dodavatel getDodavatel() {
        return dodavatel;
    }

    public void setDodavatel(Dodavatel dodavatel) {
        this.dodavatel = dodavatel;
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
        if (!(object instanceof Tovar)) {
            return false;
        }
        Tovar other = (Tovar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Tovar[id=" + id + "]";
    }

}
