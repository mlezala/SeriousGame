
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
    /** Krok przesunięcia obiektu z góry do dołu */
    public int dy;
    /** Kolor pierwisatka */
    public int color;
    /** Szerokość pola graficznego*/
    public int sWidth;
    /** Wysokość pola graficznego*/
    public int sHeight;   
    /** Czy element złapany */
    public boolean grasp; 
    /** Ikona obiektu - pierwiastka*/
    public Image icon;
    
    public FlyingElements(int x, int y, Image[] images){
        
        // losuj wspolrzedną x, w której pojawi się spadajacy pierwiastek
        Random rand = new Random();
        this.x = rand.nextInt(800);
        this.y=y;
        currX=x;
        currY=y;
        this.dy=1;
        sWidth=1024;
        sHeight=768;
        grasp=false;
             
        //losuj symbol pierwiastka
        color=(int)Math.round(Math.random()*(images.length-1));
        icon=images[color];
        
        width=icon.getWidth(null);
        height=icon.getHeight(null); 
    }
    
    /**
     *pierwiastek złapany - ustaw stan i odtwórz dźwięk
     */
    public void setGrasp(){
        if(!grasp){
            grasp=true;
            playSound(new File("sounds/plum.wav"));
        }
    }
    
    /**
     * ustaw pozycję pierwiastka
     * @param cX
     * @param cY 
     */
    public void setPosition(int cX, int cY){
        currX=cX;
        currY=cY;
    }
    
    /**
     * ustaw rozmiar pola graficznego
     * @param gWidth - szerokość 
     * @param gHeight - wysokość
     */
    public void setScreenSize(int gWidth, int gHeight){
        sWidth=gWidth;
        sHeight=gHeight;
    }
    
    /**
     * ustaw pozycję Y
     * @param cY 
     */
    public void setYPos(int cY){
        currY=cY;
    }
    
  
    /**
     * pobierz pozycję pierwiastka
     * @return - zwróć aktualną pozycję pierwiastka
     */
    public Point getPosition(){
        return new Point(currX,currY);
    }
 
    /**
     * oblicz położenie pierwiastka
     * @param mode 
     */
    public void calculatePathPos(int mode){
        int tmpX=0;
        switch(mode){
            case 1:
                   currY=currY+dy;
                   if(currY>sHeight) { 
                       currY=0;
                   }
                   tmpX=0;
                   currX=x+tmpX;
                   break;
           
            default: break;    
        }
    }

    /**
     * czy wybrane współrzedne są w obrębie obiektu
     * @param x - współrzędna x
     * @param y - współrzeędna y
     * @return 
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
     * odtwarzaj dźwięk
     * @param f 
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
    }
}
