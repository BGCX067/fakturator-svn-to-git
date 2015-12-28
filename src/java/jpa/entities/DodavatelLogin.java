/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Frapko
 */
@Entity
@Table(name = "dodavatel_login")
@NamedQueries({
    @NamedQuery(name = "DodavatelLogin.findAll", query = "SELECT d FROM DodavatelLogin d"),
    @NamedQuery(name = "DodavatelLogin.findById", query = "SELECT d FROM DodavatelLogin d WHERE d.id = :id"),
    @NamedQuery(name = "DodavatelLogin.findByLogin", query = "SELECT d FROM DodavatelLogin d WHERE d.login = :login"),
    @NamedQuery(name = "DodavatelLogin.findByHeslo", query = "SELECT d FROM DodavatelLogin d WHERE d.heslo = :heslo")})
public class DodavatelLogin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "heslo")
    private String heslo;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Dodavatel dodavatel;

    public DodavatelLogin() {
    }

    public DodavatelLogin(Integer id) {
        this.id = id;
    }

    public DodavatelLogin(Integer id, String login, String heslo) {
        this.id = id;
        this.login = login;
        this.heslo = heslo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
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
        if (!(object instanceof DodavatelLogin)) {
            return false;
        }
        DodavatelLogin other = (DodavatelLogin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.DodavatelLogin[id=" + id + "]";
    }

}
