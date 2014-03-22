/*
 * Significado.java
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "significado", catalog = "sawa", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Significado.findAll", query = "SELECT s FROM Significado s"),
    @NamedQuery(name = "Significado.findByIdMeaning", query = "SELECT s FROM Significado s WHERE s.idMeaning = :idMeaning"),
    @NamedQuery(name = "Significado.findByMeaning", query = "SELECT s FROM Significado s WHERE s.meaning = :meaning")})
public class Significado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_meaning", nullable = false)
    private Integer idMeaning;
    @Size(max = 1000)
    @Column(name = "meaning", length = 1000)
    private String meaning;
    @ManyToMany(mappedBy = "significadoList")
    private List<Palabra> palabraList;

    public Significado() {
    }

    public Significado(Integer idMeaning) {
        this.idMeaning = idMeaning;
    }

    public Integer getIdMeaning() {
        return idMeaning;
    }

    public void setIdMeaning(Integer idMeaning) {
        this.idMeaning = idMeaning;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @XmlTransient
    public List<Palabra> getPalabraList() {
        return palabraList;
    }

    public void setPalabraList(List<Palabra> palabraList) {
        this.palabraList = palabraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMeaning != null ? idMeaning.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Significado)) {
            return false;
        }
        Significado other = (Significado) object;
        if ((this.idMeaning == null && other.idMeaning != null) || (this.idMeaning != null && !this.idMeaning.equals(other.idMeaning))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Significado[ idMeaning=" + idMeaning + " ]";
    }
    
}
