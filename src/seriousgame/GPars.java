
package seriousgame;
import java.awt.Image;
import javax.swing.ImageIcon;

public class GPars {
    
    /** Dopuszczalny czas gry */
    public static long GAME_TIME=Long.MAX_VALUE;
    /** Liczba poziomów gry   */
    public final static long NO_LEVELS=100;
    /** Obraz tla */
    public static Image bgImage;
    /** Obraz ikony Menu   */
    public static Image menuImage;
    /** Obraz ikony logo */
    public static Image logoImage;
    /** Obraz ikony kursora*/
    public static Image cursorImage;
    /** Tablica obiektów pierwszego planu - pierwiastki*/
    public static Image[] elements;
    /**  Zmienna stanu okrecam czy jest przerwa w grze*/
    public static boolean pause=false;
    /** Zmienna stanu określająca czy wybrano menu*/
    public static boolean levelPause=false;
    /** Zmienna pomocnicza okręslająca początkowy czas gry */
    public static long startTime;
    /** Zmienna pomocnicza okręślająca czas ukończenia aktualnego poziomu */
    public static double levelTime;
    /** Zmienna pomocnicza określająca aktualny poziom gry */
    public static int MoveMODE=1;
    /** Zmienna pomocnicza określająca status ukończenia gry */
    public static boolean end=false;
    /** Zmienna pomocnicza określająca maksymalną liczbę obiektów pierwszego planu */
    public static int noOfObjects=18;
    /** Szerokość pola graficznego gry */
    public static int gWidth=1024;
    /** Wysokość pola graficznego gry */
    public static int gHeight=768;
     /** Obraz ikony logo */
    public static ImageIcon menuLogo; 
     /** Obraz tła menu */
    public static Image menuBackground;
     /** Obraz tła instrukcji*/
    public static Image instructionBackground;
    /**  Tablica kolb   */
    public static Image[] flasks;
 
    //dodawanie zasobów gry
    public static void loadInitialImages() {
        
        instructionBackground = loadImage("images/tlo.jpg");
        menuBackground = loadImage("images/background0.png");
        menuLogo = new ImageIcon ("images/MENU.png");
        bgImage = loadImage("images/tloo.png");
        menuImage=loadImage("images/MENU.png");
        logoImage=loadImage("images/logo.png");
        cursorImage=loadImage("images/kursor1.png");
        
      

        elements= new Image[11];
        elements[0]=loadImage("images/wapn.png");
        elements[1]=loadImage("images/tlen.png");
        elements[2]=loadImage("images/magnez.png");
        elements[3]=loadImage("images/siarka.png");
        elements[4]=loadImage("images/brom.png");
        elements[5]=loadImage("images/jod.png");
        elements[6]=loadImage("images/potas.png");
        elements[7]=loadImage("images/chlor.png");
        elements[8]=loadImage("images/cynk.png");
        elements[9]=loadImage("images/lit.png");
        elements[10]=loadImage("images/fluor.png");
        
        flasks= new Image[7];
        flasks[0]=loadImage("images/CaO.png");
        flasks[1]=loadImage("images/MgS.png");
        flasks[2]=loadImage("images/KI.png");
        flasks[3]=loadImage("images/KCl.png");
        flasks[4]=loadImage("images/Zn0.png");
        flasks[5]=loadImage("images/LiF.png");
        flasks[6]=loadImage("images/LiF.png");
    }
    
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }  
}
