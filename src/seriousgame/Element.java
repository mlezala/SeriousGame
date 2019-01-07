
package seriousgame;

public class Element {
    public int color;
    public boolean grasped;
   
public Element (int color) {
   this.color = color;
   grasped = false; 
}
    
 public void setGrasped() {
    grasped = true;
}   
 
public int getColor() {
    return color; 
}
   
}