package main.java.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Clase que perteneces a la vista del progrma ViewWordle
 * 
 * @version 1.0
 * @author Eduardo Agustin Cervantes Guerrero <23240389@leon.tecnm.mx>
 * @author Israel Dominguez Zendejas <23240380@leon.tecnm.mx>
 */
public class ViewWordle {

    private JFrame window;
    private JPanel panelMain, panelGame, panelFooter;
    private JLabel labelTry, labelFooter, labelMain, labelSkull;
    private JButton buttonSubmit;
    private JTextField[][] letters;
    private final int rows = 6;
    private final int cols = 5;

    /**
     * Constructor por omision que inicializa
     * los atributos
     */
    public ViewWordle(){
        window       = new JFrame();
        buttonSubmit = new JButton();
        panelMain    = new JPanel();
        panelGame    = new JPanel();
        panelFooter  = new JPanel();
        labelMain    = new JLabel();
        labelTry     = new JLabel();
        labelSkull   = new JLabel();
        labelFooter  = new JLabel();
        letters      = new JTextField[rows][cols];
    }

    private ImageIcon escaledImage(String path, int width, int height) {
        try {
            ImageIcon originalIcon = new ImageIcon(path);
            Image scaledImage      = originalIcon.
            getImage().
            getScaledInstance(width, height, Image.SCALE_SMOOTH);
            
            return new ImageIcon(scaledImage);
        } catch (Exception e) {
            e.printStackTrace();
            return new ImageIcon("src\\main\\resources\\IconoDefault.jpg"); 
        }
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

    private void setUpPanelMain(){
        panelMain.setBounds(0,0,1200,800);
        panelMain.setLayout(null);
    }

    private void setUpPanelFooter(){
        panelFooter.setBounds(0,665,1200,300);
        panelFooter.setBackground(Color.CYAN);
        panelFooter.setLayout(null);
    }

    /**
     * Configuramos el panel que contiene las casillas
     * en el que el jugador pondra la letra usamos un 
     * gridlayout para la distribucion de las casillas
     * de 6 x 5 y la ubicamos en centro de la ventana
     */
    private void setUpPanelWords(){
        panelGame.setBounds(100, 25, 400, 600);
        panelGame.setLayout(new GridLayout(rows,cols,0,10));
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
        
        letterCell.setHorizontalAlignment(SwingConstants.CENTER);
        letterCell.setColumns(1);
        letterCell.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        letterCell.setText("");
        letterCell.setBorder(BorderFactory.createLineBorder(
            new Color(242, 135, 115), 3
        ));

        return letterCell;
    }

    private void setButtonSubmit(){
        buttonSubmit.setBounds(525, 25, 100, 50);;
        buttonSubmit.setText("Submit");
    }

    //Esta es la configuracion de todas las etiquetas
    private void setUpLabelTry(){
        labelTry.setBounds(20, 20, 200, 55);
        labelTry.setText("Numero de intentos: ");
        labelTry.setBorder(BorderFactory.createLineBorder(Color.RED,3));
        labelTry.setForeground(Color.BLACK);
    }

    private void setUpLabelFooter(){
        labelFooter.setBounds(0, 0, 1200, 300);
        labelFooter.setIcon(escaledImage(
            "src\\main\\resources\\WooDBest.jpg", 
           1200, 
          300
        ));
    }

    private void setUpLabelMain(){
        labelMain.setBounds(0, 0, 1200, 800);
    }

    private void setUpLabelSkull(){
        labelSkull.setBounds(600, 25, 400, 400);
        labelSkull.setIcon(
            escaledImage(
                "src\\main\\resources\\Skull.jpg", 
                400, 
                400
        ));
    }

    /**
     * Configura todos los atributos de la clase
     */
    private void setUpAll(){
        setUpWindow();
        setUpPanelWords();
        setButtonSubmit();
        setUpPanelFooter();
        setUpPanelMain();
        setUpLabelTry();
        setUpLabelFooter();
        setUpLabelMain();
        setUpLabelSkull();
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
        
        panelFooter.add(labelTry);
        panelFooter.add(buttonSubmit); //Coloca el boton en el sur del panel footer
        panelFooter.add(labelFooter);
        

        panelMain.add(panelFooter);    //Coloca en el sur el panel footer
        panelMain.add(panelGame);      //El panel game se coloca en el centro
        panelMain.add(new Keyboard().getKeyboard(
            600, 
            450, 
            400, 
            200
        ));    
        panelMain.add(labelSkull);
        panelMain.add(labelMain);
        

        window.add(panelMain); 
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
