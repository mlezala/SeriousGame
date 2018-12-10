
package seriousgame;
import java.awt.Toolkit;

public class SeriousGame {

    public static void main(String[] args) {
        int gameWidth=1024;
        int gameHeight=768;
        
        
        //pobierz rozmiar ekranu
        int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        
        //oblicz współrzędne narożnika tak, aby pole gry było wyśrodkowane
        int xCenter=(screenWidth-gameWidth)/2;
        int yCenter=(screenHeight-gameHeight)/2;       
                
        //utwórz obiekt klasy GameWindow - konstruktor wywołuje dalszą akcję
        Window gw=new Window(gameWidth,gameHeight,xCenter,yCenter);
    }
    
}
