
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

public class GamePanel1 extends JPanel implements ActionListener, KeyListener{
    
    Timer t = new Timer(5, this);
    double x=380, y=510, velx = 0, vely =0;
    public GameStatus gStatus;
    /** Czcionki stosowane w pasku Menu*/
    public Font menuFont;
   /** Tablica obiektów pierwszego planu - pierwiastki*/ 
    private FlyingElements [] fElement;
    /** Obiekt pierwszego planu kolba*/ 
    private Flasks flask;
     /** Liczba obiektów w linii*/
    public int objectsInLine;
    /** Przesunięcie pomiędzy liniami z obiektami*/
    public int shiftBL;
  
    JButton menu;
    
    public GamePanel1(){
         
        gStatus=new GameStatus();
        gStatus.reset();
        
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        GPars.loadInitialImages();
        setLayout(null);
        menuFont=new Font("Dialog",Font.BOLD,36);
        
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
    
    public void paintComponent(Graphics gs){
         Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakości grafiki (wygładzanie/antyaliasing)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Narysuj tło
        g.drawImage(GPars.bgImage, 0, 0, null);
        //narysuj pasek
        g.setColor(new Color(48,213,200));
        g.fillRect(0, 0, 1024, 70);
         //Ustaw kolor domyślny
        g.setColor(Color.RED);
        //Ustaw czcionki do wypełnienia paska Menu
        g.setFont(menuFont);
        g.drawString("POZIOM:"+gStatus.level,1024-700, 768-720);
        //g.drawString(""+,1024-540, 768-720);
        g.drawString("PUNKTY:"+gStatus.points,1024-450, 768-720);
        g.drawString("ŻYCIA:"+gStatus.lifes ,1024-450, 600);
        //narysuj ikonę z logo
        g.drawImage(GPars.logoImage,1024-1000,768-760,null);
        //narysuj kolbe  
       // g.drawImage(GPars.kolba, (int)x, (int)y, null);
            if(gStatus.points>=2){
                if(!GPars.levelPause){
                    long stopTime = System.currentTimeMillis();
                    GPars.levelTime=(stopTime-GPars.startTime)/1000.0;
                    GPars.levelPause=true;
                }
                g.setColor(Color.BLUE);
                g.drawString("GRATULACJE!",370,250);
                g.drawString("PREJDŹ DO KOLEJNEGO POZIOMU.",200,350);
                repaint();
                requestFocus();                                             
                //DecimalFormat df = new DecimalFormat("#.##");
                //g.drawString("WYGRANA:"+df.format(GPars.levelTime)+"s",150, 976/2);
                //g.setColor(Color.white);
                //g.setFont(menuFont);
            }
            if(gStatus.lifes<=0){
                if(!GPars.levelPause){
                    long stopTime = System.currentTimeMillis();
                    GPars.levelTime=(stopTime-GPars.startTime)/1000.0;
                    GPars.levelPause=true;
                }
                g.setColor(Color.BLUE);
                g.drawString("STRACIŁEŚ WSZYSTKIE ŻYCIA!",370,250);
                g.drawString("MUSISZ POĆWICZYĆ",200,350);
                repaint();
                requestFocus();                                             
                //DecimalFormat df = new DecimalFormat("#.##");
                //g.drawString("WYGRANA:"+df.format(GPars.levelTime)+"s",150, 976/2);
                //g.setColor(Color.white);
                //g.setFont(menuFont);
            }
        //Na tle obiektu pierwszego planu
        for(int i=0;i< 6;i++){
            if(gStatus.points<2 && gStatus.lifes>0 )
            g.drawImage(flask.icon, (int)x, (int)y, null);
          
           
        }
        
        
         //Na tle obiektu pierwszego planu
        for(int i=0;i<fElement.length;i++){
            if(gStatus.points<2 && gStatus.lifes>0){
            fElement[i].calculatePathPos(GPars.MoveMODE);
            if(!fElement[i].grasp)
                g.drawImage(fElement[i].icon,fElement[i].currX+50,fElement[i].currY+80,(int)(fElement[i].icon.getWidth(null)), (int)(fElement[i].icon.getHeight(null)),null);
        }}
//        for(int i=0;i<fElement.length;i++){
//            if(gStatus.points<2){
//            fElement[i].calculatePathPos(GPars.MoveMODE);
//            if(!fElement[i].grasp)
//                g.drawImage(fElement[i].icon,fElement[i].currX+50,fElement[i].currY+80,(int)(fElement[i].icon.getWidth(null)), (int)(fElement[i].icon.getHeight(null)),null);
//        
     //isCaught((int) x+80, 510);
     
     addMouseListener(new MouseAdapter(){
            @Override
          public void mouseClicked(MouseEvent me){
             
              //czy wybrano rozpoczęcie nowego poziomu lub nowej gry
              if(me.getX()>200 && me.getX()<810 && me.getY()>310 && me.getY()<350 && gStatus.points>=2){
                  //Nowa gra
                  
                 restartGame(); 
                 gStatus.level++;
              }
            
   
          }//koniec mouseClicked()
      });
     czyzlapanypraowdilowy((int) x+80, 510);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        repaint();
        requestFocus();
        x += velx;
        y += vely;
       
        //blokada na wielkosc ekranu
        if(x<=0){
            x = 0;
        }
        
         if(x>=790){
            x = 790;
        }
    }
    
    /*public void up(){
        vely = -1.5;
        velx = 0;
    }*/
    
    /*public void down(){
        vely = 1.5;
        velx = 0;
    }*/

    
     public void left(){
        vely = 0;
        velx = -1.5;
    }
     
      public void right(){
        vely = 0;
        velx =1.5;
    }
      
    /*public void upSTOP(){
        vely=0;
    }*/
    
     /*public void downSTOP(){
        vely=0;
    } */       

    public void leftSTOP(){
        velx=0;
    }  
    
    public void rightSTOP(){
        velx=0;
    }    
      
      public void keyPressed(KeyEvent e){
          int code = e.getKeyCode();
         /* if(code == KeyEvent.VK_UP){
              up();
          }*/
         /* if(code == KeyEvent.VK_DOWN){
              down();
          }*/
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
      /*if (code == KeyEvent .VK_UP){
          upSTOP();
      }
       if (code == KeyEvent .VK_DOWN){
          downSTOP();
      }*/
       if (code == KeyEvent .VK_LEFT){
          leftSTOP();
      }
       if (code == KeyEvent .VK_RIGHT){
          rightSTOP();
      }
      }
      
      
      public void isCaught(int x, int y)
      {
          
                for(int i=0;i<fElement.length;i++){
                 
                      if(fElement[i].containsPoint(x,y)){
                          if(!fElement[i].grasp){
                              fElement[i].setGrasp();
                              gStatus.points++;
                          }
                      }
                  }
      }
      
      
      

    
      //flask.color== 0 - jaka kolba
      public void czyzlapanypraowdilowy(int x, int y)
      {
          for(int i=0;i<fElement.length;i++){
                      //tlenek wapnia 
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
                              fElement[i].setGrasp();
                             
                          }
                          if(!fElement[i].grasp && (fElement[i].color != flask.elem2.getColor())&&(fElement[i].color != flask.elem1.getColor()))
                          {
                              gStatus.lifes--; 
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
         
            fElement[i]=new FlyingElements((((inLine%objectsInLine)+1)*offset)-GPars.elements[(i%GPars.elements.length)].getWidth(null),0 ,GPars.elements);
            fElement[i].setScreenSize(1024, 768);
            flask = new Flasks (GPars.flasks);
            if(inLine>=objectsInLine){
                yLine++;
                inLine%=objectsInLine;
            }
            inLine++;
            fElement[i].setYPos(yLine*shiftBL*-1);
           
        }//koniec for i
        
    }//koniec restartGame()
    
}
