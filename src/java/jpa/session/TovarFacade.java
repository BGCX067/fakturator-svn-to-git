/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Tovar;

/**
 *
 * @author Frapko
 */
@Stateless
public class TovarFacade extends AbstractFacade<Tovar> {
    @PersistenceContext(unitName = "FakturatorPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TovarFacade() {
        super(Tovar.class);
    }

}
