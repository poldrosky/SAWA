/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facadesPojo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojo.Estudiante;

/**
 *
 * @author mateo
 */
@Stateless
public class EstudianteFacade extends AbstractFacade<Estudiante> {
    @PersistenceContext(unitName = "BuscadorJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }
    public List<Object[]> findAllJaro(String query){
        try{
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Estudiante.class));
        return getEntityManager().createNativeQuery("select (nombres ||' '|| apellidos) as nom  ,"
                + " jarowinkler((nombres ||' '|| apellidos) ,'"+query+"') as aceptacion"
                + " from estudiante where"
                + " jarowinkler((nombres ||' '|| apellidos),'"+query+"')>0.6 order by aceptacion desc").getResultList();
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
       // return getEntityManager().createQuery(cq).getResultList();
    }
    
}
