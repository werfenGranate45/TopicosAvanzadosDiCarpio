import java.awt.Color;

//Para crear el paquete se debe tener el mismo nombre que la carpeta donde se aloja
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Como va tener la ventana los componentes tendra
 * 
 * Una ventana principal
 * Un panel que contiene una imagen , texto y sonido
 * La imagen y el texto son componentes totralmente diferentes, se añaden a la ventana principal
 */


public class MultipanelView {
    private JFrame window;
    private JPanel container, navbar;
    private JLabel imageOfContainer,imageToButtonRight, imageToButtonLeft, imageToButtonShut;
    private JButton buttonToRight, buttonToLeft, buttonShutdown;
    private MultiPanelModel theModelObject;

    public void setWindow(JFrame window){this.window = window;}
    public void setContainer(JPanel pContainer){this.container = pContainer;}
    public void setNavbar(JPanel navBar){this.navbar = navBar; }
    public void setLabelContainer(JLabel labContainer){this.imageOfContainer = labContainer;}
    public void setLabelButtonRight(JLabel imageButtonRight){this.imageToButtonRight = imageButtonRight; }
    public void setLabelButtonLeft(JLabel imageButtonLeft){this.imageToButtonLeft = imageButtonLeft;}
    public void setButtonRight(JButton buttonRight){ this.buttonToRight = buttonRight; }
    public void setButtonLeft(JButton buttonLeft){ this.buttonToLeft = buttonLeft; }
    public void setButtonShutdown(JButton buttonOff){ this.buttonShutdown = buttonOff; }
    public void setMultiPanelModel(MultiPanelModel mpm){this.theModelObject = mpm;}

    public JFrame get(){ return this.window;  }
    public JPanel getContainer(){ return this.container; }
    public JPanel getNavBar(){ return this.navbar; }
    public JLabel getContainerLabel() { return this.imageOfContainer; }
    public JLabel getLabelbuttonRight() {return this.imageToButtonRight; }
    public JLabel getLabelbuttonLeft() { return this.imageToButtonLeft; }
    public JButton getButtonRight() { return this.buttonToRight; }
    public JButton getButtonLeft() { return this.buttonToLeft; }
    public JButton getButtonOff() { return this.buttonShutdown; }
    public MultiPanelModel getModel(){ return this.theModelObject; }

    public MultipanelView(){
        window             = new JFrame();
        container          = new JPanel();
        navbar             = new JPanel();
        imageOfContainer   = new JLabel();
        imageToButtonLeft  = new JLabel();
        imageToButtonRight = new JLabel();
        imageToButtonShut  = new JLabel();
        buttonToRight      = new JButton();
        buttonToLeft       = new JButton();
        buttonShutdown     = new JButton();
        theModelObject     = new MultiPanelModel();
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
     * @param width Tamaño del ancho de la ventana [Int]
     * @param height Tamaño de la altura de la ventana  [Int]
     * @param titleWindow Titulo de la ventana [String]
     * @return Objeto de tipo JFrame, que es la ventana que se utilizara
     */
    public JFrame setUpWindow(int width, int height, String titleWindow){

        window.setSize(width, height);
        window.setTitle(titleWindow);
        window.setIconImage(new ImageIcon("RecursoLeft4Dead\\Images_use\\IconProgram.jpeg").getImage());
        //window.setUndecorated(true);
        //window.setBackground(new Color(0,0,0,0));
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return this.window;
    }

    public void showWindow(boolean signal){
        window.setVisible(signal);
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
    public JPanel setUpCotainer(int x, int y, int width, int height){
        imageOfContainer.setBounds(0, 0, width, height);
        container.setBounds(x,y,width, height);
        container.setBackground(new Color(0, 255, 0)); //Los BackGround es una prueba de ubicacion
        container.setLayout(null);

        return this.container;
    }

    public void showContainer(boolean signal){
        container.setVisible(signal);
    }

    /**
     * Ok el NavBar es el componente que nos permitira navegar por las imagenes de las interfaces
     * NOTA: No se si va tener una imagen fija o un color falta considerarlo Por ahora es Rojo
     * _NOTA: A considerar los componentes los estoy configurando dentro del mismo metodo
     * _NOTA: para hacerlo mas modular deberia configurarse por apartado cada componente y asi
     * _NOTA: TENER UNA MEJOR PERSONALIZACION, Puede implementarce¿?
     * @param x Posicion del NavBar del eje x
     * @param y Posicion del NavBar del eje y
     * @param width Es el ancho de la NavBar
     * @param height Es el largo de la NavBar
     * @return Un objeto de tipo JPanel que representa el metodo de navegacion del programa
     */
    public JPanel setUpNavBar(int x, int y, int width, int height){
        imageToButtonShut.setText("Boton Apagado.");
        imageToButtonShut.setBounds(0,0,50,50);

        buttonToRight.setBounds(850, 25, 50, 50);
        buttonToLeft.setBounds(750,25,50,50);
        buttonShutdown.setBounds(100,25,100,60);
        imageToButtonLeft.setText("<--");
        imageToButtonRight.setText("-->");


        navbar.add(buttonShutdown);
        navbar.add(buttonToRight);
        navbar.add(buttonToLeft);

        navbar.setBounds(x, y, width, height);
        navbar.setBackground(new Color(255,0,0)); //Los BackGround es una prueba de ubicacion
        navbar.setLayout(null);

        return this.navbar;
    }

    public void showNavBar(boolean signal){
        this.navbar.setVisible(signal);
    }

    //Implementar un metodo de decoracion, es decir alimetar a la vista con el modelo
    //Una vez capturado

    private void assambleAll(){
        JFrame windowsMain   = this.setUpWindow(1000, 600, "Mi ventana Principal");
        JPanel containerMain = this.setUpCotainer(150, 50, 700, 300);
        JPanel navBar        = this.setUpNavBar(0,470,1000,100);
        windowsMain.add(navBar);
        windowsMain.add(containerMain);
    }

    //Probablemente este metodo se quite y se controle directamente en el controlador
    private void showAll(){
        this.window.setVisible(true);
    }
   
    public void initView(){
        
        this.assambleAll();
        this.showAll();
    }

    //public static void main(String[] args) { MultipanelView mpv = new MultipanelView(); mpv.initView();}
}
