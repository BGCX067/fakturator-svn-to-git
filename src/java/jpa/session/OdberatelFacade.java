/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Odberatel;

/**
 *
 * @author Frapko
 */
@Stateless
public class OdberatelFacade extends AbstractFacade<Odberatel> {
    @PersistenceContext(unitName = "FakturatorPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OdberatelFacade() {
        super(Odberatel.class);
    }

}
