/*
 * Palabra.java
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "palabra", catalog = "sawa", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Palabra.findAll", query = "SELECT p FROM Palabra p"),
    @NamedQuery(name = "Palabra.findByIdWord", query = "SELECT p FROM Palabra p WHERE p.idWord = :idWord"),
    @NamedQuery(name = "Palabra.findByWord", query = "SELECT p FROM Palabra p WHERE p.word = :word")})
public class Palabra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_word", nullable = false)
    private Integer idWord;
    @Size(max = 1000)
    @Column(name = "word", length = 1000)
    private String word;
    @JoinTable(name = "sinonimo", joinColumns = {
        @JoinColumn(name = "id_word", referencedColumnName = "id_word", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_meaning", referencedColumnName = "id_meaning", nullable = false)})
    @ManyToMany
    private List<Significado> significadoList;
    @ManyToMany(mappedBy = "palabraList")
    private List<Keyword> keywordList;

    public Palabra() {
    }

    public Palabra(Integer idWord) {
        this.idWord = idWord;
    }

    public Integer getIdWord() {
        return idWord;
    }

    public void setIdWord(Integer idWord) {
        this.idWord = idWord;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @XmlTransient
    public List<Significado> getSignificadoList() {
        return significadoList;
    }

    public void setSignificadoList(List<Significado> significadoList) {
        this.significadoList = significadoList;
    }

    @XmlTransient
    public List<Keyword> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(List<Keyword> keywordList) {
        this.keywordList = keywordList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWord != null ? idWord.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palabra)) {
            return false;
        }
        Palabra other = (Palabra) object;
        if ((this.idWord == null && other.idWord != null) || (this.idWord != null && !this.idWord.equals(other.idWord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Palabra[ idWord=" + idWord + " ]";
    }
    
}
