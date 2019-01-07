
package seriousgame;

public class GameStatus {
    /** Liczba zgromadzonych punktów na danynm poziomie*/
    public int points;
    /** Numer poziomu */
    public int level;
    /** Czas gry na danym poziomie*/   
    public double time;
    public int lifes ;
    
   //ustaw parametru początkowe
    public void reset(){
        points=0;
        level=1;
        time=0.0;
        lifes =3;
    }
    
    //zeruj liczbę punktów
    public void resetPoints(){
        points=0;
    }
    
    //zwiększ poziom
    public void nextLevel(){
        level++;
    }
    
    //resetuj liczbę żyć 
    public void resetLifes(){
        lifes=3;
    }
}
