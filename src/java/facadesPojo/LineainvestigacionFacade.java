/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facadesPojo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojo.Lineainvestigacion;

/**
 *
 * @author mateo
 */
@Stateless
public class LineainvestigacionFacade extends AbstractFacade<Lineainvestigacion> {
    @PersistenceContext(unitName = "BuscadorJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineainvestigacionFacade() {
        super(Lineainvestigacion.class);
    }
    
}