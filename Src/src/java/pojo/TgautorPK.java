/*
 * TgautorPK.java
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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class TgautorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_tg", nullable = false)
    private int idTg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codestudiante", nullable = false, length = 20)
    private String codestudiante;

    public TgautorPK() {
    }

    public TgautorPK(int idTg, String codestudiante) {
        this.idTg = idTg;
        this.codestudiante = codestudiante;
    }

    public int getIdTg() {
        return idTg;
    }

    public void setIdTg(int idTg) {
        this.idTg = idTg;
    }

    public String getCodestudiante() {
        return codestudiante;
    }

    public void setCodestudiante(String codestudiante) {
        this.codestudiante = codestudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTg;
        hash += (codestudiante != null ? codestudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TgautorPK)) {
            return false;
        }
        TgautorPK other = (TgautorPK) object;
        if (this.idTg != other.idTg) {
            return false;
        }
        if ((this.codestudiante == null && other.codestudiante != null) || (this.codestudiante != null && !this.codestudiante.equals(other.codestudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TgautorPK[ idTg=" + idTg + ", codestudiante=" + codestudiante + " ]";
    }
    
}
