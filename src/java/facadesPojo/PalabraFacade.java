/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facadesPojo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojo.Palabra;

/**
 *
 * @author mateo
 */
@Stateless
public class PalabraFacade extends AbstractFacade<Palabra> {
    @PersistenceContext(unitName = "BuscadorJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PalabraFacade() {
        super(Palabra.class);
    }
    
}
