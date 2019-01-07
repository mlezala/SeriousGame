
package seriousgame;
import java.awt.Image;

public class Flasks {
    /** Kolor kolby */
    public int color;    
    /** Ikona obiektu - kolby*/
    public Image icon;  
    
    //pierwiastki 
   public Element elem1;
   public Element elem2;
    
    
    
    public Flasks(Image[] images){
        color=(int)Math.round(Math.random()*(images.length-1));
        icon=images[color]; 
        
        switch(color) {
            case 0: 
                elem1 = new Element(0);
                elem2 = new Element(1);
                break;
                case 1: 
                elem1 = new Element(0);
                elem2 = new Element(1);
                break;
                case 2: 
                elem1 = new Element(0);
                elem2 = new Element(1);
                break;
                case 3: 
                elem1 = new Element(0);
                elem2 = new Element(1);
                break;
                case 4: 
                elem1 = new Element(0);
                elem2 = new Element(1);
                break;
                case 5: 
                elem1 = new Element(0);
                elem2 = new Element(1);
                break;
        }
        //System.out.println("");
        System.out.println("kolor: " + color);
        
    }
}
