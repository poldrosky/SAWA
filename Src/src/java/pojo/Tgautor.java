/*
 * Tgautor.java
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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tgautor", catalog = "sawa", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tgautor.findAll", query = "SELECT t FROM Tgautor t"),
    @NamedQuery(name = "Tgautor.findByIdTg", query = "SELECT t FROM Tgautor t WHERE t.tgautorPK.idTg = :idTg"),
    @NamedQuery(name = "Tgautor.findByCodestudiante", query = "SELECT t FROM Tgautor t WHERE t.tgautorPK.codestudiante = :codestudiante"),
    @NamedQuery(name = "Tgautor.findByCalificacion", query = "SELECT t FROM Tgautor t WHERE t.calificacion = :calificacion")})
public class Tgautor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TgautorPK tgautorPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "calificacion", precision = 17, scale = 17)
    private Double calificacion;
    @JoinColumn(name = "id_tg", referencedColumnName = "id_tg", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Trabajosgrado trabajosgrado;
    @JoinColumn(name = "codestudiante", referencedColumnName = "codestudiante", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;

    public Tgautor() {
    }

    public Tgautor(TgautorPK tgautorPK) {
        this.tgautorPK = tgautorPK;
    }

    public Tgautor(int idTg, String codestudiante) {
        this.tgautorPK = new TgautorPK(idTg, codestudiante);
    }

    public TgautorPK getTgautorPK() {
        return tgautorPK;
    }

    public void setTgautorPK(TgautorPK tgautorPK) {
        this.tgautorPK = tgautorPK;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Trabajosgrado getTrabajosgrado() {
        return trabajosgrado;
    }

    public void setTrabajosgrado(Trabajosgrado trabajosgrado) {
        this.trabajosgrado = trabajosgrado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tgautorPK != null ? tgautorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tgautor)) {
            return false;
        }
        Tgautor other = (Tgautor) object;
        if ((this.tgautorPK == null && other.tgautorPK != null) || (this.tgautorPK != null && !this.tgautorPK.equals(other.tgautorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Tgautor[ tgautorPK=" + tgautorPK + " ]";
    }
    
}
