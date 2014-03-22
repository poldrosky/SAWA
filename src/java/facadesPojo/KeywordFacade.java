/*
 * KeywordFacade.java
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
import pojo.Keyword;

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
              return getEntityManager().createNativeQuery("select pal ,"
                    + " jarowinkler((pal) ,'" + query + "') as aceptacion"
                    + " from (select distinct palabra as pal from keyword"
                    + " union"
                    + " select distinct meaning as pal from significado natural join sinonimo"
                    + " where id_word in(select id_word from sinonimo_keyword)"
                    + " ) as keyword where"
                    + " jarowinkler(pal,'" + query + "')>0.9 order by aceptacion desc").getResultList();
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
