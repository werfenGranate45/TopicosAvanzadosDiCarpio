package main.java.view;

import javax.swing.*;
import java.awt.*;

public class TextAreaConBorde {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("TextArea con borde");
        JTextArea areaTexto = new JTextArea("Escribe aquí...");
        
        // Borde simple (color, grosor)
        areaTexto.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        
        ventana.add(new JScrollPane(areaTexto));
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}