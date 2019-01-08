
package seriousgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.File;
import java.text.DecimalFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import static seriousgame.FlyingElements.playSound;
/**
 * klasa zawierająca całą logikę gry
 * @author Magda
 */
public class GamePanel1 extends JPanel implements ActionListener, KeyListener{
    
    Timer t = new Timer(5, this);
    /** Wspólrzędne kolby i jej przesunięcie*/
    double x=380, y=540, velx = 0, vely =0;
    public GameStatus gStatus;
    /** Czcionki stosowane w pasku Menu*/
    public Font menuFont;
   /** Tablica pierwiastków*/ 
    private FlyingElements [] fElement;
    /** Obiekt - kolba*/ 
    private Flasks flask;
    /** Liczba pierwiastków w linii*/
    public int objectsInLine;
    /** Przesunięcie pomiędzy liniami z pierwiastkami*/
    public int shiftBL;
     /** Przycisk menu*/
    JButton menu;
    
    public GamePanel1(){
         
        gStatus=new GameStatus();
        //ustawienie początkowych parametrów gry
        gStatus.reset();        
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        GPars.loadInitialImages();
        setLayout(null);
        menuFont=new Font("Dialog",Font.BOLD,36);
        //dodaj i usraw przycisk menu
        menu = new JButton();
        menu.setIcon(GPars.menuLogo);
        menu.setBounds(870,10,132,60);
        add(menu);
        objectsInLine=1;
        shiftBL=768/(GPars.noOfObjects/3);
        fElement=new FlyingElements[GPars.noOfObjects];
        flask=new Flasks(GPars.flasks);
        
        restartGame();
    }
    /**
     * funkcja odpowiedzialna za wygląd głownego okna gry
     * @param gs 
     */
    public void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakości grafiki
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Narysuj tło
        g.drawImage(GPars.bgImage, 0, 0, null);
        //narysuj pasek
        g.setColor(new Color(48,213,200));
        g.fillRect(0, 0, 1024, 70);
        //Ustaw kolor domyślny czcionki
        g.setColor(Color.WHITE);
        //Ustaw czcionki do wypełnienia paska Menu
        g.setFont(menuFont);
        g.drawString("POZIOM:"+gStatus.level,1024-700, 768-720);
        g.drawString("ŻYCIA:"+gStatus.lifes ,1024-450, 768-720);
        //narysuj ikonę z logo
        g.drawImage(GPars.logoImage,1024-1000,768-760,null);
        
            if(gStatus.points>=2){
                if(!GPars.levelPause){
                    long stopTime = System.currentTimeMillis();
                    GPars.levelTime=(stopTime-GPars.startTime)/1000.0;
                    GPars.levelPause=true;
                }
                g.setColor(Color.GREEN);
                g.drawString("GRATULACJE!",370,250);
                DecimalFormat df = new DecimalFormat("#.##");
                g.drawString("TWÓJ CZAS WYNOSI:"+df.format(GPars.levelTime)+"s",300, 350);
                g.drawString("PREJDŹ DO KOLEJNEGO POZIOMU.",200,450);
                repaint();
                requestFocus();                                             
                
            }
            if(gStatus.lifes<=0){
                if(!GPars.levelPause){
                    long stopTime = System.currentTimeMillis();
                    GPars.levelTime=(stopTime-GPars.startTime)/1000.0;
                    GPars.levelPause=true;
                }
                g.setColor(Color.RED);
                g.drawString("PRZEGRANA!",380,250);
                g.drawString("WYGLĄDA NA TO, ŻE MUSISZ POĆWICZYĆ.",150,350);
                g.drawString("PRZEJDŹ DO MENU W CELU ZAKOŃCZENIA",150,450);
                g.drawString("LUB ROZPOCZĘCIA NOWEJ GRY.",230,550);
                repaint();
                requestFocus();                                             
            }
            
        //Narysuj kolbę
        for(int i=0;i< 6;i++){
            if(gStatus.points<2 && gStatus.lifes>0 )
            g.drawImage(flask.icon, (int)x, (int)y, null);  
        }
       
        //Narysuj pierwiastki
        for(int i=0;i<fElement.length;i++){
            if(gStatus.points<2 && gStatus.lifes>0){
            fElement[i].calculatePathPos(GPars.MoveMODE);
            if(!fElement[i].grasp)
                g.drawImage(fElement[i].icon,fElement[i].currX+50,fElement[i].currY+80,(int)(fElement[i].icon.getWidth(null)), (int)(fElement[i].icon.getHeight(null)),null);
        }}

         //dodanie obłsługi myszki
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
              //przejście do następnego poziomu
              if(me.getX()>200 && me.getX()<810 && me.getY()>310 && me.getY()<450 && gStatus.points>=2){
                 restartGame(); 
                 gStatus.level++;
              }
          }
      });
     
     //sprawdź czy złapane elementy są prawidłowe i reaguj odpowiednio
     isGoodCaught((int) x+80, 540);
    }
    
    /**
     * obluga klawiatury - strzełki PRAWO/LEWO
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e){
        repaint();
        requestFocus();
        x += velx;
        y += vely;
       
        //blokada poruszania kolbą ze względu na wielkość ekranu
        if(x<=0){
            x = 0;
        }
        
         if(x>=790){
            x = 790;
        }
    }
    
     public void left(){
        vely = 0;
        velx = -1.5;
    }
     
      public void right(){
        vely = 0;
        velx =1.5;
    }
   
    public void leftSTOP(){
        velx=0;
    }  
    
    public void rightSTOP(){
        velx=0;
    }    
      
      public void keyPressed(KeyEvent e){
          int code = e.getKeyCode();
          
          if(code == KeyEvent.VK_LEFT){
              left();
              
          }
          if(code == KeyEvent.VK_RIGHT){
              right();
          }
      }
      
      public void keyTyped(KeyEvent e){}
      public void keyReleased(KeyEvent e){
      int code = e.getKeyCode();
       if (code == KeyEvent .VK_LEFT){
          leftSTOP();
        }
       if (code == KeyEvent .VK_RIGHT){
          rightSTOP();
        }
      }

      public void isGoodCaught(int x, int y)
      {
          for(int i=0;i<fElement.length;i++){
                      //sprawdź czy pierwiastek został złpany
                      if(fElement[i].containsPoint(x,y)){                      
                          if(!fElement[i].grasp && (fElement[i].color == flask.elem1.getColor())){
                              if(flask.elem1.grasped == false){
                              flask.elem1.setGrasped();  
                              gStatus.points++;            
                              }                                              
                          }
                          if(!fElement[i].grasp && (fElement[i].color == flask.elem2.getColor())){
                              if(flask.elem2.grasped == false){
                              flask.elem2.setGrasped();                         
                              gStatus.points++;                        
                              }                             
                          }
                          if(!fElement[i].grasp){
                          //jeśli złpany pierwiastek nie jest prawidłowy odejmij życie i odtwórz dźwięk
                          if((fElement[i].color != flask.elem2.getColor())&&(fElement[i].color != flask.elem1.getColor()))
                          {
                              gStatus.lifes--; 
                              FlyingElements.playSound(new File("sounds/error.wav"));
                          }
                              //wywołaj znikanie pierwiastka po złapaniu
                              fElement[i].setGrasp();
                          }
                      }
                  }
      }
     
      public void restartGame(){
        gStatus.resetPoints();
        gStatus.resetLifes();
        GPars.startTime=System.currentTimeMillis();
        GPars.pause=false;
        int offset=768/objectsInLine; 
        int inLine=0;    
        int yLine=0;
        for(int i=0; i<GPars.noOfObjects;i++){
         
            fElement[i]=new FlyingElements((((inLine%objectsInLine)+1)*offset)-GPars.elements[(i%GPars.elements.length)].getWidth(null),0,GPars.elements);
            fElement[i].setScreenSize(1024, 768);
            flask = new Flasks (GPars.flasks);
            if(inLine>=objectsInLine){
                yLine++;
                inLine%=objectsInLine;
            }
            inLine++;
            fElement[i].setYPos(yLine*shiftBL*-1);
           
        } 
    }  
}
