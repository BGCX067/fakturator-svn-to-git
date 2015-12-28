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
@Table(name = "bankovy_ucet")
@NamedQueries({
    @NamedQuery(name = "BankovyUcet.findAll", query = "SELECT b FROM BankovyUcet b"),
    @NamedQuery(name = "BankovyUcet.findById", query = "SELECT b FROM BankovyUcet b WHERE b.id = :id"),
    @NamedQuery(name = "BankovyUcet.findByNazov", query = "SELECT b FROM BankovyUcet b WHERE b.nazov = :nazov"),
    @NamedQuery(name = "BankovyUcet.findByPredcislieUctu", query = "SELECT b FROM BankovyUcet b WHERE b.predcislieUctu = :predcislieUctu"),
    @NamedQuery(name = "BankovyUcet.findByCisloUctu", query = "SELECT b FROM BankovyUcet b WHERE b.cisloUctu = :cisloUctu"),
    @NamedQuery(name = "BankovyUcet.findByKodBanky", query = "SELECT b FROM BankovyUcet b WHERE b.kodBanky = :kodBanky"),
    @NamedQuery(name = "BankovyUcet.findByIbanKod", query = "SELECT b FROM BankovyUcet b WHERE b.ibanKod = :ibanKod"),
    @NamedQuery(name = "BankovyUcet.findBySwiftKod", query = "SELECT b FROM BankovyUcet b WHERE b.swiftKod = :swiftKod"),
    @NamedQuery(name = "BankovyUcet.findByNazovBanky", query = "SELECT b FROM BankovyUcet b WHERE b.nazovBanky = :nazovBanky")})
public class BankovyUcet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nazov")
    private String nazov;
    @Column(name = "predcislie_uctu")
    private String predcislieUctu;
    @Basic(optional = false)
    @Column(name = "cislo_uctu")
    private String cisloUctu;
    @Basic(optional = false)
    @Column(name = "kod_banky")
    private String kodBanky;
    @Column(name = "iban_kod")
    private String ibanKod;
    @Column(name = "swift_kod")
    private String swiftKod;
    @Column(name = "nazov_banky")
    private String nazovBanky;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankovyUcet")
    private Collection<Faktura> fakturaCollection;
    @JoinColumn(name = "odberatel_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Odberatel odberatel;
    @JoinColumn(name = "dodavatel_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dodavatel dodavatel;

    public BankovyUcet() {
    }

    public BankovyUcet(Integer id) {
        this.id = id;
    }

    public BankovyUcet(Integer id, String nazov, String cisloUctu, String kodBanky) {
        this.id = id;
        this.nazov = nazov;
        this.cisloUctu = cisloUctu;
        this.kodBanky = kodBanky;
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

    public String getPredcislieUctu() {
        return predcislieUctu;
    }

    public void setPredcislieUctu(String predcislieUctu) {
        this.predcislieUctu = predcislieUctu;
    }

    public String getCisloUctu() {
        return cisloUctu;
    }

    public void setCisloUctu(String cisloUctu) {
        this.cisloUctu = cisloUctu;
    }

    public String getKodBanky() {
        return kodBanky;
    }

    public void setKodBanky(String kodBanky) {
        this.kodBanky = kodBanky;
    }

    public String getIbanKod() {
        return ibanKod;
    }

    public void setIbanKod(String ibanKod) {
        this.ibanKod = ibanKod;
    }

    public String getSwiftKod() {
        return swiftKod;
    }

    public void setSwiftKod(String swiftKod) {
        this.swiftKod = swiftKod;
    }

    public String getNazovBanky() {
        return nazovBanky;
    }

    public void setNazovBanky(String nazovBanky) {
        this.nazovBanky = nazovBanky;
    }

    public Collection<Faktura> getFakturaCollection() {
        return fakturaCollection;
    }

    public void setFakturaCollection(Collection<Faktura> fakturaCollection) {
        this.fakturaCollection = fakturaCollection;
    }

    public Odberatel getOdberatel() {
        return odberatel;
    }

    public void setOdberatel(Odberatel odberatel) {
        this.odberatel = odberatel;
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
        if (!(object instanceof BankovyUcet)) {
            return false;
        }
        BankovyUcet other = (BankovyUcet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.BankovyUcet[id=" + id + "]";
    }

}
