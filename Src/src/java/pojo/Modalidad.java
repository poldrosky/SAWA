/*
 * Modalidad.java
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
@Table(name = "modalidad", catalog = "sawa", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modalidad.findAll", query = "SELECT m FROM Modalidad m"),
    @NamedQuery(name = "Modalidad.findByModalidad", query = "SELECT m FROM Modalidad m WHERE m.modalidad = :modalidad"),
    @NamedQuery(name = "Modalidad.findByCodModalidad", query = "SELECT m FROM Modalidad m WHERE m.codModalidad = :codModalidad")})
public class Modalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "modalidad", nullable = false, length = 100)
    private String modalidad;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cod_modalidad", nullable = false, length = 2)
    private String codModalidad;
    @JoinColumn(name = "cod_dep", referencedColumnName = "cod_dep")
    @ManyToOne
    private Departamento codDep;
    @OneToMany(mappedBy = "codModalidad")
    private List<Trabajosgrado> trabajosgradoList;

    public Modalidad() {
    }

    public Modalidad(String codModalidad) {
        this.codModalidad = codModalidad;
    }

    public Modalidad(String codModalidad, String modalidad) {
        this.codModalidad = codModalidad;
        this.modalidad = modalidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getCodModalidad() {
        return codModalidad;
    }

    public void setCodModalidad(String codModalidad) {
        this.codModalidad = codModalidad;
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
        hash += (codModalidad != null ? codModalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modalidad)) {
            return false;
        }
        Modalidad other = (Modalidad) object;
        if ((this.codModalidad == null && other.codModalidad != null) || (this.codModalidad != null && !this.codModalidad.equals(other.codModalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Modalidad[ codModalidad=" + codModalidad + " ]";
    }
    
}
