/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Frapko
 */
@Entity
@Table(name = "faktura")
@NamedQueries({
    @NamedQuery(name = "Faktura.findAll", query = "SELECT f FROM Faktura f"),
    @NamedQuery(name = "Faktura.findById", query = "SELECT f FROM Faktura f WHERE f.id = :id"),
    @NamedQuery(name = "Faktura.findByCisloFaktura", query = "SELECT f FROM Faktura f WHERE f.cisloFaktura = :cisloFaktura"),
    @NamedQuery(name = "Faktura.findByVarSymb", query = "SELECT f FROM Faktura f WHERE f.varSymb = :varSymb"),
    @NamedQuery(name = "Faktura.findByKonstSymb", query = "SELECT f FROM Faktura f WHERE f.konstSymb = :konstSymb"),
    @NamedQuery(name = "Faktura.findByCelkovaSuma", query = "SELECT f FROM Faktura f WHERE f.celkovaSuma = :celkovaSuma"),
    @NamedQuery(name = "Faktura.findByDatumVystavenia", query = "SELECT f FROM Faktura f WHERE f.datumVystavenia = :datumVystavenia"),
    @NamedQuery(name = "Faktura.findByDatumSplatnosti", query = "SELECT f FROM Faktura f WHERE f.datumSplatnosti = :datumSplatnosti"),
    @NamedQuery(name = "Faktura.findByUhradena", query = "SELECT f FROM Faktura f WHERE f.uhradena = :uhradena"),
    @NamedQuery(name = "Faktura.findByPoznamka", query = "SELECT f FROM Faktura f WHERE f.poznamka = :poznamka"),
    @NamedQuery(name = "Faktura.findByZmazana", query = "SELECT f FROM Faktura f WHERE f.zmazana = :zmazana")})
public class Faktura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cislo_faktura")
    private String cisloFaktura;
    @Basic(optional = false)
    @Column(name = "var_symb")
    private String varSymb;
    @Basic(optional = false)
    @Column(name = "konst_symb")
    private String konstSymb;
    @Lob
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @Column(name = "celkova_suma")
    private BigDecimal celkovaSuma;
    @Basic(optional = false)
    @Column(name = "datum_vystavenia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumVystavenia;
    @Basic(optional = false)
    @Column(name = "datum_splatnosti")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumSplatnosti;
    @Basic(optional = false)
    @Column(name = "uhradena")
    private boolean uhradena;
    @Column(name = "poznamka")
    private String poznamka;
    @Basic(optional = false)
    @Column(name = "zmazana")
    private boolean zmazana;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faktura")
    private Collection<RiadokFaktury> riadokFakturyCollection;
    @JoinColumn(name = "zaokruhlenie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Zaokruhlenie zaokruhlenie;
    @JoinColumn(name = "forma_uhrady_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FormaUhrady formaUhrady;
    @JoinColumn(name = "typ_faktura_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypFaktura typFaktura;
    @JoinColumn(name = "projekt_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Projekt projekt;
    @JoinColumn(name = "odberatel_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Odberatel odberatel;
    @JoinColumn(name = "mena_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mena mena;
    @JoinColumn(name = "jazyk_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Jazyk jazyk;
    @JoinColumn(name = "dodavatel_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dodavatel dodavatel;
    @JoinColumn(name = "bankovy_ucet_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BankovyUcet bankovyUcet;

    public Faktura() {
    }

    public Faktura(Integer id) {
        this.id = id;
    }

    public Faktura(Integer id, String cisloFaktura, String varSymb, String konstSymb, BigDecimal celkovaSuma, Date datumVystavenia, Date datumSplatnosti, boolean uhradena, boolean zmazana) {
        this.id = id;
        this.cisloFaktura = cisloFaktura;
        this.varSymb = varSymb;
        this.konstSymb = konstSymb;
        this.celkovaSuma = celkovaSuma;
        this.datumVystavenia = datumVystavenia;
        this.datumSplatnosti = datumSplatnosti;
        this.uhradena = uhradena;
        this.zmazana = zmazana;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCisloFaktura() {
        return cisloFaktura;
    }

    public void setCisloFaktura(String cisloFaktura) {
        this.cisloFaktura = cisloFaktura;
    }

    public String getVarSymb() {
        return varSymb;
    }

    public void setVarSymb(String varSymb) {
        this.varSymb = varSymb;
    }

    public String getKonstSymb() {
        return konstSymb;
    }

    public void setKonstSymb(String konstSymb) {
        this.konstSymb = konstSymb;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BigDecimal getCelkovaSuma() {
        return celkovaSuma;
    }

    public void setCelkovaSuma(BigDecimal celkovaSuma) {
        this.celkovaSuma = celkovaSuma;
    }

    public Date getDatumVystavenia() {
        return datumVystavenia;
    }

    public void setDatumVystavenia(Date datumVystavenia) {
        this.datumVystavenia = datumVystavenia;
    }

    public Date getDatumSplatnosti() {
        return datumSplatnosti;
    }

    public void setDatumSplatnosti(Date datumSplatnosti) {
        this.datumSplatnosti = datumSplatnosti;
    }

    public boolean getUhradena() {
        return uhradena;
    }

    public void setUhradena(boolean uhradena) {
        this.uhradena = uhradena;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    public boolean getZmazana() {
        return zmazana;
    }

    public void setZmazana(boolean zmazana) {
        this.zmazana = zmazana;
    }

    public Collection<RiadokFaktury> getRiadokFakturyCollection() {
        return riadokFakturyCollection;
    }

    public void setRiadokFakturyCollection(Collection<RiadokFaktury> riadokFakturyCollection) {
        this.riadokFakturyCollection = riadokFakturyCollection;
    }

    public Zaokruhlenie getZaokruhlenie() {
        return zaokruhlenie;
    }

    public void setZaokruhlenie(Zaokruhlenie zaokruhlenie) {
        this.zaokruhlenie = zaokruhlenie;
    }

    public FormaUhrady getFormaUhrady() {
        return formaUhrady;
    }

    public void setFormaUhrady(FormaUhrady formaUhrady) {
        this.formaUhrady = formaUhrady;
    }

    public TypFaktura getTypFaktura() {
        return typFaktura;
    }

    public void setTypFaktura(TypFaktura typFaktura) {
        this.typFaktura = typFaktura;
    }

    public Projekt getProjekt() {
        return projekt;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }

    public Odberatel getOdberatel() {
        return odberatel;
    }

    public void setOdberatel(Odberatel odberatel) {
        this.odberatel = odberatel;
    }

    public Mena getMena() {
        return mena;
    }

    public void setMena(Mena mena) {
        this.mena = mena;
    }

    public Jazyk getJazyk() {
        return jazyk;
    }

    public void setJazyk(Jazyk jazyk) {
        this.jazyk = jazyk;
    }

    public Dodavatel getDodavatel() {
        return dodavatel;
    }

    public void setDodavatel(Dodavatel dodavatel) {
        this.dodavatel = dodavatel;
    }

    public BankovyUcet getBankovyUcet() {
        return bankovyUcet;
    }

    public void setBankovyUcet(BankovyUcet bankovyUcet) {
        this.bankovyUcet = bankovyUcet;
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
        if (!(object instanceof Faktura)) {
            return false;
        }
        Faktura other = (Faktura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Faktura[id=" + id + "]";
    }

}
