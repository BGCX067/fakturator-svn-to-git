/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Mena;

/**
 *
 * @author Frapko
 */
@Stateless
public class MenaFacade extends AbstractFacade<Mena> {
    @PersistenceContext(unitName = "FakturatorPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public MenaFacade() {
        super(Mena.class);
    }

}
