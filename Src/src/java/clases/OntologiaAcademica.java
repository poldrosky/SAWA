/*
 * OntologiaAcademica.java
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

package clases;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.Syntax;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

public class OntologiaAcademica {
    com.hp.hpl.jena.query.Query query;
    QueryExecution qexec;
    Model model; 
    public Model iniciar(String ruta) {
        model = null;
        model = ModelFactory.createDefaultModel();
        java.io.InputStream in = FileManager.get().open(ruta+"resources/owl/OntologiaIntancia.owl");
        if (in == null) {
            throw new IllegalArgumentException("Archivo no encontrado");
        }
        model.read(in, "");
        return model;
    }
    public com.hp.hpl.jena.query.ResultSet consultar(String consulta){
        query = QueryFactory.create(consulta);
        qexec = QueryExecutionFactory.create(query,model); 
        com.hp.hpl.jena.query.ResultSet results = qexec.execSelect();
        return results; 
    }
    public com.hp.hpl.jena.query.ResultSet consultarAvanzada(String consulta){
        query = QueryFactory.create(consulta, Syntax.syntaxARQ);
        qexec = QueryExecutionFactory.create(query,model); 
        com.hp.hpl.jena.query.ResultSet results = qexec.execSelect();
        return results; 
    }
    public void terminar(){
        qexec.close();
    }
    
    
}
