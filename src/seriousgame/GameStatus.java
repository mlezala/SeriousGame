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
public class GameStatus {
    /** Liczba zgromadzonych punktów na danynm poziomie*/
    public int points;
    /** Numer poziomu */
    public int level;
    /** Czas gry na danym poziomie*/   
    public double time;
    public int lifes ;
    
    /**
     * Zeruj parametry gry
     */
    public void reset(){
        points=0;
        level=1;
        time=0.0;
        lifes =3;
    }//reset()
    /**
     * Zeruj licznę punktów
     */
    public void resetPoints(){
        points=0;
    }//resetPoints()
    /**
     * Zwiększ wskaźnik poziomu
     */
    public void nextLevel(){
        level++;
    }//nextLevel()
    
      public void resetLifes(){
        lifes=3;
    }
}
