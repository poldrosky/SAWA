/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facadesPojo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojo.Keyword;

/**
 *
 * @author mateo
 */
@Stateless
public class KeywordFacade extends AbstractFacade<Keyword> {
    @PersistenceContext(unitName = "BuscadorJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KeywordFacade() {
        super(Keyword.class);
    }
    public List<Object[]> findAllJaroWords(String query) {
        try {
            javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(Keyword.class));
            return getEntityManager().createNativeQuery("select pal ,"
                    + " jarowinkler((pal) ,'" + query + "') as aceptacion"
                    + " from (select distinct palabra as pal from keyword"
                    + " union"
                    + " select distinct meaning as pal from significado natural join sinonimo"
                    + " where id_word in(select id_word from sinonimo_keyword)"
                    + " ) as keyword where"
                    + " jarowinkler(pal,'" + query + "')>0.6 order by aceptacion desc").getResultList();
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public List<Object[]>findAllJaroGeneral(String query){
          try {
            javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(Keyword.class));
            return getEntityManager().createNativeQuery("select distinct pal ,"
                    + " jarowinkler((pal) ,'" + query + "') as aceptacion"
                    + " from "
                    + " ("
                    + " select "
                    + " nombres as pal,jarowinkler(nombres,'"+query+"') as aceptacion "
                    + " from"
                    + " estudiante"
                    + " where"
                    + " jarowinkler(nombres,'"+query+"')>0.5"
                    + " union"
                    + " select "
                    + " apellidos as pal,jarowinkler(apellidos,'"+query+"') as aceptacion "
                    + " from "
                    + " estudiante "
                    + " where "
                    + " jarowinkler(apellidos,'"+query+"')>0.5"
                    + " union"
                    + " select pal,jarowinkler((pal) ,'"+query+"') as aceptacion"
                    + "  from (select distinct palabra as pal from keyword"
                    + " union"
                    + " select distinct meaning as pal from significado natural join sinonimo"
                    + "  where id_word in(select id_word from sinonimo_keyword))as sin"
                    + " )as tabla order by aceptacion desc").getResultList();
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
