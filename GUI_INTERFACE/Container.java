

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Container {

    private JFrame window;
    private JPanel table, container;
    private JLabel wallpaperlb, text; 
    private JButton button1, button2, button3;
    private ImageIcon wallpaper, icon, image1, image2, image3;
    private String[] pathdirectory = {
        "Images_use\\Evangelion.jpg", 
        "Images_use\\cps.jpg",
        "Images_use\\Amlo.jpg",
        "Images_use\\Muerte.jpg"
    };

    public Container(){
        text        = new JLabel();
        window      = new JFrame();
        table       = new JPanel();
        container   = new JPanel();
        wallpaperlb = new JLabel();
        //imagelb1    = new JLabel();
        //imagelb2    = new JLabel();
        //imagelb3    = new JLabel();
        button1     = new JButton();
        button2     = new JButton();
        button3     = new JButton();
        wallpaper   = new ImageIcon(pathdirectory[0]);
        icon        = new ImageIcon(pathdirectory[1]);
        image1      = new ImageIcon(pathdirectory[3]);
        image2      = new ImageIcon(pathdirectory[3]);
        image3      = new ImageIcon(pathdirectory[2]);
    }

    void setting(){
        int[][] dimension = {
            {wallpaper.getIconWidth(), wallpaper.getIconHeight()}, 
            {image1.getIconWidth(), image1.getIconHeight()},
            {image2.getIconWidth(), image2.getIconHeight()},
            {image3.getIconWidth(), image3.getIconHeight()}
        };
        
        this.window.setSize(dimension[0][0], dimension[0][1]);
        this.window.setTitle("Es la prueba del contenerdor de imagenes");
        this.window.setBounds(0, 0, dimension[0][0], dimension[0][1]);
        this.window.setLocationRelativeTo(null);
        this.window.setIconImage(this.icon.getImage()); //esta da un icono a la imagen
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.table.setPreferredSize(new Dimension(dimension[0][0], dimension[0][1]));
        this.table.setLayout(null);
       
        //Configurando el texto para agregarlo al Panel de container
        this.text.setText("Waifu's Chamber");
        this.text.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        
        this.container.setBackground(new Color(255, 255, 255));
        this.container.setBounds(900, 100, 300, 500);

        this.wallpaperlb.setIcon(wallpaper);
        this.wallpaperlb.setBounds(0,0,dimension[0][0], dimension[0][1]);

        //Parte de la configuracion de las imagenes
        this.button1.setIcon(image1);
        this.button1.setBounds(50, 20, dimension[1][0], dimension[1][1]);
        this.button2.setIcon(image2);
        this.button2.setBounds(50, 250, dimension[2][0], dimension[2][1]);
        this.button3.setIcon(image3);
        this.button3.setBounds(50, 500, dimension[3][0], dimension[3][1]);
         
    }

    void join(){
        this.table.add(button1);
        this.table.add(button2);
        this.table.add(button3);
        this.container.add(text);
        this.table.add(container);
        this.table.add(wallpaperlb);

        this.window.add(table);
        
    }

    void display(){
        this.window.setVisible(true);
    }

    public static void main(String[] args) {
        Container c = new Container();

        c.setting();
        c.join();
        c.display();
    }
}
