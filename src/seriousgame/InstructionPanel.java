/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriousgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author Magda
 */
public class InstructionPanel extends JPanel{
    JTextArea instruction; 
    JButton menu;
    JButton endGame;
     public InstructionPanel(){
        GPars.loadInitialImages();
        setLayout(null);
        
        instruction = new JTextArea("Gra ma na celu pomoc w przyswojeniu podstawowych nazw oraz składu związków chemicznych");
        instruction.setBounds(170,100,700,300);
        instruction.setFont(new Font("Comis Sans", Font.BOLD, 18));
        instruction.setForeground(new Color(63,72, 204));
        
        menu = new JButton("MENU");
        menu.setBounds(200,420,300,80);
        menu.setFont(new Font("Comis Sans", Font.BOLD, 30));
        menu.setForeground(new Color(63,72, 204));
        
        endGame = new JButton("ZAKOŃCZ GRĘ");
        endGame.setBounds(540,420,300,80);
        endGame.setFont(new Font("Comis Sans", Font.BOLD, 30));
        endGame.setForeground(new Color(63,72, 204));
        
   
        add(instruction); 
        add(menu);
        add(endGame);
      
    }
            
     
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakości grafiki (wygładzanie/antyaliasing)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Narysuj tło
        g.drawImage(GPars.instructionBackground, 0, 0, null);

 }
    
}
