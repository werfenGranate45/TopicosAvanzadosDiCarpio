package view;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import models.MultiPanelModel;

public class SubPanelView extends ManageView{
    private JTextArea infoText;
    private JButton buttonToLeft, buttonToRight, buttonToShutDown;
    private JPanel navbar, container, imageContainer;
    private ArrayList<JFrame> views = new ArrayList<JFrame>();

    public void setButtonToLeft(JButton buttonToLeft) { this.buttonToLeft = buttonToLeft; }
    public void setInfoText(JTextArea infoText) { this.infoText = infoText; }
    public void setButtonToRight(JButton buttonToRight) { this.buttonToRight = buttonToRight; }
    public void setNavbar(JPanel navbar){this.navbar = navbar;}
    public void setContainer(JPanel container){this.container = container; }
    public void setViews(ArrayList<JFrame> views){this.views = views; }

    public JTextArea getInfoText() { return this.infoText; }
    public JButton getButtonToLeft() { return this.buttonToLeft; }
    public JButton getButtonToRight() { return this.buttonToRight; }
    public JButton getButtonShut(){ return this.buttonToShutDown; }
    public JPanel  getNavBar(){ return this.navbar; }
    public JPanel  getContainer(){ return this.container; }
    public ArrayList<JFrame> getViews(){ return this.views; }
    
    public SubPanelView(){
        super();
        this.navbar         = new JPanel();
        this.container      = new JPanel();
        this.infoText       = new JTextArea();
        this.buttonToLeft   = new JButton();
        this.buttonToRight  = new JButton();
        this.views          = new ArrayList<JFrame>();
    }

    private void setUpTextArea(){
       this.infoText = super.setUpTextArea(500, 50, 300, 400);
    }

    private void setUpButtonShut(){
       this.buttonToShutDown = super.setUpButton(200, 10, 100, 70,"Apagar");
    }

    private void setUpButtonLeft(){
        this.buttonToLeft = super.setUpButton(800,10,100,70, "->");
    }

    private void setUpButtonRight(){
        this.buttonToRight = super.setUpButton(650, 10, 100, 70,"<-");
    }

    private void setUpContainer(){
        this.container = super.setUpPanel(150, 100, 900, 500);
    }

    private void setUpNavbar(){
        this.navbar = super.setUpPanel(0, 615, 1200, 100);
    }

    private void setUpImagePanel(){
        this.imageContainer = super.setUpPanel(50, 10, 400, 475);
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
    private void decoratorComponetsAll(){
        ImageIcon icon;
        JLabel imagen;
        JFrame windowOfSubpanel; 
        ArrayList<String[]> paths = super.getModel().getAllModels();
        int limit = paths.size()-1;

        for (int i = 1; i <= limit; i++) {
            icon = escaledImage(paths.remove(i)[2],400 , 475);
            imagen  = super.setUpLabelImage(0, 0, 400, 475, icon);

            this.setUpAll(); //Configura los elementos para la vista
            this.assambleView(imagen);
            this.assambleNavbar();
            super.setUpWindow(1000, 700, "Panel No "+(i));
            windowOfSubpanel = super.getWindow();
            windowOfSubpanel.add(this.container);
            windowOfSubpanel.add(this.navbar);
            
            this.views.add(windowOfSubpanel);   
        }
    }

    /**
     * Nota por ahora solo usaremos para imagen, pero como parametro habra un objeto de tipo
     * textArea para agregarlo al contenedor
     * @param imagen
     */
    private void assambleView(JLabel imagen){
        this.imageContainer.add(imagen);
        this.container.add(imageContainer);
        this.container.add(this.infoText);
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
    }

    //Necesitamos un metodo que en base a pulsar el boton de la derecha o izquierda acceda a la ventana de cada uno
    //Por medio de un numero obtendremos la vista y la habilitamos
   


    /**
     * Codigo medio redundate a la verga si esta miedo mierdilla creo que se puede mejorar
     * Alto cuidado puede que este medio mierdon
     * @param signal
     * @param windowInfo
     */
    public void initialenableSubView(boolean signal){
        if(signal){
            this.decoratorComponetsAll();
            this.views.get(0).setVisible(signal);
            this.views.get(0).setEnabled(signal);
        }else{
            this.views.get(0).setVisible(signal);
            this.views.get(0).setEnabled(signal);
        }
    }

    public static void main(String args[]){
    }
}
