package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class SubPanelView extends ManageView{
    private JTextArea infoText;
    private JButton buttonToLeft, buttonToRight, buttonToShutDown;
    private JPanel navbar, container, imageContainer;
    private JLabel countLabel;
    private JFrame window;

    public void setButtonToLeft(JButton buttonToLeft) { this.buttonToLeft = buttonToLeft; }
    public void setInfoText(JTextArea infoText) { this.infoText = infoText; }
    public void setButtonToRight(JButton buttonToRight) { this.buttonToRight = buttonToRight; }
    public void setNavbar(JPanel navbar){this.navbar = navbar;}
    public void setContainer(JPanel container){this.container = container; }

    public JTextArea getInfoText() { return this.infoText; }
    public JButton getButtonToLeft() { return this.buttonToLeft; }
    public JButton getButtonToRight() { return this.buttonToRight; }
    public JButton getButtonShut(){ return this.buttonToShutDown; }
    public JPanel  getNavBar(){ return this.navbar; }
    public JPanel  getContainer(){ return this.container; }
    
    public SubPanelView(){
        super();
        this.navbar         = new JPanel();
        this.container      = new JPanel();
        this.infoText       = new JTextArea();
        this.buttonToLeft   = new JButton();
        this.buttonToRight  = new JButton();
    }

    private void setUpTextArea(){
       this.infoText = super.setUpTextArea(500, 50, 300, 400);
    }

    private void setUpButtonShut(){
       this.buttonToShutDown = super.setUpButton(200, 10, 100, 70,"Apagar");
    }

    private void setUpButtonLeft(){
        this.buttonToLeft = super.setUpButton(650,10,100,70, "Lef");
    }

    private void setUpButtonRight(){
        this.buttonToRight = super.setUpButton(800, 10, 100, 70,"Der");
    }

    private void setUpContainer(){
        this.container = super.setUpPanel(50, 100, 900, 500);
    }

    private void setUpNavbar(){
        this.navbar = super.setUpPanel(0, 615, 1200, 100);
    }

    private void setUpImagePanel(){
        this.imageContainer = super.setUpPanel(50, 10, 400, 475);
    }

    private void setUpLabelCount(){
        ImageIcon icon = super.escaledImage("_RecursoPublicos\\El_Panel_Nu",900,500);
        this.countLabel = super.setUpLabel(500, 50, 400, 55, icon);
    }

    private String readFile(String path){
        StringBuilder sb = new StringBuilder();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    
    /**
     * Este metodo se tratarea de decorar por completo todo el subpanel
     * Es decir sera como una cominacion de Unir, configurar y decorar
     * cada vista del subpanel se guardara en una lista de tipo SubPanel
     * 
     * Esa es la idea y mandarla -> con todo con el container principal
     * E incluida la navBar
     * 
     * Metodo raro le pondre ya directamente la ventana asi bien insano y bien configurado
     */
    private void decoratorComponetsAll(int numberModel){
        ImageIcon icon;
        JLabel    imagen;
        String    path;

        super.getModel().searchModel();
        ArrayList<String[]> paths = super.getModel().getTheModels();
        String[] model            = paths.get(numberModel);

        icon   = super.escaledImage(model[2],400,475);
        imagen = super.setUpLabel(0, 0, 400, 475, icon);
        path   = model[1];

        this.countLabel.setText("Panel No: "+numberModel);
        this.countLabel.setForeground(new Color(255, 160, 122));
        this.countLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        this.imageContainer.add(imagen);
        this.infoText.setText(readFile(path));
        
    }

    private void assambleNavbar(){
        navbar.add(this.buttonToLeft);
        navbar.add(this.buttonToRight);
        navbar.add(this.buttonToShutDown);
    }

    private void setUpAll(){
        this.setUpImagePanel();
        this.setUpContainer();
        this.setUpTextArea();
        this.setUpNavbar();
        this.setUpButtonShut();
        this.setUpButtonLeft();
        this.setUpButtonRight();
        this.setUpLabelCount();
    }

    private void assambleSubView(int number){

        ImageIcon iconWallpaper = super.escaledImage("_RecursoPublicos\\VoidWall.jpg",900,500);
        JLabel imagenWallpaper  = super.setUpLabel(0, 0, 900, 500, iconWallpaper);
        ImageIcon iconNav       = super.escaledImage("_RecursoPublicos\\El_Panel_Nu.jpg",1200,100);
        JLabel imagenNav        = super.setUpLabel(0, 0, 1200, 100, iconNav);

        this.setUpAll();                    //Configura los elementos para la vista
        this.decoratorComponetsAll(number); //Decoramos los componentes
        
        this.window = super.setUpWindow(1000, 700, 
                                  "Panel No "+(number), 
                                  true, 
                                  new Color(0,0,0,0)
        );
        
        this.assambleNavbar();
        this.navbar.add(imagenNav);
        this.container.add(this.imageContainer);
        this.container.add(this.infoText);
        this.container.add(imagenWallpaper);
        this.window.add(this.countLabel);
        this.window.add(this.container);
        this.window.add(this.navbar);
    }

    public void enableSubPanel(boolean signal, int number){
        if (signal) {
            this.assambleSubView(number);
            this.window.setVisible(true);            
        }else{
            this.window.setVisible(false);
            this.window.dispose(); //Liberamos la memoria de la ventana 
        }
    }
}
