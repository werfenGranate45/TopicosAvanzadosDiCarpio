import java.awt.Color;
import java.awt.TextArea;

//Para crear el paquete se debe tener el mismo nombre que la carpeta donde se aloja
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Como va tener la ventana los componentes tendra
 * 
 * Una ventana principal
 * Un panel que contiene una imagen , texto y sonido
 * La imagen y el texto son componentes totralmente diferentes, se añaden a la ventana principal
 */


public class MultipanelView {
    protected JFrame window;
    protected JPanel container, menu;
    protected JLabel imageOfContainer,imageToButtonRigth, imageToButtonLeft, imageToButtonShut;
    protected JButton buttonToRight, buttonToLeft, buttonShutdown;
    protected MultiPanelModel theModelObject;

    public MultipanelView(){
        window             = new JFrame();
        container          = new JPanel();
        menu               = new JPanel();
        imageOfContainer   = new JLabel();
        imageToButtonLeft  = new JLabel();
        imageToButtonRigth = new JLabel();
        imageToButtonShut  = new JLabel();
        buttonToRight      = new JButton();
        buttonToLeft       = new JButton();
        buttonShutdown     = new JButton();
        theModelObject     = new MultiPanelModel();
    }

    public ImageIcon escaledImage(String path, int width, int height){
        ImageIcon image = new ImageIcon(path);
        return new ImageIcon(image.getImage().getScaledInstance(width, height, 0));
    }

    //Hacer rehuso con parametros para que la vista solo cambie
    //Configuraremos el panel principal del menu
    private void setting(){
        window.setSize(1000, 600);
        window.setTitle("Ventana multipanel");
        window.setIconImage(new ImageIcon("RecursoLeft4Dead\\Images_use\\IconProgram.jpeg").getImage());
        window.setUndecorated(true);
        window.setBackground(new Color(0,0,0,0));
        window.setResizable(true);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        
        //Configuracion de los containers
        //X: 250 y Y:200
        container.setBounds(250,200,500, 200);
        container.setLayout(null);
        menu.setBounds(0, 460, 1000, 100);
        menu.setBackground(new Color(255,0,0));
        menu.setLayout(null);
        
        //Configuracion de todas las imagenes asi bien insanas, bueno son de las etiquetas del container pricipal
        //Ojo para las etiquetas debes de poner un setBounds, que digamoslo levanta la imagen
        imageOfContainer.setIcon(this.escaledImage("GUI_INTERFACE\\Tarea2\\RecursoLeft4Dead\\Images_use\\HomeroUchiha.jpeg", 500, 200));
        imageOfContainer.setBounds(0, 0, 500, 200);
        imageToButtonShut.setText("Boton Apagado.");
        imageToButtonShut.setBounds(0,0,50,50);
       
        //Comfiguras de los botones, en esta parte le ponemos las imagenes y los colocamos dentro del panel que va al sur
        buttonToRight.setBounds(850, 25, 50, 50);
        buttonToLeft.setBounds(750,25,50,50);
        buttonShutdown.setBounds(100,25,100,60);
        imageToButtonLeft.setText("<--");
        imageToButtonRigth.setText("-->");

    }

    private void assamble(){
        container.add(imageOfContainer);
        buttonToRight.add(imageToButtonRigth);
        buttonToLeft.add(imageToButtonLeft);
        menu.add(buttonToRight);
        menu.add(buttonToLeft);
        menu.add(buttonShutdown);
        window.add(menu); 
        window.add(container);
    }

    private void display(){
        window.setVisible(true);
    }

    public void initView(){
        this.setting();
        this.assamble();
        this.display();
    }

    class SubPanelManage{
        private JLabel image;
        private JPanel container;
        private JTextArea infoOfThing;
        private MultipanelView mpv;

        public void setImage(JLabel image){ this.image = image; }
        public void setMainView(MultipanelView mpv){ this.mpv = mpv;}
        public void setContainer(JPanel panel){ this.container = panel; }
        public void setTextArea(JTextArea textArea){ this.infoOfThing = textArea; }

        public JPanel getContainer(){ return this.container; }
        public JTextArea getTextArea(){ return this.infoOfThing; }
        public MultipanelView getViewMain(){ return this.mpv; }

        private void assemblePanel(){
            container.setSize(500,300);
            container.setBounds(250, 200, 500, 300);
            //Colocar imagen en el contendor
            infoOfThing.setBounds(400, 100, 500, 300);
            infoOfThing.setText("Hola aqui quiza va texto");
            infoOfThing.setToolTipText("Hola va texto");
        }

        private void joinComponent(){
            window.add(menu);
            window.add(this.container);
            window.add(this.infoOfThing);
        }

        private void noShow(){
            window.setVisible(false);
        }

        private void show(){
            window.setVisible(false);
        }

    }
}
