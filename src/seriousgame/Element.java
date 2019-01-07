/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriousgame;

/**
 *
 * @author Magda
 */
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