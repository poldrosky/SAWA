/*
 * Ontologia.java
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
package managedBean;

import clases.Autor;
import clases.OntologiaAcademica;
import clases.Tesis;
import com.hp.hpl.jena.query.QuerySolution;
import facadesPojo.EstudianteFacade;
import facadesPojo.KeywordFacade;
import facadesPojo.VocabularioFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

@ManagedBean(name = "ontologia")
@ApplicationScoped
public class Ontologia {

    String titulo;
    String tituloAutor;
    List<Tesis> lista;
    private List<Tesis> selectedTesis;
    private String palabra;
    private String autores;
    private String general;
    private String resultados;
    private String busqueda = "";
    private Tesis tesisSelecion;
    OntologiaAcademica acad;
    OntologiaAcademica acadAutor;
    @EJB
    EstudianteFacade estudianteFacade;
    @EJB
    KeywordFacade keywordFacade;
    @EJB
    VocabularioFacade vocabularioFacadel;

    public Tesis getTesisSelecion() {
        return tesisSelecion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTituloAutor() {
        return tituloAutor;
    }

    public void setTituloAutor(String tituloAutor) {
        this.tituloAutor = tituloAutor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> completeTitulo(String query) {
        query = query.replaceAll("'", "");
        List<String> resul = new ArrayList<String>();
        List<Object[]> listaWords;
        String[] listaTitulo = query.split(" ");
        String res = "";
        for (int i = 0; i < listaTitulo.length - 1; i++) {
            if (i == 0) {
                res = listaTitulo[i];
            } else {
                res = res + " " + listaTitulo[i];
            }
        }
        listaWords = keywordFacade.findAllJaroWords(listaTitulo[listaTitulo.length - 1]);
        for (int i = 0; i < 5; i++) {
            System.out.println(listaWords.get(i).toString());
            if (res.equals("")) {
                resul.add(listaWords.get(i)[0].toString());
            } else {
                resul.add(res + " " + listaWords.get(i)[0].toString());
            }

        }
        return resul;
    }

    public List<String> completeGeneral(String query) {
        query = query.replaceAll("'", "");
        List<String> resul = new ArrayList<String>();
        List<Object[]> listaWords;
        String[] listaTitulo = query.split(" ");
        String res = "";
        for (int i = 0; i < listaTitulo.length - 1; i++) {
            if (i == 0) {
                res = listaTitulo[i];
            } else {
                res = res + " " + listaTitulo[i];
            }
        }
        listaWords = this.vocabularioFacadel.findAllJaroWordsComplet(listaTitulo[listaTitulo.length - 1]);
        for (int i = 0; i < 5; i++) {
            System.out.println(listaWords.get(i).toString());
            if (res.equals("")) {
                resul.add(listaWords.get(i)[0].toString());
            } else {
                resul.add(res + " " + listaWords.get(i)[0].toString());
            }

        }
        return resul;
    }

    public List<String> complete(String query) {
        List<String> resul = new ArrayList<String>();
        List<Object[]> listaEstudiantes;
        listaEstudiantes = estudianteFacade.findAllJaro(query.replaceAll("'", ""));
        //System.out.println(listaEstudiantes.size());
        for (int i = 0; i < 5; i++) {
            System.out.println(listaEstudiantes.get(i).toString());
            resul.add(listaEstudiantes.get(i)[0].toString());

        }
        // resul.add(estudianteFacade.find("200034202").getApellidos());
        return resul;
    }

    public void setTesisSelecion(Tesis tesisSelecion) {
        this.tesisSelecion = tesisSelecion;
    }

    public List<Tesis> getSelectedTesis() {
        return selectedTesis;
    }

    public void setSelectedTesis(List<Tesis> selectedTesis) {
        this.selectedTesis = selectedTesis;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public List<Tesis> getLista() {
        return lista;
    }

    public void setLista(List<Tesis> lista) {
        this.lista = lista;
    }

    public void busquedaAutor() throws IOException {
        if (this.palabra == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("por favor Seleccione un autor para su busqueda", ""));
            return;
        }
        String filtro = "";
        List<Object[]> autores = depurarAutor();
        for (int i = 0; i < 5; i++) {
            String nombres[] = autores.get(i)[0].toString().split(" ");
            for (int j = 0; j < nombres.length; j++) {
                if (j != nombres.length - 1) {
                    filtro = filtro + "(REGEX(str(?nom)," + "\"" + nombres[j] + "\",\"i\")||"
                            + "REGEX(str(?ape)," + "\"" + nombres[j] + "\",\"i\"))&&";
                } else {
                    filtro = filtro + "(REGEX(str(?nom)," + "\"" + nombres[j] + "\",\"i\")||"
                            + "REGEX(str(?ape)," + "\"" + nombres[j] + "\",\"i\"))\n||";
                }
            }
            System.out.println("autores:" + autores.get(i)[1].toString());
            if (Double.parseDouble(autores.get(i)[1].toString()) == 1) {
                i = 6;
            }
        }
        filtro = filtro.substring(0, filtro.length() - 2);
        String consulta = "PREFIX po1:<http://www.owl-ontologies.com/TesisGrado.owl#>  "
                + "select distinct \n"
                + "?id_tg?Titulo?Signatura_Topografica?resumen?Trabajo_grado\n"
                + " where\n"
                + "{\n"
                + "?Trabajo_grado po1:Es_realizado ?autor .\n"
                + "?Trabajo_grado po1:titulo?Titulo.\n"
                + "?Trabajo_grado po1:id_trabajo?id_tg.\n"
                + "?Trabajo_grado po1:resumen?resumen.\n"
                + "?Trabajo_grado po1:signatura_topografica?Signatura_Topografica.\n"
                + "?autor po1:nombre_persona?nom.\n"
                + "?autor po1:apellido_persona?ape.\n"
                + "FILTER (\n"
                + filtro
                + ")\n"
                + "}\n"
                + "order by ?nom";
        System.out.println("consulta" + consulta);
        this.busqueda = this.palabra;
        this.lista = new ArrayList<Tesis>();
        prepararLista(consulta);
        String url = "Resultado.xhtml";
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().redirect(url);
        //System.out.println("tam:"+lista.size());
    }

    public List<Object[]> depurarAutor() {
        this.palabra = this.palabra.replaceAll("'", "");
        System.out.println("palabras:" + this.palabra);
        String[] busquedaTitulo = this.palabra.split(" ");
        String buscar = "";
        return estudianteFacade.findAllJaro(this.palabra);
    }
    public List<Object[]>depurarTitulo(){
        this.titulo = this.titulo.replaceAll("'", "");
        List<Object>titulosList=new ArrayList<Object>();
        //for(int i=0;i<)
        return null;
    }

    public String[] depurarGeneral() {
        this.tituloAutor = this.tituloAutor.replaceAll("'", "");
        String[] busquedaTitulo = this.tituloAutor.split(" ");
        String buscar = "";
        for (int i = 0; i < busquedaTitulo.length; i++) {
            if (this.vocabularioFacadel.findAllStopWords(busquedaTitulo[i]) == null) {
                List<Object[]> listaWords = this.vocabularioFacadel.findAllJaroWords(busquedaTitulo[i]);
                System.out.println("Nulos"+listaWords.toString());
                if (!listaWords.isEmpty()) {
                    buscar = buscar + " " + listaWords.get(0)[0].toString();
                }
            }
        }
        if (!buscar.equals("")) {
            return buscar.split(" ");
        } else {
            return null;
        }
    }
    public String[] depurar() {
        this.titulo = this.titulo.replaceAll("'", "");
        String[] busquedaTitulo = this.titulo.split(" ");
        String buscar = "";
        for (int i = 0; i < busquedaTitulo.length; i++) {
            if (this.vocabularioFacadel.findAllStopWords(busquedaTitulo[i]) == null) {
                List<Object[]> listaWords = this.vocabularioFacadel.findAllJaroWords(busquedaTitulo[i]);
                if (!listaWords.isEmpty()) {
                    for (int j = 0; j < listaWords.size(); j++) {
                        buscar = buscar + " " + listaWords.get(j)[0].toString();
                    }
                }
            }
        }
        if (!buscar.equals("")) {
            return buscar.split(" ");
        } else {
            return null;
        }
    }

    public void busquedaTitulo() throws IOException {
        if (this.titulo == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("No Encontraron resultados para su busqueda", ""));
            return;
        }
        String[] busqueda = depurar();
        if(busqueda==null){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("No Encontraron resultados para su busqueda", ""));
            return;
        }
        String filtro = "";
        this.palabra = "";
        for (int i = 1; i < busqueda.length; i++) {
            this.palabra = this.palabra + " " + busqueda[i];
            if (i != busqueda.length - 1) {
                filtro = filtro + "REGEX(str(?sin)," + "\"" + busqueda[i] + "\",\"i\")||";
            } else {
                filtro = filtro + "REGEX(str(?sin)," + "\"" + busqueda[i] + "\",\"i\")";
            }
        }
        this.titulo = "";
        String consulta = "PREFIX po1:<http://www.owl-ontologies.com/TesisGrado.owl#>  \n"
                + "select  \n"
                + "?id_tg?Titulo?Signatura_Topografica?resumen?Trabajo_grado (count(?id_tg)as ?c)\n"
                + " where{\n"
                + "?Trabajo_grado po1:tiene ?keyword .\n"
                + "?Trabajo_grado po1:titulo?Titulo.\n"
                + "?Trabajo_grado po1:id_trabajo?id_tg.\n"
                + "?Trabajo_grado po1:resumen?resumen.\n"
                + "?Trabajo_grado po1:signatura_topografica?Signatura_Topografica.\n"
                + "?keyword po1:sinonimo ?sin.\n"
                + "FILTER (\n"
                + filtro
                + ")\n"
                + "}\n"
                + "group by ?id_tg?Titulo?Signatura_Topografica?resumen?Trabajo_grado";
        System.out.println(consulta);
        this.busqueda = this.palabra;
        this.lista = new ArrayList<Tesis>();
        // System.out.println("tam:"+lista.size());
        prepararLista1(consulta);
        String url = "Resultado.xhtml";
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().redirect(url);
        System.out.println(consulta);
    }

    public void prepararLista(String consulta) {
        com.hp.hpl.jena.query.ResultSet results = acad.consultar(consulta);
        if (!results.hasNext()) {
            this.resultados = "No se encontraron resultados para: " + this.busqueda;
        } else {
            this.resultados = "Resultados encontrados para: " + this.busqueda;
        }
        while (results.hasNext()) {
            QuerySolution soln = results.nextSolution();
            String consultar = "PREFIX po1:<http://www.owl-ontologies.com/TesisGrado.owl#>  "
                    + "select distinct "
                    + "?nombre_persona?apellido_persona?calificacion"
                    + " where{"
                    + "<" + soln.get("Trabajo_grado").toString() + "> po1:Es_realizado?autor."
                    + "?autor po1:nombre_persona?nombre_persona."
                    + "?autor po1:apellido_persona?apellido_persona."
                    + "?autor po1:calificacion?calificacion."
                    + "}order by ?nombre_persona";
            System.out.println(consultar);

            com.hp.hpl.jena.query.ResultSet rs = acadAutor.consultar(consultar);
            List<Autor> autor = new ArrayList<Autor>();
            while (rs.hasNext()) {
                QuerySolution soln1 = rs.nextSolution();
                Autor auto = new Autor();
                auto.setNombre(soln1.get("nombre_persona").toString().replace("^^http://www.w3.org/2001/XMLSchema#string", "") + " " + soln1.get("apellido_persona").toString().replace("^^http://www.w3.org/2001/XMLSchema#string", ""));
                auto.setCalificacion(soln1.get("calificacion").toString().replace("^^http://www.w3.org/2001/XMLSchema#float", ""));
                autor.add(auto);
            }
            Tesis tesis = new Tesis();
            tesis.setIdTg(soln.get("id_tg").toString().replace("^^http://www.w3.org/2001/XMLSchema#int", ""));
            tesis.setTitulo(soln.get("Titulo").toString().replace("^^http://www.w3.org/2001/XMLSchema#string", ""));
            tesis.setSigTopografica(soln.get("Signatura_Topografica").toString().replace("^^http://www.w3.org/2001/XMLSchema#string", ""));
            tesis.setAutor(autor);
            tesis.setResumen(soln.get("resumen").toString().replace("@es", ""));
            this.lista.add(tesis);
            this.palabra = "";
        }
        if (!lista.isEmpty()) {
            acad.terminar();
            acadAutor.terminar();
        }
    }
//

    public void prepararLista1(String consulta) {
        com.hp.hpl.jena.query.ResultSet results = acad.consultarAvanzada(consulta);
        if (!results.hasNext()) {
            this.resultados = "No se encontraron resultados para: " + this.busqueda;
        } else {
            this.resultados = "Resultados encontrados para: " + this.busqueda;
        }
        while (results.hasNext()) {
            QuerySolution soln = results.nextSolution();
            String consultar = "PREFIX po1:<http://www.owl-ontologies.com/TesisGrado.owl#>  "
                    + "select distinct "
                    + "?nombre_persona?apellido_persona?calificacion"
                    + " where{"
                    + "<" + soln.get("Trabajo_grado").toString() + "> po1:Es_realizado?autor."
                    + "?autor po1:nombre_persona?nombre_persona."
                    + "?autor po1:apellido_persona?apellido_persona."
                    + "?autor po1:calificacion?calificacion."
                    + "}order by ?nombre_persona";
            System.out.println("count:" + soln.get("c"));
            com.hp.hpl.jena.query.ResultSet rs = acadAutor.consultar(consultar);
            List<Autor> autor = new ArrayList<Autor>();
            while (rs.hasNext()) {
                QuerySolution soln1 = rs.nextSolution();
                Autor auto = new Autor();
                auto.setNombre(soln1.get("nombre_persona").toString().replace("^^http://www.w3.org/2001/XMLSchema#string", "") + " " + soln1.get("apellido_persona").toString().replace("^^http://www.w3.org/2001/XMLSchema#string", ""));
                auto.setCalificacion(soln1.get("calificacion").toString().replace("^^http://www.w3.org/2001/XMLSchema#float", ""));
                autor.add(auto);
            }
            Tesis tesis = new Tesis();
            tesis.setIdTg(soln.get("id_tg").toString().replace("^^http://www.w3.org/2001/XMLSchema#int", ""));
            tesis.setTitulo(soln.get("Titulo").toString().replace("^^http://www.w3.org/2001/XMLSchema#string", ""));
            tesis.setSigTopografica(soln.get("Signatura_Topografica").toString().replace("^^http://www.w3.org/2001/XMLSchema#string", ""));
            tesis.setAutor(autor);
            tesis.setRanking(Integer.parseInt(soln.get("c").toString().replace("^^http://www.w3.org/2001/XMLSchema#integer", "")));
            tesis.setResumen(soln.get("resumen").toString().replace("@es", ""));
            this.lista.add(tesis);
            this.palabra = "";

        }
        if (!lista.isEmpty()) {
            acad.terminar();
            acadAutor.terminar();
        }
        Collections.sort(lista);
    }

    public void busquedaGeneral() throws IOException {
        if (this.tituloAutor == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("No Encontraron resultados para su busqueda", ""));
            return;
        }
        String[] words = depurarGeneral();
        if (words == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("No Encontraron resultados para su busqueda", ""));
            return;
        }
        String filtro = "";
        String filtro1 = "";
        String filtro2 = "";
        this.palabra="";
        for (int i = 1; i < words.length; i++) {
            this.palabra = this.palabra + " " + words[i];
            if (i != words.length - 1) {
                filtro = filtro + "REGEX(str(?sin)," + "\"" + words[i] + "\",\"i\")||";
            } else {
                filtro = filtro + "REGEX(str(?sin)," + "\"" + words[i] + "\",\"i\")";
            }
        }
        this.palabra = this.palabra.substring(1, this.palabra.length());
        for (int i = 1; i < words.length; i++) {
            if (i != words.length - 1) {
                filtro2 = filtro2 + "REGEX(str(?nom)," + "\"" + words[i] + "\",\"i\")||"
                        + "REGEX(str(?ape)," + "\"" + words[i] + "\",\"i\")||";
                filtro1 = filtro1 + "(REGEX(str(?nom)," + "\"" + words[i] + "\",\"i\")||"
                        + "REGEX(str(?ape)," + "\"" + words[i] + "\",\"i\"))&&";
            } else {
                filtro2 = filtro2 + "REGEX(str(?nom)," + "\"" + words[i] + "\",\"i\")||"
                        + "REGEX(str(?ape)," + "\"" + words[i] + "\",\"i\")";
                filtro1 = filtro1 + "(REGEX(str(?nom)," + "\"" + words[i] + "\",\"i\")||"
                        + "REGEX(str(?ape)," + "\"" + words[i] + "\",\"i\"))";
            }
        }
        String consulta = "PREFIX po1:<http://www.owl-ontologies.com/TesisGrado.owl#>  "
                + "select distinct "
                + "?id_tg?Titulo?Signatura_Topografica?resumen?Trabajo_grado"
                + " where{ "
                + "{"
                + "?Trabajo_grado po1:Es_realizado ?autor ."
                + "?Trabajo_grado po1:titulo?Titulo."
                + "?Trabajo_grado po1:id_trabajo?id_tg."
                + "?Trabajo_grado po1:resumen?resumen."
                + "?Trabajo_grado po1:signatura_topografica?Signatura_Topografica."
                + "?autor po1:nombre_persona?nom."
                + "?autor po1:apellido_persona?ape."
                + "FILTER ("
                + filtro1
                + ")"
                + "}"
                + "UNION"
                + "{"
                + "?Trabajo_grado po1:Es_realizado ?autor ."
                + "?Trabajo_grado po1:titulo?Titulo."
                + "?Trabajo_grado po1:id_trabajo?id_tg."
                + "?Trabajo_grado po1:resumen?resumen."
                + "?Trabajo_grado po1:signatura_topografica?Signatura_Topografica."
                + "?autor po1:nombre_persona?nom."
                + "?autor po1:apellido_persona?ape."
                + "FILTER ("
                + filtro2
                + ")"
                + "}"
                + "}";
        String consulta1 = "PREFIX po1:<http://www.owl-ontologies.com/TesisGrado.owl#>  \n"
                + "select  \n"
                + "?id_tg?Titulo?Signatura_Topografica?resumen?Trabajo_grado (count(?id_tg)as ?c)\n"
                + " where{\n"
                + "?Trabajo_grado po1:tiene ?keyword .\n"
                + "?Trabajo_grado po1:titulo?Titulo.\n"
                + "?Trabajo_grado po1:id_trabajo?id_tg.\n"
                + "?Trabajo_grado po1:resumen?resumen.\n"
                + "?Trabajo_grado po1:signatura_topografica?Signatura_Topografica.\n"
                + "?keyword po1:sinonimo ?sin.\n"
                + "FILTER (\n"
                + filtro
                + ")\n"
                + "}\n"
                + "group by ?id_tg?Titulo?Signatura_Topografica?resumen?Trabajo_grado";
        this.busqueda = this.palabra;
        this.tituloAutor ="";
        this.lista = new ArrayList<Tesis>();
        prepararLista1(consulta1);
        prepararLista(consulta);
        if (lista.isEmpty()) {
            this.resultados = "No se encontraron resultados para: " + this.busqueda;
        } else {
            this.resultados = "Resultados encontrados para: " + this.busqueda;
        }
        String url = "Resultado.xhtml";
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().redirect(url);

    }

    /**
     * Creates a new instance of Ontologia
     */
    public Ontologia() {
    }

    @PostConstruct
    public void init() {
        ServletContext servContx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String ruta = (String) servContx.getRealPath("/");
        System.out.println("esta es la ruta" + ruta);
        acad = new OntologiaAcademica();
        acadAutor = new OntologiaAcademica();
        acad.iniciar(ruta);
        acadAutor.iniciar(ruta);
    }
}
