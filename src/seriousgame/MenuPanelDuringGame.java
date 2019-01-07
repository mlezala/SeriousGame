package seriousgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanelDuringGame extends JPanel{
    
    JButton continueGame;
    JButton newGame;
    JButton endGame;
    JButton instruction;
            
    public MenuPanelDuringGame(){
        GPars.loadInitialImages();
        setLayout(null);
        
        continueGame = new JButton("KONTYNUUJ");
        continueGame.setBounds(300,160,420,80);
        continueGame.setFont(new Font("Comis Sans", Font.BOLD, 30));
        continueGame.setForeground(new Color(63,72, 204));
        
        newGame = new JButton("NOWA GRA");
        newGame.setBounds(300,280,420,80);
        newGame.setFont(new Font("Comis Sans", Font.BOLD, 30));
        newGame.setForeground(new Color(63,72, 204));
        
        instruction = new JButton ("INSTRUKCJA"); 
        instruction.setBounds(300,400,420,80);
        instruction.setFont(new Font("Comis Sans", Font.BOLD, 30));
        instruction.setForeground(new Color(63,72, 204));
        
        endGame = new JButton("KONIEC GRY");
        endGame.setBounds(300,520,420,80);
        endGame.setFont(new Font("Comis Sans", Font.BOLD, 30));
        endGame.setForeground(new Color(63,72, 204));
                      
        add(newGame);
        add(endGame);
        add(instruction);
        add(continueGame); 
    }
                
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakości grafiki (wygładzanie/antyaliasing)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Narysuj tło
        g.drawImage(GPars.menuBackground, 0, 0, null);
    }
}