package view;

import java.awt.Color;
import java.awt.Font;

//Para crear el paquete se debe tener el mismo nombre que la carpeta donde se aloja
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import models.MultiPanelModel;

/**
 * Como va tener la ventana los componentes tendra
 * 
 * Una ventana principal
 * Un panel que contiene una imagen , texto y sonido
 * La imagen y el texto son componentes totralmente diferentes, se añaden a la ventana principal
 */

//Sera un manager de las 3 vistas en la que vamos a trabajar
public class ManageView {
    private JFrame window;
    private MultiPanelModel theModelObject;

    public void setWindow(JFrame window){this.window = window;}
    public void setModel(MultiPanelModel mpm){this.theModelObject = mpm; }
    public JFrame getWindow(){ return this.window;  }
    public MultiPanelModel getModel(){ return this.theModelObject; }

    public ManageView(){
        window             = new JFrame();
        theModelObject     = new MultiPanelModel();
    }

    public ManageView(JFrame window, MultiPanelModel mpm){
        this.window = window;
        this.theModelObject = mpm;
    }

    /**
     * Metodo que te regresa una imagen escalada
     * @param path Direccion de la imagen de tipo String
     * @param width Numero de ancho en int
     * @param height Numero de alto en int
     * @return Un objeto de tipo imageIcon
     */
    public ImageIcon escaledImage(String path, int width, int height){
        ImageIcon image = new ImageIcon(path);
        return new ImageIcon(image.getImage().getScaledInstance(width, height, 0));
    }

    /**
     * Metodo que configura los atributos necesarios para mostrar la venta principal del programa
     * Solo se configura lo basico para mostrar los componentes necesarios para el dominio de la
     * aplicacion
     * @param width Tamaño del ancho de la ventana 
     * @param height Tamaño de la altura de la ventana  
     * @param titleWindow Titulo de la ventana 
     * @return Objeto de tipo JFrame, que es la ventana que se utilizara
     */
    public void setUpWindow(int width, int height, String titleWindow){
        
        window.setSize(width, height);
        window.setTitle(titleWindow);
        window.setIconImage(new ImageIcon("RecursoLeft4Dead\\Images_use\\IconProgram.jpeg").getImage());
        window.setUndecorated(true);
        window.setBackground(new Color(0,0,0,0));
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     *  
     * Ok en esta parte se configura el panel principal donde se mostra imagenes que se requiera
     * _NOTA: EL Modelos se encargara de colocar la imagen de acuerdo a lo solicitado
     * _NOTA: Por ejemplo en setIcon lo obtendremos desde el modelo asi que cambiar esa ruta 
     * _NOTA: Usaremos el modelo adentro del contenedor
     * 
     * @param x Posicion en el eje x del Panel adentro de la ventana 
     * @param y Posicion en el eje y del Panel adentro de la ventana
     * @param width Tamaño del ancho del Panel
     * @param height Tamaño del alto del Panel
     * @return Un objeto de tipo JPanel que es el panel principal
     * 
     * @Nota Si quiere colocar al centro un componente(en caso de que no uses border layaout) 
     * Usas la siguiente formula aca perron:  
     * x = (W_Ventana - W_Panel) / 2  
     * y = (H_Ventana - H_Panel) / 2  
     */
    public JPanel setUpPanel(int x, int y, int width, int height){
        JPanel container = new JPanel();
        container.setBounds(x,y,width, height);
        container.setBackground(new Color(0, 255, 0)); //Los BackGround es una prueba de ubicacion
        container.setLayout(null);

        return container;
    }

    /**
     * Metodo que te construye una text Area con metodos comunues y nesesarios 
     * para cualquier textArea, No tiene layauot y tiene un Font por defecto
     * El asombroso Comic Sans
     * @param x posicion del componente en X
     * @param y posicion del componente en Y
     * @param width Tamaño del Ancho
     * @param height Tamaño de lo Largo
     * @return Te regresa un objeto de TextArea
     */
    public JTextArea setUpTextArea(int x, int y, int width, int height){
        JTextArea textArea = new JTextArea();

        textArea.setBounds(x,y,width,height);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setLayout(null);
        textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        textArea.setText("Default Text Es un Ester Egg");

        return textArea;
    }

    /**
       * Este metodo configura un Campo de texto para usarse en el programa 
       * Este es el atributo que tiene la vista y tiene Comic Sans 
       * predetermindado como letra
       * @param columns Numero de columnas
       * @param x Pocision en X adentro del panel
       * @param y Pocision en Y adentro del panel
       * @param width Ancho del campo de texto
       * @param height Largo del campo de texto
       * @return Un objeto de tipo JTextField
       */
    public JTextField setUpTextField(int columns, int x, int y, int width, int height){
        JTextField textField = new JTextField();

        textField.setColumns(columns);
        textField.setBounds(x, y, width, height);
        textField.setBorder(null);
        textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        return textField;

    }

    /**
     * Configuracion basica de una imagen que es una etiqueta
     * practicamente se usa para usarse en los paneles
     * ESTO SE DEBERIA LLAMAR UN SETANDGET()
     * @param x Posicion en el eje X
     * @param y Posicion en el eje Y
     * @param width Ancho de la etiqueta
     * @param height Alto de la imagen
     * @param image Imagen de la etiqueta
     * @return Un objeto de tipo imagen
     */
    public JLabel setUpLabelImage(int x, int y, int width, int height, ImageIcon image){
        JLabel labelOfImage = new JLabel();
        labelOfImage.setBounds(x, y, width, height);
        labelOfImage.setIcon(image);

        return labelOfImage;
    }

     /**
       * Metodo que configura un Boton de subir solo lo contruye y le da vista
       * Nota: Estoy usando los botones de la clase principal sabe como salga
       * Configuracion de boton
       * NOTA: Es util UN SetUPButtonSubimt para la clase principal se hizo
       * @param x Posicion del boton eje X
       * @param y Posicion del boton ejen Y
       * @param width Ancho del Boton
       * @param height Altura del Boton
       * @param text Texto que aparece en el boton
       * @return Un objeto de tipo Boton
       */
    public JButton setUpButton(int x, int y, int width, int height, String text){
        JButton button = new JButton();
        button.setBounds(x, y, width, height);
        button.setText(text);
    
        return button;
    }
}
