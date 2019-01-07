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
        
        instruction = new JTextArea("   Gra ALCHEMIA ma na celu pomoc w przyswojeniu podstawowych nazw oraz\n      składu związków chemicznych. Aby rozpocząć "
                + "grę wciśnij przycisk MENU,\na następnie wybierz opcję NOWA GRA. Na dole planszy zostanie wygenerowana\n        kolba miarowa z nazwą związku "
                + "chemicznego. Poruszaj kolbą za pomocą\n   strzałek PRAWO/LEWO, w celu złapania odowiednich symboli pierwiastków\n              chemicznych wchodzących "
                + "w skład podanego na kolbie związku.\n Złapanie wszystkich pierwiastków wchodzących w skład związku chemicznego\n     pozwoli Ci na przejscie "
                + "do nowego poziomu. Każdy błąd powoduje utratę\n jednogo z trzech wirtualnych żyć. Po utracie wszystkich żyć gra zakańcza się,\n   a Ty "
                + "mozesz zacząć przygodę z chemią od nowa! Gdybyś w trakcie rozgrywki\n   chciał powrócić do instrukcji lub przerwać, bądź zakończyć grę "
                + "kliknij przycik\n                          MENU i wybierz odpowiednią opcją. MIŁEJ ZABAWY!");
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
