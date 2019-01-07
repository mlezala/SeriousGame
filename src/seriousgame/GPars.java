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
    public final static long NO_LEVELS=6;
    /**  Obraz t³a */
    public static Image bgImage;
    /**  Obraz ikony Menu   */
    public static Image menuImage;
    /**  Obraz ikony Menu powrotu do gry  */
    public static Image menuGameImage;
    /**  Obraz ikony logo   */
    public static Image logoImage;
    /** Obraz ikony kursora - tarcza*/
    public static Image cursorImage;
    /**  Tablica obiektów pierwszego planu - pierwiastki*/
    public static Image[] elements;
    /**  Zmienna stanu okreœlaj¹cam czy jest przerwa w grze*/
    public static boolean pause=false;
    /** Zmienna stanu okreœlaj¹ca czy wybrano menu*/
    public static boolean levelPause=false;
    /** Zmienna pomocnicza okreœlaj¹ca pocz¹tkowy czas gry */
    public static long startTime;
    /** Zmienna pomocnicza okreœlaj¹ca czas ukoñczenia aktualnego poziomu */
    public static double levelTime;
    /** Zmienna pomocnicza okreœlaj¹ca aktualny poziom gry */
    public static int MoveMODE=1;
    /** Zmienna pomocnicza okreœlaj¹ca status ukoñczenia gry */
    public static boolean end=false;
    /** Zmienna pomocnicza okreœlaj¹ca maksymaln¹ liczê obiektów pierwszego planu */
    public static int noOfObjects=16;
    /** Szerokoœæ pola graficznego gry */
    public static int gWidth=1024;
    /** Wysokoœæ pola graficznego gry */
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
    /**  Tablica kolb   */
    public static Image[] flasks;
 
    /**
     * Metoda ³adowania pocz¹tkowych zasobów gry
     */
    public static void loadInitialImages() {
        
        kolba = loadImage("images/kolba.png");
        instructionBackground = loadImage("images/t³o.jpg");
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
        flasks[2]=loadImage("images/BrI.png");
        flasks[3]=loadImage("images/KCl.png");
        flasks[4]=loadImage("images/Zn0.png");
        flasks[5]=loadImage("images/LiF.png");
        flasks[5]=loadImage("images/CaS.png");
    }//koniec loadInitialImages()
    
    /**
     * Metoda pobierania obiektu klasy Image na podstawie œcie¿ki
     * dostepu podanej jako String
     */
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }//koniec loadImage();
    
    
}
