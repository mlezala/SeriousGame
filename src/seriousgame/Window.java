
package seriousgame;

import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Magda
 */
public class Window extends JFrame{
    
    MenuPanel menu = new MenuPanel();
    MenuPanelDuringGame menuDuringGame = new MenuPanelDuringGame();
    InstructionPanel instruction = new InstructionPanel();
    GamePanel1 newGame = new GamePanel1();
    JPanel cardPanel;
    CardLayout cl;
    
    public Window(int width, int height, int x, int y){
    super();
    setSize(width, height);
    setLocation(x,y);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false); //zablokuj możliwość zmian rozmiaru okna
    setUndecorated(false); //ukryj ramkę okna i przyciski kontrolne
    setVisible(true);
    
    panels();  
    initGUI();
    animationLoop();
}
    
    public void panels(){
    cardPanel = new JPanel(new CardLayout());
    getContentPane().add(cardPanel); 
    cardPanel.add(menu, "MENU");
    cardPanel.add(menuDuringGame, "MENUDURINGGAME");
    cardPanel.add(instruction, "INSTRUCTION");
    cardPanel.add(newGame, "NEWGAME");
   
    cl=(CardLayout) cardPanel.getLayout();
    cl.show(cardPanel, "MENU");
   
    
     menu.newGame.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            cl.show(cardPanel, "START");
            
        }
    });
       
     menu.instruction.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            cl.show(cardPanel, "INSTRUCTION");
            
        }
    });
     
     menuDuringGame.instruction.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            cl.show(cardPanel, "INSTRUCTION");          
        }
    });
      
     menu.endGame.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        System.exit(0);
            
        }
    });
     
     menuDuringGame.endGame.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        System.exit(0);            
        }
    });
        
     instruction.endGame.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        System.exit(0);
            
        }
    });
        
     instruction.menu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENU");
            
        }
    });
    
     menu.newGame.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        newGame.restartGame();
        cl.show(cardPanel, "NEWGAME");
            
        }
    });
     
     
      menuDuringGame.newGame.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
       newGame.restartGame();
        cl.show(cardPanel, "NEWGAME");            
        }
    });
       
     menuDuringGame.continueGame.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "NEWGAME");           
        }
    });
        
        
     newGame.menu.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        cl.show(cardPanel, "MENUDURINGGAME");
            
        }
    });
    }    
    
    private void initGUI(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        //ustaw kursor myszki w kształcie probowki
        Cursor tCursor = tk.createCustomCursor(GPars.cursorImage, new Point(10,10), "Cursor");
        setCursor(tCursor);
    }
    
    /**
     * Główna pętla gry - takt animacji (w procesie dalszej edukacji
     * można używać wątków czy klasy Timer)
     */
    private void animationLoop() {
        //pobierz liczbę milisekund od daty referencyjnej (w ms) 
        GPars.startTime = System.currentTimeMillis();
        long currTime = GPars.startTime;

        while (currTime - GPars.startTime < GPars.GAME_TIME) {
          long elapsedTime = System.currentTimeMillis() - currTime;
          //licz czas gry - może się przydać w ograniczeniach czasowych 
          //w tej demonstracji nie wykorzystane
          currTime += elapsedTime;         
          //odrysuj kolejny ekran gry (nowe pozycje obiektów - symulacja ruchu)
          repaint();         
          // przerwa w czasie
          try {
            Thread.sleep(80);
          } catch (InterruptedException ex) {System.out.println("Wyjątek: "+ex);      }
        }
    }
           
}

