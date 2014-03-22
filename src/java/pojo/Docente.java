/*
 * Docente.java
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "docente", catalog = "sawa", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d"),
    @NamedQuery(name = "Docente.findByCodocente", query = "SELECT d FROM Docente d WHERE d.codocente = :codocente"),
    @NamedQuery(name = "Docente.findByNombres", query = "SELECT d FROM Docente d WHERE d.nombres = :nombres"),
    @NamedQuery(name = "Docente.findByCedula", query = "SELECT d FROM Docente d WHERE d.cedula = :cedula"),
    @NamedQuery(name = "Docente.findByNombre", query = "SELECT d FROM Docente d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Docente.findByApellido", query = "SELECT d FROM Docente d WHERE d.apellido = :apellido"),
    @NamedQuery(name = "Docente.findByTipo", query = "SELECT d FROM Docente d WHERE d.tipo = :tipo")})
public class Docente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codocente", nullable = false, length = 20)
    private String codocente;
    @Size(max = 100)
    @Column(name = "nombres", length = 100)
    private String nombres;
    @Size(max = 20)
    @Column(name = "cedula", length = 20)
    private String cedula;
    @Size(max = 50)
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Size(max = 50)
    @Column(name = "apellido", length = 50)
    private String apellido;
    @Column(name = "tipo")
    private Character tipo;
    @JoinTable(name = "tgjurado", joinColumns = {
        @JoinColumn(name = "codocente", referencedColumnName = "codocente", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_tg", referencedColumnName = "id_tg", nullable = false)})
    @ManyToMany
    private List<Trabajosgrado> trabajosgradoList;
    @JoinTable(name = "tgasesor", joinColumns = {
        @JoinColumn(name = "codocente", referencedColumnName = "codocente", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_tg", referencedColumnName = "id_tg", nullable = false)})
    @ManyToMany
    private List<Trabajosgrado> trabajosgradoList1;

    public Docente() {
    }

    public Docente(String codocente) {
        this.codocente = codocente;
    }

    public String getCodocente() {
        return codocente;
    }

    public void setCodocente(String codocente) {
        this.codocente = codocente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Trabajosgrado> getTrabajosgradoList() {
        return trabajosgradoList;
    }

    public void setTrabajosgradoList(List<Trabajosgrado> trabajosgradoList) {
        this.trabajosgradoList = trabajosgradoList;
    }

    @XmlTransient
    public List<Trabajosgrado> getTrabajosgradoList1() {
        return trabajosgradoList1;
    }

    public void setTrabajosgradoList1(List<Trabajosgrado> trabajosgradoList1) {
        this.trabajosgradoList1 = trabajosgradoList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codocente != null ? codocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.codocente == null && other.codocente != null) || (this.codocente != null && !this.codocente.equals(other.codocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Docente[ codocente=" + codocente + " ]";
    }
    
}
