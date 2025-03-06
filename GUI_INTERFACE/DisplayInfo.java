

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayInfo {
    /*
      1 Crear el Modelo
      2 Crear la Vista
      3 Crear el Controlador 
    */    

    public ImageIcon escalar(ImageIcon ima, int width, int height){
        return new ImageIcon(ima.getImage().getScaledInstance(width, height, 0));

    }

    class Controller extends MouseAdapter{

        
        
        //Añadir listeners
        public void addListeners(MouseEvent e){
            button1.addMouseListener(this);
            button2.addMouseListener(this);
            button3.addMouseListener(this);
        }
        //Configuramos el comportaieto de la logica dentro del metodo mouseCliked()
        
        @Override
        public void mouseClicked(MouseEvent e){
            JLabel labelDummy = new JLabel();
            //Sino usar el getComponente 
            if(e.getComponent() == button1){
                 labelDummy.setIcon(escalar(image1,containerInfo.getWidth(),image1.getIconHeight()));
                 containerInfo.setBounds(900, 100, 300, 500);
                 containerInfo.add(labelDummy);
                
                
            } if(e.getComponent() == button2){
                labelDummy.setIcon(escalar(image2,containerInfo.getWidth(),image1.getIconHeight()));
                containerInfo.add(labelDummy);
            } if(e.getComponent() == button3){
                labelDummy.setIcon(escalar(image3,containerInfo.getWidth(),image1.getIconHeight()));
                containerInfo.add(labelDummy);
            }
        }

        
    }
    private JButton button1, button2, button3;
    private JFrame windowFrame;
    private JLabel wallpaperlb;
    private JPanel table, containerInfo;
    private ImageIcon image1,image2,image3, wallpaper;

    
    //Aplicar los setters y getters
    public final String TITLE   = "Container' Infos";
    public final String[] PATHS = {
    
        "Tarea1\\Images_use\\wallpaper.jpg",
        "Tarea1\\Images_use\\Amlo.jpg"
    };

    public DisplayInfo(){
        windowFrame   = new JFrame();
        button1       = new JButton();
        button2       = new JButton();
        button3       = new JButton();
        containerInfo = new JPanel();
        table         = new JPanel();
        wallpaperlb   = new JLabel();
        wallpaper     = new ImageIcon(PATHS[0]);
        image1        = new ImageIcon(PATHS[1]);
        image2        = new ImageIcon(PATHS[1]);
        image3        = new ImageIcon(PATHS[1]);
    }

    private void settings(){

        //Colocar tamaño a la ventana
        windowFrame.setSize(1366, 768);
        windowFrame.setTitle("Contenedor de informacion Image");
        windowFrame.setBounds(0, 0, wallpaper.getIconWidth(), wallpaper.getIconHeight());
        windowFrame.setLocationRelativeTo(null);
        windowFrame.setResizable(false);
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Configuracion de los paneles
        table.setPreferredSize(new Dimension(wallpaper.getIconWidth(), wallpaper.getIconHeight()));
        table.setLayout(null);
        containerInfo.setBackground(new Color(255, 255, 255));
        containerInfo.setBounds(900, 100, 300, 500);

        //Configuracion de los labes
        wallpaperlb.setIcon(wallpaper);
        wallpaperlb.setBounds(0,0,wallpaper.getIconWidth(), wallpaper.getIconHeight());

        //Configuracion de los botones
        this.button1.setIcon(image1);
        this.button1.setBounds(50, 20, image1.getIconWidth(), image1.getIconHeight());
        this.button2.setIcon(image2);
        this.button2.setBounds(50, 250, image2.getIconWidth(), image2.getIconHeight());
        this.button3.setIcon(image3);
        this.button3.setBounds(50, 500, image3.getIconWidth(), image3.getIconHeight());
    }

    private void join(){
        table.add(button1);
        table.add(button2);
        table.add(button3);
        table.add(containerInfo);
        table.add(wallpaperlb);
        windowFrame.add(table);
    }

    private void display(){
        windowFrame.setVisible(true);
    }

    private void initView(){
        this.settings();
        this.join();
        this.display();
    }

    public void start(){
        this.initView();
    }

    public static void main(String[] args) {
        new DisplayInfo().initView();
      
    }

}
