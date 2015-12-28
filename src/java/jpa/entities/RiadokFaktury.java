/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Frapko
 */
@Entity
@Table(name = "riadok_faktury")
@NamedQueries({
    @NamedQuery(name = "RiadokFaktury.findAll", query = "SELECT r FROM RiadokFaktury r"),
    @NamedQuery(name = "RiadokFaktury.findById", query = "SELECT r FROM RiadokFaktury r WHERE r.id = :id"),
    @NamedQuery(name = "RiadokFaktury.findByMnozstvo", query = "SELECT r FROM RiadokFaktury r WHERE r.mnozstvo = :mnozstvo"),
    @NamedQuery(name = "RiadokFaktury.findByCenaBezDph", query = "SELECT r FROM RiadokFaktury r WHERE r.cenaBezDph = :cenaBezDph"),
    @NamedQuery(name = "RiadokFaktury.findByCenaSpolu", query = "SELECT r FROM RiadokFaktury r WHERE r.cenaSpolu = :cenaSpolu")})
public class RiadokFaktury implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "mnozstvo")
    private short mnozstvo;
    @Basic(optional = false)
    @Column(name = "cena_bez_dph")
    private BigDecimal cenaBezDph;
    @Basic(optional = false)
    @Column(name = "cena_spolu")
    private BigDecimal cenaSpolu;
    @JoinColumn(name = "tovar_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tovar tovar;
    @JoinColumn(name = "faktura_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Faktura faktura;
    @JoinColumn(name = "dph_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dph dph;

    public RiadokFaktury() {
    }

    public RiadokFaktury(Integer id) {
        this.id = id;
    }

    public RiadokFaktury(Integer id, short mnozstvo, BigDecimal cenaBezDph, BigDecimal cenaSpolu) {
        this.id = id;
        this.mnozstvo = mnozstvo;
        this.cenaBezDph = cenaBezDph;
        this.cenaSpolu = cenaSpolu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getMnozstvo() {
        return mnozstvo;
    }

    public void setMnozstvo(short mnozstvo) {
        this.mnozstvo = mnozstvo;
    }

    public BigDecimal getCenaBezDph() {
        return cenaBezDph;
    }

    public void setCenaBezDph(BigDecimal cenaBezDph) {
        this.cenaBezDph = cenaBezDph;
    }

    public BigDecimal getCenaSpolu() {
        return cenaSpolu;
    }

    public void setCenaSpolu(BigDecimal cenaSpolu) {
        this.cenaSpolu = cenaSpolu;
    }

    public Tovar getTovar() {
        return tovar;
    }

    public void setTovar(Tovar tovar) {
        this.tovar = tovar;
    }

    public Faktura getFaktura() {
        return faktura;
    }

    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }

    public Dph getDph() {
        return dph;
    }

    public void setDph(Dph dph) {
        this.dph = dph;
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
        if (!(object instanceof RiadokFaktury)) {
            return false;
        }
        RiadokFaktury other = (RiadokFaktury) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.RiadokFaktury[id=" + id + "]";
    }

}
