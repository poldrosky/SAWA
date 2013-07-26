/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.Syntax;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

/**
 *
 * @author mateo
 */
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
