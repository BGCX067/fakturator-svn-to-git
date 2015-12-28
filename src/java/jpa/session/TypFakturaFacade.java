/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.TypFaktura;

/**
 *
 * @author Frapko
 */
@Stateless
public class TypFakturaFacade extends AbstractFacade<TypFaktura> {
    @PersistenceContext(unitName = "FakturatorPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TypFakturaFacade() {
        super(TypFaktura.class);
    }

}
