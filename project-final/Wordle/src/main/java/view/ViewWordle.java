package main.java.view;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * Clase que perteneces a la vista del progrma ViewWordle
 * 
 * @version 1.0
 * @author Eduardo Agustin Cervantes Guerrero <23240389@leon.tecnm.mx>
 * @author Israel Dominguez Zendejas <2324@leon.tecnm.mx>
 */
public class ViewWordle {

    private JFrame window;
    private JPanel panelGame;
    private JTextField[][] letters;
    private final int rows = 6;
    private final int cols = 5;

    //TODO Hacer los setters y gettrs de los atributos de la clase

    /**
     * Constructor por omision que inicializa
     * los atributos
     */
    public ViewWordle(){
        window    = new JFrame();
        panelGame = new JPanel();
        letters   = new JTextField[rows][cols];
    }

    /**
     * Configuramos las ventanas con elementos necesarios
     * para el dominio de la aplicacion
     */
    private void setUpWindow(){
        window.setSize(1200, 800);
        window.setTitle("Wordle Game");
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Configuramos el panel que contiene las casillas
     * en el que el jugador pondra la letra usamos un 
     * gridlayout para la distribucion de las casillas
     * de 6 x 5 y la ubicamos en centro de la ventana
     */
    private void setUpPanel(){
        panelGame.setBounds(200, 20, 800, 600);
        panelGame.setLayout(new GridLayout(rows,cols));
    }

    /**
     * Aqui se configura el textArea en el que el 
     * usuario pondra su letra en cada uno pero
     * crea que aun falta detalles 
     * Creo que incluso es mejor un TextField para 
     * solucionarlo o delimitarlos
     * 
     * TODO Delimitar el input de una sola letra
     * 
     * @return Un objeto de tipo TextField
     */
    private JTextField setUpTextField(){
        JTextField letterCell = new JTextField();
        //Configurar para que sea un TextField
        letterCell.setColumns(1);
        letterCell.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        letterCell.setText("PT");
        letterCell.setBorder(BorderFactory.createLineBorder(
            new Color(242, 135, 115), 3
        ));

        return letterCell;
    }

    /**
     * Configura todos los atributos de la clase
     */
    private void setUpAll(){
        setUpWindow();
        setUpPanel();
    }

    /**
     * Aqui se arma todos los coponentes de las vista
     * cabe recalcar que se usara una matriz para tener
     * control de cada elemento en el que el usuario 
     * coloca su letra 
     */
    private void assamble(){
        this.setUpAll();
        
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++){
                letters[r][c] = setUpTextField();
                panelGame.add(letters[r][c]);
            }

        window.add(panelGame); 
    }

    /**
     * Metodo que ensambla y muestra la ventana
     * TODO verificar que los elementos de la matriz no sea nulo
     */
    public void display(){
        this.assamble();
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new ViewWordle().display();
    }
}
