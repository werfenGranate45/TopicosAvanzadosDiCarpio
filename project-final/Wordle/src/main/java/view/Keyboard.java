package main.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Keyboard {
    private JPanel keyboard;
    private final String[] letters = {
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
        "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
        "U", "V", "W", "X", "Y", "Z"
    };
    private JLabel labelHold;
    private final int row = 5;
    private final int col = 5;
    
    public Keyboard(){
        keyboard = new JPanel();
        labelHold = new JLabel();
    }

    private void setUpContainKeyboard(){
        keyboard.setLayout(new GridLayout(row,col,10,0));
        //Con este metodo hacemos que el fondo sea transparente
        keyboard.setOpaque(false);
    }

    private JLabel setUpLabelKeyboard(){
        JLabel letterContainer = new JLabel();

        letterContainer.setHorizontalAlignment(SwingConstants.CENTER);
        letterContainer.setVerticalAlignment(SwingConstants.CENTER);
        letterContainer.setPreferredSize(new Dimension(80, 80));
        letterContainer.setBorder(BorderFactory.createLineBorder(
            new Color(242, 135, 115), 3
        ));
        letterContainer.setFont(new Font("Arial", Font.BOLD, 20));
        //Con este metodo se le cambia el color de la fuente
        letterContainer.setForeground(Color.PINK);

        return letterContainer;
    }

    private void setUpAll(){
        this.setUpContainKeyboard();
    }

    private void assambleKeyboard(){
        this.setUpAll();

        for(String letter: letters){
            labelHold = setUpLabelKeyboard();
            labelHold.setText(letter);
            keyboard.add(labelHold);
        }
       
    }

    public JPanel getKeyboard(int x, int y, int width, int height){
        this.assambleKeyboard();
        keyboard.setBounds(x, y, width, height);

        return keyboard;
    }

    public JPanel getKeyboard(){
        this.assambleKeyboard();
        
        return this.keyboard;
    }
}
