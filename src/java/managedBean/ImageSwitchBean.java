/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author mateo
 */
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
