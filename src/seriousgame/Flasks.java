
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
        //losowanie koloru kolby 
        color=(int)Math.round(Math.random()*(images.length-1));
        icon=images[color]; 
        //stwierdzenie, które pierwiastki powinny być łapane do danej kolby
        switch(color) {
                case 0: 
                elem1 = new Element(0);
                elem2 = new Element(1);
                break;
                case 1: 
                elem1 = new Element(2);
                elem2 = new Element(3);
                break;
                case 2: 
                elem1 = new Element(5);
                elem2 = new Element(6);
                break;
                case 3: 
                elem1 = new Element(6);
                elem2 = new Element(7);
                break;
                case 4: 
                elem1 = new Element(1);
                elem2 = new Element(8);
                break;
                case 5: 
                elem1 = new Element(9);
                elem2 = new Element(10);
                break;
                case 6: 
                elem1 = new Element(0);
                elem2 = new Element(3);
                break;
        }        
    }
}
