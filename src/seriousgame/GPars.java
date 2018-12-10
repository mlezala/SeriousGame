/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriousgame;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * @author Magda
 */
public class GPars {
    
     /**  Dopuszczalny czas gry   */
    public static long GAME_TIME=Long.MAX_VALUE;
    /**  Liczba poziomów gry   */
    public final static long NO_LEVELS=2;
    /**  Obraz tła   */
    public static Image bgImage;
    /**  Obraz ikony Menu   */
    public static Image menuImage;
    /**  Obraz ikony Menu powrotu do gry  */
    public static Image menuGameImage;
    /**  Obraz ikony logo   */
    public static Image logoImage;
    /** Obraz ikony kursora - tarcza*/
    public static Image cursorImage;
    /**  Tablica obiektów pierwszego planu   */
    public static Image[] elements;
    /**  Zmienna stanu określającam czy jest przerwa w grze   */
    public static boolean pause=false;
    /** Zmienna stanu określająca czy wybrano menu*/
    public static boolean levelPause=false;
    /** Zmienna pomocnicza określająca początkowy czas gry */
    public static long startTime;
    /** Zmienna pomocnicza określająca czas ukończenia aktualnego poziomu */
    public static double levelTime;
    /** Zmienna pomocnicza określająca aktualny poziom gry */
    public static int MoveMODE=1;
    /** Zmienna pomocnicza określająca status ukończenia gry */
    public static boolean end=false;
    /** Zmienna pomocnicza określająca maksymalną liczę obiektów pierwszego planu */
    public static int noOfObjects=12;
    /** Szerokość pola graficznego gry */
    public static int gWidth=1024;
    /** Wysokość pola graficznego gry */
    public static int gHeight=768;
    /**Obraz ikony Koniec gry! */
    public static Image theEndImage;
    /**Obraz ikony Pomoc */
    public static Image helpImage;
     /**Obraz ikony Nowa gra */
    public static Image newGameImage;
    public static ImageIcon menuLogo; 
    public static Image menuBackground;
    public static Image instructionBackground;
     public static Image kolba;
 
    /**
     * Metoda ładowania początkowych zasobów gry
     */
    public static void loadInitialImages() {
        
        kolba = loadImage("images/kolba.png");
        instructionBackground = loadImage("images/tło.jpg");
        menuBackground = loadImage("images/background0.png");
        menuLogo = new ImageIcon ("images/MENU.png");
        bgImage = loadImage("images/tloo.png");
        menuImage=loadImage("images/MENU.png");
        menuGameImage=loadImage("images/GRA.png");
        logoImage=loadImage("images/logo.png");
        cursorImage=loadImage("images/elementy.png");
        theEndImage=loadImage("images/KONIEC.png");
        helpImage=loadImage("images/pomocMenu.png");
        newGameImage=loadImage("images/nowaGraMenu.png");



        elements= new Image[5];
        elements[0]=loadImage("images/sod.png");
        elements[1]=loadImage("images/sod.png");
        elements[2]=loadImage("images/sod.png");
        elements[3]=loadImage("images/sod.png");
        elements[4]=loadImage("images/sod.png");
    }//koniec loadInitialImages()
    
    /**
     * Metoda pobierania obiektu klasy Image na podstawie ścieżki
     * dostepu podanej jako String
     */
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }//koniec loadImage();
    
    
}
