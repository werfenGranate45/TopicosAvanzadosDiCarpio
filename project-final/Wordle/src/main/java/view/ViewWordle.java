package main.java.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
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
    private JPanel southWrapper, leftWrapper, rightWrapper, centerWrapper;
    private JButton submit, poweroff;
    private JLabel labelCount;
    private JTextField[][] letters;
    //Constantes para el manejo de los componentes
    private final int rows = 6;
    private final int cols = 5;
    private final int width  = 800;
    private final int height = 600;
    
    /**
     * Constructor por omision que inicializa
     * los atributos uso un matriz de JTextField
     * para obtener todos los componentes
     * y manejarlos para el controlador
     */
    public ViewWordle(){
        window        = new JFrame();
        centerWrapper = new JPanel();
        southWrapper  = new JPanel();
        leftWrapper   = new JPanel();
        rightWrapper  = new JPanel();
        submit        = new JButton();
        poweroff      = new JButton();
        labelCount    = new JLabel();
        letters       = new JTextField[rows][cols];
    }

    /**
     * Configuramos las ventanas con elementos necesarios
     * para el dominio de la aplicacion
     */
    private void setUpWindow(){
        window.setSize(width, height);
        window.setTitle("Wordle Game");
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Este metodo configura lo necesario para el juego del panel
     * Primero creamos un panel que es el que
     * tendra toda la vista que se mostrara en la GUI
     * Primero se debe comfigurar los Maximun Size
     */
    private void setUpGame(){
        JPanel game     = new JPanel();

        this.centerWrapper.setLayout(new GridBagLayout());

        game.setLayout(new GridLayout(rows, cols,0,10));
        game.setMaximumSize(new Dimension(1000, 500));
        game.setPreferredSize(new Dimension(800, 200));
        
         for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++){
                letters[r][c] = setUpTextField();
                game.add(letters[r][c]);
            }
        
        this.centerWrapper.add(game);
    }

    /**
     * Metodo que va configurar el footer en el que este tendra un boton para hacerle 
     * Un subimit con el que podra ingresar la respuesta del jugador
     */
    private void setUpFooter(){
        JPanel footer = new JPanel();

        this.southWrapper.setLayout(new GridBagLayout());

        footer.setMaximumSize(new Dimension(width,85));
        footer.setPreferredSize(new Dimension(width, 85));
        
        this.southWrapper.add(footer);
    }

    private void setUpKeyboard(){
        JPanel keyboard = new Keyboard().getKeyboard();

        this.leftWrapper.setLayout(new GridBagLayout());

        keyboard.setMaximumSize(new Dimension(400,200));
        keyboard.setPreferredSize(new Dimension(200, 200));

        this.leftWrapper.add(keyboard);
    }
    
    /**
     * Este panel sera el encargado de mostrar diferentes 
     * Botonoes dentro de un panel, o los que se usaran para 
     * su Uso
     */
    private void setUpManageGame(){
        JPanel utils = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        this.rightWrapper.setLayout(new GridBagLayout());

        utils.add(setUpCount(), BorderLayout.CENTER);
        utils.add(setUpPoweroff(), BorderLayout.SOUTH);
        utils.setMaximumSize(new Dimension(200,200));
        utils.setPreferredSize(new Dimension(200,200));

        this.rightWrapper.add(utils);
    }

    //Configuracion de los componentes con los que interactura el usuario
    private JButton setUpSubmit(){
        submit.setText("Submit");
        submit.setOpaque(false);
        
        return submit;
    }

    private JButton setUpPoweroff(){
        poweroff.setText("Apagar");
        poweroff.setOpaque(false);

        return poweroff;
    }

    //Este metodo de setBorder crea un border pero que no se vea y separe el componente
    private JLabel setUpCount(){
        labelCount.setText("Numero de intentos: ");
        labelCount.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        labelCount.setForeground(Color.BLACK);

        return labelCount;
    }

    //Apartado de metodos auxiliares
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
        letterCell.setColumns(5);
        letterCell.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        letterCell.setText("");
        letterCell.setBorder(BorderFactory.createLineBorder(
            new Color(242, 135, 115), 3
        ));

        Dimension size = new Dimension(50, 50);
        letterCell.setPreferredSize(size);
        letterCell.setMinimumSize(size);
        letterCell.setMaximumSize(size);

        return letterCell;
    }

     /**
     * Metodo convencional para el escalado de imagenes en lo que se requiera
     * @param path direccion de la imagen en string
     * @param width Ancho de la imagen
     * @param height Altura de la imagen
     * @return Un objeto de tipo ImageIcon
     */
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
     * Configura todos los atributos de la clase
     */
    private void setUpAll(){
        setUpWindow();
        setUpGame();
        setUpFooter();
        setUpKeyboard();
        setUpManageGame();
    }

    /**
     * Aqui se arma todos los coponentes de las vista
     */
    private void assamble(){
        this.setUpAll();
        
        southWrapper.add(this.setUpSubmit());
        window.add(centerWrapper,BorderLayout.CENTER);
        window.add(southWrapper, BorderLayout.SOUTH);
        window.add(leftWrapper,  BorderLayout.WEST);
        window.add(rightWrapper, BorderLayout.EAST); 
    }

    /**
     * Metodo que ensambla y muestra la ventana
     */
    public void display(){
        this.assamble();
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new ViewWordle().display();
    }
}
