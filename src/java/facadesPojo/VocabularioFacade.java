/*
 * VocabularioFacade.java
 * 
 * Copyright 2013 Omar Ernesto Cabrera Rosero <omarcabrera@udenar.edu.co>
 * 				  Jimmy Mateo Guerrero Restrepo <jguerrero13@udenar.edu.co>
 * 				  Mauricio Fernando Benavides Benavides <mbenavides17@udenar.edu.co>
 * 				  Silvio Ricardo Timarán Pereira <ritimar@udenar.edu.co>		 	
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */

package facadesPojo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojo.Vocabulario;

@Stateless
public class VocabularioFacade extends AbstractFacade<Vocabulario> {
    @PersistenceContext(unitName = "BuscadorJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
        public List<Object[]> findAllJaroWordsComplet(String query) {
        try {
            javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vocabulario.class));
            return getEntityManager().createNativeQuery("select distinct palabra,"
                    + " jarowinkler((palabra) ,'" + query + "') as aceptacion"
                    + " from vocabulario"
                    + " where"
                    + " jarowinkler(palabra,'" + query + "')>0.6 order by aceptacion desc").getResultList();
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
     public List<Object[]> findAllJaroWords(String query) {
        try {
            javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vocabulario.class));
            return getEntityManager().createNativeQuery("select distinct palabra,"
                    + " jarowinkler((palabra) ,'" + query + "') as aceptacion"
                    + " from vocabulario"
                    + " where"
                    + " jarowinkler(palabra,'" + query + "')>0.9 order by aceptacion desc").getResultList();
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
       public List<Object[]> findAllJaroAutor(String query) {
        try {
            javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vocabulario.class));
            return getEntityManager().createNativeQuery("select distinct palabra,"
                    + " jarowinkler((palabra) ,'" + query + "') as aceptacion"
                    + " from vocabulario"
                    + " where"
                    + " jarowinkler(palabra,'" + query + "')>0.9 order by aceptacion desc").getResultList();
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public Object findAllStopWords(String query){
        try{
             javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
             cq.select(cq.from(Vocabulario.class));
             return getEntityManager().createNativeQuery("SELECT ts_lexize('public.simple_dict',"
                     + "'"+query+"');").getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    public VocabularioFacade() {
        super(Vocabulario.class);
    }
    
}
