/*
 * ImageSwitchBean.java
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

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

@ManagedBean
@ApplicationScoped
public class ImageSwitchBean {  
  
    private List<String> images;  
  
    public ImageSwitchBean() {  
        images = new ArrayList<String>();  
        images.add("titulo.jpg");  
        images.add("biblioteca.jpg");   
        images.add("udenar.jpg");
        images.add("udenar1.jpg");
        images.add("udenar2.jpg"); 
    }  
  
    public List<String> getImages() {  
        return images;  
    }  
} 
