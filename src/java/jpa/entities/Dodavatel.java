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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Frapko
 */
@Entity
@Table(name = "dodavatel")
@NamedQueries({
    @NamedQuery(name = "Dodavatel.findAll", query = "SELECT d FROM Dodavatel d"),
    @NamedQuery(name = "Dodavatel.findById", query = "SELECT d FROM Dodavatel d WHERE d.id = :id"),
    @NamedQuery(name = "Dodavatel.findByNazov", query = "SELECT d FROM Dodavatel d WHERE d.nazov = :nazov"),
    @NamedQuery(name = "Dodavatel.findByUlica", query = "SELECT d FROM Dodavatel d WHERE d.ulica = :ulica"),
    @NamedQuery(name = "Dodavatel.findByMesto", query = "SELECT d FROM Dodavatel d WHERE d.mesto = :mesto"),
    @NamedQuery(name = "Dodavatel.findByPsc", query = "SELECT d FROM Dodavatel d WHERE d.psc = :psc"),
    @NamedQuery(name = "Dodavatel.findByKrajina", query = "SELECT d FROM Dodavatel d WHERE d.krajina = :krajina"),
    @NamedQuery(name = "Dodavatel.findByPoznamka", query = "SELECT d FROM Dodavatel d WHERE d.poznamka = :poznamka"),
    @NamedQuery(name = "Dodavatel.findByIco", query = "SELECT d FROM Dodavatel d WHERE d.ico = :ico"),
    @NamedQuery(name = "Dodavatel.findByDic", query = "SELECT d FROM Dodavatel d WHERE d.dic = :dic"),
    @NamedQuery(name = "Dodavatel.findByIcdph", query = "SELECT d FROM Dodavatel d WHERE d.icdph = :icdph"),
    @NamedQuery(name = "Dodavatel.findByRegisterOpZr", query = "SELECT d FROM Dodavatel d WHERE d.registerOpZr = :registerOpZr"),
    @NamedQuery(name = "Dodavatel.findByTelefon", query = "SELECT d FROM Dodavatel d WHERE d.telefon = :telefon"),
    @NamedQuery(name = "Dodavatel.findByMobil", query = "SELECT d FROM Dodavatel d WHERE d.mobil = :mobil"),
    @NamedQuery(name = "Dodavatel.findByEmail", query = "SELECT d FROM Dodavatel d WHERE d.email = :email"),
    @NamedQuery(name = "Dodavatel.findByWeb", query = "SELECT d FROM Dodavatel d WHERE d.web = :web"),
    @NamedQuery(name = "Dodavatel.findByKontaktnaOsoba", query = "SELECT d FROM Dodavatel d WHERE d.kontaktnaOsoba = :kontaktnaOsoba"),
    @NamedQuery(name = "Dodavatel.findByPlatcaDph", query = "SELECT d FROM Dodavatel d WHERE d.platcaDph = :platcaDph")})
public class Dodavatel implements Serializable {
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
    @Column(name = "register_op_zr")
    private String registerOpZr;
    @Basic(optional = false)
    @Column(name = "telefon")
    private String telefon;
    @Column(name = "mobil")
    private String mobil;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "web")
    private String web;
    @Lob
    @Column(name = "logo")
    private byte[] logo;
    @Lob
    @Column(name = "peciatka")
    private byte[] peciatka;
    @Basic(optional = false)
    @Column(name = "kontaktna_osoba")
    private String kontaktnaOsoba;
    @Basic(optional = false)
    @Column(name = "platca_dph")
    private boolean platcaDph;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dodavatel")
    private Collection<Tovar> tovarCollection;
    @JoinColumn(name = "zaokruhlenie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Zaokruhlenie zaokruhlenie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dodavatel")
    private Collection<Projekt> projektCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dodavatel")
    private Collection<Faktura> fakturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dodavatel")
    private Collection<Odberatel> odberatelCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "dodavatel")
    private DodavatelLogin dodavatelLogin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dodavatel")
    private Collection<BankovyUcet> bankovyUcetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dodavatel")
    private Collection<Kategoria> kategoriaCollection;

    public Dodavatel() {
    }

    public Dodavatel(Integer id) {
        this.id = id;
    }

    public Dodavatel(Integer id, String nazov, String ulica, String mesto, String psc, String krajina, String ico, String dic, String icdph, String telefon, String email, String kontaktnaOsoba, boolean platcaDph) {
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
        this.platcaDph = platcaDph;
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

    public String getRegisterOpZr() {
        return registerOpZr;
    }

    public void setRegisterOpZr(String registerOpZr) {
        this.registerOpZr = registerOpZr;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public byte[] getPeciatka() {
        return peciatka;
    }

    public void setPeciatka(byte[] peciatka) {
        this.peciatka = peciatka;
    }

    public String getKontaktnaOsoba() {
        return kontaktnaOsoba;
    }

    public void setKontaktnaOsoba(String kontaktnaOsoba) {
        this.kontaktnaOsoba = kontaktnaOsoba;
    }

    public boolean getPlatcaDph() {
        return platcaDph;
    }

    public void setPlatcaDph(boolean platcaDph) {
        this.platcaDph = platcaDph;
    }

    public Collection<Tovar> getTovarCollection() {
        return tovarCollection;
    }

    public void setTovarCollection(Collection<Tovar> tovarCollection) {
        this.tovarCollection = tovarCollection;
    }

    public Zaokruhlenie getZaokruhlenie() {
        return zaokruhlenie;
    }

    public void setZaokruhlenie(Zaokruhlenie zaokruhlenie) {
        this.zaokruhlenie = zaokruhlenie;
    }

    public Collection<Projekt> getProjektCollection() {
        return projektCollection;
    }

    public void setProjektCollection(Collection<Projekt> projektCollection) {
        this.projektCollection = projektCollection;
    }

    public Collection<Faktura> getFakturaCollection() {
        return fakturaCollection;
    }

    public void setFakturaCollection(Collection<Faktura> fakturaCollection) {
        this.fakturaCollection = fakturaCollection;
    }

    public Collection<Odberatel> getOdberatelCollection() {
        return odberatelCollection;
    }

    public void setOdberatelCollection(Collection<Odberatel> odberatelCollection) {
        this.odberatelCollection = odberatelCollection;
    }

    public DodavatelLogin getDodavatelLogin() {
        return dodavatelLogin;
    }

    public void setDodavatelLogin(DodavatelLogin dodavatelLogin) {
        this.dodavatelLogin = dodavatelLogin;
    }

    public Collection<BankovyUcet> getBankovyUcetCollection() {
        return bankovyUcetCollection;
    }

    public void setBankovyUcetCollection(Collection<BankovyUcet> bankovyUcetCollection) {
        this.bankovyUcetCollection = bankovyUcetCollection;
    }

    public Collection<Kategoria> getKategoriaCollection() {
        return kategoriaCollection;
    }

    public void setKategoriaCollection(Collection<Kategoria> kategoriaCollection) {
        this.kategoriaCollection = kategoriaCollection;
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
        if (!(object instanceof Dodavatel)) {
            return false;
        }
        Dodavatel other = (Dodavatel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Dodavatel[id=" + id + "]";
    }

}
