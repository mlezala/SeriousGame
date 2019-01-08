
package seriousgame;
/**
 * @author Magda
 */
public class Element {
    public int color;
    public boolean grasped;

    /**
    * @param color - kolor pierwiastka 
    */
    public Element (int color) {
        this.color = color;
        grasped = false; 
    }
    
    /**
    * Pierwiastek złapany - ustaw stan 
    */   
    public void setGrasped() {
        grasped = true;
    }  
    
    /**
    * Pobierz kolor pierwiastka 
    * @return 
    */
    public int getColor() {
        return color; 
    }  
}