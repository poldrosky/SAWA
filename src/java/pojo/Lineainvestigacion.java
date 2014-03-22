/*
 * Lineainvestigacion.java
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
 
package pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "lineainvestigacion", catalog = "sawa", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineainvestigacion.findAll", query = "SELECT l FROM Lineainvestigacion l"),
    @NamedQuery(name = "Lineainvestigacion.findByCodigoLinea", query = "SELECT l FROM Lineainvestigacion l WHERE l.codigoLinea = :codigoLinea"),
    @NamedQuery(name = "Lineainvestigacion.findByDescripcion", query = "SELECT l FROM Lineainvestigacion l WHERE l.descripcion = :descripcion"),
    @NamedQuery(name = "Lineainvestigacion.findByNombre", query = "SELECT l FROM Lineainvestigacion l WHERE l.nombre = :nombre")})
public class Lineainvestigacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigo_linea", nullable = false, length = 2)
    private String codigoLinea;
    @Size(max = 1000)
    @Column(name = "descripcion", length = 1000)
    private String descripcion;
    @Size(max = 100)
    @Column(name = "nombre", length = 100)
    private String nombre;
    @JoinColumn(name = "cod_dep", referencedColumnName = "cod_dep")
    @ManyToOne
    private Departamento codDep;
    @OneToMany(mappedBy = "codigoLinea")
    private List<Trabajosgrado> trabajosgradoList;

    public Lineainvestigacion() {
    }

    public Lineainvestigacion(String codigoLinea) {
        this.codigoLinea = codigoLinea;
    }

    public String getCodigoLinea() {
        return codigoLinea;
    }

    public void setCodigoLinea(String codigoLinea) {
        this.codigoLinea = codigoLinea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getCodDep() {
        return codDep;
    }

    public void setCodDep(Departamento codDep) {
        this.codDep = codDep;
    }

    @XmlTransient
    public List<Trabajosgrado> getTrabajosgradoList() {
        return trabajosgradoList;
    }

    public void setTrabajosgradoList(List<Trabajosgrado> trabajosgradoList) {
        this.trabajosgradoList = trabajosgradoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoLinea != null ? codigoLinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineainvestigacion)) {
            return false;
        }
        Lineainvestigacion other = (Lineainvestigacion) object;
        if ((this.codigoLinea == null && other.codigoLinea != null) || (this.codigoLinea != null && !this.codigoLinea.equals(other.codigoLinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Lineainvestigacion[ codigoLinea=" + codigoLinea + " ]";
    }
    
}
