package Tarea1;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayInfoView {

    /*
     * 1. 3 Botones
     * 2. Ventana - con un wallpaper se usara como un label
     * 3: Un Panel que servira como Container - donde se despliega la info
     * 4: imagenes
     */
    protected JButton button1, button2, button3;
    protected JFrame windowFrame;
    protected JLabel wallpaperlb;
    protected JPanel table, containerInfo;
    protected DisplayInfoModel model;
    protected ImageIcon image1,image2,image3, wallpaper;

    
    //Aplicar los setters y getters
    public DisplayInfoView(){
        windowFrame   = new JFrame();
        button1       = new JButton();
        button2       = new JButton();
        button3       = new JButton();
        containerInfo = new JPanel();
        table         = new JPanel();
        wallpaperlb   = new JLabel();
        this.model    = new DisplayInfoModel();
    }

    /*
     * Falta mejorar para otras imagenes de tipo jpg, png etc jpeg falta mas versatibilidad
     */
    private void instancesImages(){
        int[] indexes = new int[3];
        model.setMainPath("C:\\Users\\agust\\Documents\\TheCarpios\\GUI_INTERFACE\\Tarea1\\Evangelion\\");
        
        String[][] nameAndPath = model.nameAndPaths();

        for (int i = 0; i < nameAndPath.length; i++)
            if (nameAndPath[i][1].toLowerCase().equals("wallpaper.jpg")) 
                wallpaper  = new ImageIcon(nameAndPath[i][0]);
            else
                indexes[i] = i;

        image1 = new ImageIcon(nameAndPath[indexes[0]][0]);
        image2 = new ImageIcon(nameAndPath[indexes[1]][0]);
        image3 = new ImageIcon(nameAndPath[indexes[2]][0]);
    }

    private int[][] getSizes(){
        this.instancesImages();

        int[][] sizes = {
            {wallpaper.getIconWidth(), wallpaper.getIconHeight()},
            {image1.getIconWidth(), image2.getIconHeight()},
            {image2.getIconWidth(), image2.getIconHeight()},
            {image3.getIconWidth(), image3.getIconHeight()}
        };

        return sizes;
    }

    private String getTitle(){
       
        String newPath     = model.getMainPath().replace("/", "\\\\");
        String[] splitPath = newPath.split("\\\\");
        return splitPath[splitPath.length-1];
    }

    private void settings(){
        int[][] sizes = this.getSizes();
        String title  = this.getTitle();
        
        //Puedes 
        windowFrame.setSize(sizes[0][0], sizes[0][1]);
        windowFrame.setTitle(title);
        windowFrame.setBounds(0, 0, sizes[0][0], sizes[0][1]);
        windowFrame.setLocationRelativeTo(null);
        windowFrame.setResizable(false);
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Configuracion de los paneles
        table.setPreferredSize(new Dimension(sizes[0][0], sizes[0][1]));
        table.setLayout(null);
        containerInfo.setBackground(new Color(250, 128, 114));
        containerInfo.setBounds(900, 100, 300, 500);

        //Configuracion de los labes
        wallpaperlb.setIcon(wallpaper);
        wallpaperlb.setBounds(0,0,sizes[0][0], sizes[0][1]);

        //Configuracion de los botones
        button1.setIcon(image1);
        button1.setBounds(50, 20, sizes[1][0], sizes[1][1]);
        button2.setIcon(image2);
        button2.setBounds(50, 250, sizes[2][0], sizes[2][1]);
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setBorder(null);
        button2.setFocusable(false);
        button3.setIcon(image3);
        button3.setBounds(50, 450, sizes[3][0], sizes[3][1]);
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

    public void initView(){
        this.settings();
        this.join();
        this.display();
    }
}