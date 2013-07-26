/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facadesPojo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojo.Trabajosgrado;

/**
 *
 * @author mateo
 */
@Stateless
public class TrabajosgradoFacade extends AbstractFacade<Trabajosgrado> {
    @PersistenceContext(unitName = "BuscadorJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrabajosgradoFacade() {
        super(Trabajosgrado.class);
    }
    
}
