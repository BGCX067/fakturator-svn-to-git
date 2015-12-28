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
@Table(name = "odberatel")
@NamedQueries({
    @NamedQuery(name = "Odberatel.findAll", query = "SELECT o FROM Odberatel o"),
    @NamedQuery(name = "Odberatel.findById", query = "SELECT o FROM Odberatel o WHERE o.id = :id"),
    @NamedQuery(name = "Odberatel.findByNazov", query = "SELECT o FROM Odberatel o WHERE o.nazov = :nazov"),
    @NamedQuery(name = "Odberatel.findByUlica", query = "SELECT o FROM Odberatel o WHERE o.ulica = :ulica"),
    @NamedQuery(name = "Odberatel.findByMesto", query = "SELECT o FROM Odberatel o WHERE o.mesto = :mesto"),
    @NamedQuery(name = "Odberatel.findByPsc", query = "SELECT o FROM Odberatel o WHERE o.psc = :psc"),
    @NamedQuery(name = "Odberatel.findByKrajina", query = "SELECT o FROM Odberatel o WHERE o.krajina = :krajina"),
    @NamedQuery(name = "Odberatel.findByPoznamka", query = "SELECT o FROM Odberatel o WHERE o.poznamka = :poznamka"),
    @NamedQuery(name = "Odberatel.findByIco", query = "SELECT o FROM Odberatel o WHERE o.ico = :ico"),
    @NamedQuery(name = "Odberatel.findByDic", query = "SELECT o FROM Odberatel o WHERE o.dic = :dic"),
    @NamedQuery(name = "Odberatel.findByIcdph", query = "SELECT o FROM Odberatel o WHERE o.icdph = :icdph"),
    @NamedQuery(name = "Odberatel.findByTelefon", query = "SELECT o FROM Odberatel o WHERE o.telefon = :telefon"),
    @NamedQuery(name = "Odberatel.findByMobil", query = "SELECT o FROM Odberatel o WHERE o.mobil = :mobil"),
    @NamedQuery(name = "Odberatel.findByFax", query = "SELECT o FROM Odberatel o WHERE o.fax = :fax"),
    @NamedQuery(name = "Odberatel.findByEmail", query = "SELECT o FROM Odberatel o WHERE o.email = :email"),
    @NamedQuery(name = "Odberatel.findByKontaktnaOsoba", query = "SELECT o FROM Odberatel o WHERE o.kontaktnaOsoba = :kontaktnaOsoba"),
    @NamedQuery(name = "Odberatel.findByKorespUlica", query = "SELECT o FROM Odberatel o WHERE o.korespUlica = :korespUlica"),
    @NamedQuery(name = "Odberatel.findByKorespMesto", query = "SELECT o FROM Odberatel o WHERE o.korespMesto = :korespMesto"),
    @NamedQuery(name = "Odberatel.findByKorespPsc", query = "SELECT o FROM Odberatel o WHERE o.korespPsc = :korespPsc"),
    @NamedQuery(name = "Odberatel.findByKorespKrajina", query = "SELECT o FROM Odberatel o WHERE o.korespKrajina = :korespKrajina"),
    @NamedQuery(name = "Odberatel.findByPlatcaDph", query = "SELECT o FROM Odberatel o WHERE o.platcaDph = :platcaDph"),
    @NamedQuery(name = "Odberatel.findByBlokovat", query = "SELECT o FROM Odberatel o WHERE o.blokovat = :blokovat"),
    @NamedQuery(name = "Odberatel.findByZmazany", query = "SELECT o FROM Odberatel o WHERE o.zmazany = :zmazany")})
public class Odberatel implements Serializable {
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
    @Column(name = "ulica")
    private String ulica;
    @Basic(optional = false)
    @Column(name = "mesto")
    private String mesto;
    @Basic(optional = false)
    @Column(name = "psc")
    private String psc;
    @Basic(optional = false)
    @Column(name = "krajina")
    private String krajina;
    @Column(name = "poznamka")
    private String poznamka;
    @Basic(optional = false)
    @Column(name = "ico")
    private String ico;
    @Basic(optional = false)
    @Column(name = "dic")
    private String dic;
    @Basic(optional = false)
    @Column(name = "icdph")
    private String icdph;
    @Basic(optional = false)
    @Column(name = "telefon")
    private String telefon;
    @Column(name = "mobil")
    private String mobil;
    @Column(name = "fax")
    private String fax;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "kontaktna_osoba")
    private String kontaktnaOsoba;
    @Basic(optional = false)
    @Column(name = "koresp_ulica")
    private String korespUlica;
    @Basic(optional = false)
    @Column(name = "koresp_mesto")
    private String korespMesto;
    @Basic(optional = false)
    @Column(name = "koresp_psc")
    private String korespPsc;
    @Basic(optional = false)
    @Column(name = "koresp_krajina")
    private String korespKrajina;
    @Basic(optional = false)
    @Column(name = "platca_dph")
    private boolean platcaDph;
    @Basic(optional = false)
    @Column(name = "blokovat")
    private boolean blokovat;
    @Basic(optional = false)
    @Column(name = "zmazany")
    private boolean zmazany;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "odberatel")
    private Collection<Faktura> fakturaCollection;
    @JoinColumn(name = "dodavatel_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dodavatel dodavatel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "odberatel")
    private Collection<BankovyUcet> bankovyUcetCollection;

    public Odberatel() {
    }

    public Odberatel(Integer id) {
        this.id = id;
    }

    public Odberatel(Integer id, String nazov, String ulica, String mesto, String psc, String krajina, String ico, String dic, String icdph, String telefon, String email, String kontaktnaOsoba, String korespUlica, String korespMesto, String korespPsc, String korespKrajina, boolean platcaDph, boolean blokovat, boolean zmazany) {
        this.id = id;
        this.nazov = nazov;
        this.ulica = ulica;
        this.mesto = mesto;
        this.psc = psc;
        this.krajina = krajina;
        this.ico = ico;
        this.dic = dic;
        this.icdph = icdph;
        this.telefon = telefon;
        this.email = email;
        this.kontaktnaOsoba = kontaktnaOsoba;
        this.korespUlica = korespUlica;
        this.korespMesto = korespMesto;
        this.korespPsc = korespPsc;
        this.korespKrajina = korespKrajina;
        this.platcaDph = platcaDph;
        this.blokovat = blokovat;
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

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getKrajina() {
        return krajina;
    }

    public void setKrajina(String krajina) {
        this.krajina = krajina;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getDic() {
        return dic;
    }

    public void setDic(String dic) {
        this.dic = dic;
    }

    public String getIcdph() {
        return icdph;
    }

    public void setIcdph(String icdph) {
        this.icdph = icdph;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKontaktnaOsoba() {
        return kontaktnaOsoba;
    }

    public void setKontaktnaOsoba(String kontaktnaOsoba) {
        this.kontaktnaOsoba = kontaktnaOsoba;
    }

    public String getKorespUlica() {
        return korespUlica;
    }

    public void setKorespUlica(String korespUlica) {
        this.korespUlica = korespUlica;
    }

    public String getKorespMesto() {
        return korespMesto;
    }

    public void setKorespMesto(String korespMesto) {
        this.korespMesto = korespMesto;
    }

    public String getKorespPsc() {
        return korespPsc;
    }

    public void setKorespPsc(String korespPsc) {
        this.korespPsc = korespPsc;
    }

    public String getKorespKrajina() {
        return korespKrajina;
    }

    public void setKorespKrajina(String korespKrajina) {
        this.korespKrajina = korespKrajina;
    }

    public boolean getPlatcaDph() {
        return platcaDph;
    }

    public void setPlatcaDph(boolean platcaDph) {
        this.platcaDph = platcaDph;
    }

    public boolean getBlokovat() {
        return blokovat;
    }

    public void setBlokovat(boolean blokovat) {
        this.blokovat = blokovat;
    }

    public boolean getZmazany() {
        return zmazany;
    }

    public void setZmazany(boolean zmazany) {
        this.zmazany = zmazany;
    }

    public Collection<Faktura> getFakturaCollection() {
        return fakturaCollection;
    }

    public void setFakturaCollection(Collection<Faktura> fakturaCollection) {
        this.fakturaCollection = fakturaCollection;
    }

    public Dodavatel getDodavatel() {
        return dodavatel;
    }

    public void setDodavatel(Dodavatel dodavatel) {
        this.dodavatel = dodavatel;
    }

    public Collection<BankovyUcet> getBankovyUcetCollection() {
        return bankovyUcetCollection;
    }

    public void setBankovyUcetCollection(Collection<BankovyUcet> bankovyUcetCollection) {
        this.bankovyUcetCollection = bankovyUcetCollection;
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
        if (!(object instanceof Odberatel)) {
            return false;
        }
        Odberatel other = (Odberatel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Odberatel[id=" + id + "]";
    }

}
