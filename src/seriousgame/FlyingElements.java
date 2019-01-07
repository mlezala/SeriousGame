
package seriousgame;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 *
 * @author Magda
 */
public class FlyingElements {
    /** Początkowa współrzędna x obiektu */
    public int x;
    /** Początkowa współrzędna y obiektu */
    public int y;
    /** Aktualna współrzędna x obiektu */
    public int currX;
    /** Aktualna współrzędna y obiektu */
    public int currY;
    /** Szerokość ikony obiektu  */
    public int width;
    /** Wysokość ikony obiektu */
    public int height;    
    /** Krok przesunięcia obiektu z dołu do góry */
    public int dy;
    /** Kolor pierwisatka */
    public int color;
    /** Szerokość pola graficznego*/
    public int sWidth;
    /** Wysokość pola graficznego*/
    public int sHeight;   
    /** Czy element złapany */
    public boolean grasp; 
    /** Ikona obiektu - pierwiastku*/
    public Image icon;
    
    /**
     * Konstruktor - ustawienie parametrów obiektu, wylosowanie koloru balonu
     * @param x początkowa współrzędna x
     * @param y początkowa współrzędna y
     */
    public FlyingElements(int x, int y, Image[] images){
        
        // losowanie wspolrzednej x spadajacego pierwiastka
        Random rand = new Random();
        this.x = rand.nextInt(800);
        //this.x=x;
        this.y=y;
        currX=x;
        currY=y;
        this.dy=1;
        sWidth=1024;
        sHeight=768;
        grasp=false;
        
       
         //losujemy symbol pierwiastka
        color=(int)Math.round(Math.random()*(images.length-1));
        icon=images[color];
        
        width=icon.getWidth(null);
        height=icon.getHeight(null);


        
    }
    /**
     * Pierwiastek złapany - ustaw stan i odtwórz dźwięk
     */
    public void setGrasp(){
        if(!grasp){
            grasp=true;
            playSound(new File("sounds/plum4.wav"));
        }
    }
    
    /**
     * Ustaw pozycję pierwiastka
     * @param cX współrzędna x
     * @param cY współrzędna y
     */
    public void setPosition(int cX, int cY){
        currX=cX;
        currY=cY;
    }
    
    /**
     * Ustaw rozmiar pola graficznego 
     * @param gWidth szerokość
     * @param gHeight wysokość
     */
    public void setScreenSize(int gWidth, int gHeight){
        sWidth=gWidth;
        sHeight=gHeight;
    }
    
    /**
     * Ustaw pozycję y obiektu
     * @param cY 
     */
    public void setYPos(int cY){
        currY=cY;
    }//setYPos()
    
  
    /**
     * Pobierz pozycję pierwiastka
     * @return pozycja pierwiastka
     */
    public Point getPosition(){
        return new Point(currX,currY);
    }
 
    /**
     * Metoda obliczania pozycji elementu - symulacja ruchu
     */
    public void calculatePathPos(int mode){
        int tmpX=0;
        switch(mode){
            case 1: //liniowo
                   currY=currY+dy;
                   if(currY>sHeight) { 
                       currY=0;
                   }
                   tmpX=0;
                   currX=x+tmpX;
                    break;
           
            default: break;    
        }
        
    }//calculatePathPos()
    
    /**
     * Funkcja określająca czy określone współrzędne 
     * są w obrębie obiektu
     * @param x  wsp. x
     * @param y  wsp. y
     * @return true jeśli obszar elementu zawiera dany punkt
     */
    public boolean containsPoint(int x, int y){
     
        if(x>=currX+50 && x<currX+width+50 ){
            if(y>=(currY+80) && y<(80+currY+height)){           
                return true;
            }
        }
        
        return false;
    }

    
    /**
     * Funkcja odtwarzania dźwięku z pliku
     * @param f - obiekt klasy File reprezentujący ścieżkę do pliku MP3
     */
    public static synchronized void playSound(final File f) {
        new Thread(new Runnable() {
          public void run() {
            try {
              Clip clip = AudioSystem.getClip();
              AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
              clip.open(inputStream);
              clip.start(); 
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
          }
        }).start();
    }//playSound()

    
}
