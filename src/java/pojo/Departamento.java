/*
 * Departamento.java
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
@Table(name = "departamento", catalog = "sawa", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByCodDep", query = "SELECT d FROM Departamento d WHERE d.codDep = :codDep"),
    @NamedQuery(name = "Departamento.findByNombre", query = "SELECT d FROM Departamento d WHERE d.nombre = :nombre")})
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cod_dep", nullable = false, length = 5)
    private String codDep;
    @Size(max = 50)
    @Column(name = "nombre", length = 50)
    private String nombre;
    @OneToMany(mappedBy = "codDep")
    private List<Lineainvestigacion> lineainvestigacionList;
    @OneToMany(mappedBy = "codDep")
    private List<Modalidad> modalidadList;
    @OneToMany(mappedBy = "codDep")
    private List<Programa> programaList;
    @JoinColumn(name = "cod_fac", referencedColumnName = "cod_fac")
    @ManyToOne
    private Facultad codFac;

    public Departamento() {
    }

    public Departamento(String codDep) {
        this.codDep = codDep;
    }

    public String getCodDep() {
        return codDep;
    }

    public void setCodDep(String codDep) {
        this.codDep = codDep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Lineainvestigacion> getLineainvestigacionList() {
        return lineainvestigacionList;
    }

    public void setLineainvestigacionList(List<Lineainvestigacion> lineainvestigacionList) {
        this.lineainvestigacionList = lineainvestigacionList;
    }

    @XmlTransient
    public List<Modalidad> getModalidadList() {
        return modalidadList;
    }

    public void setModalidadList(List<Modalidad> modalidadList) {
        this.modalidadList = modalidadList;
    }

    @XmlTransient
    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    public Facultad getCodFac() {
        return codFac;
    }

    public void setCodFac(Facultad codFac) {
        this.codFac = codFac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDep != null ? codDep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.codDep == null && other.codDep != null) || (this.codDep != null && !this.codDep.equals(other.codDep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Departamento[ codDep=" + codDep + " ]";
    }
    
}
