package view;

import java.awt.Color;
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
    private JPanel[] imageContainers, containers;
    private int limit;
    private JTextArea[] infoTextAreas;
    
    public void setButtonToLeft(JButton buttonToLeft) { this.buttonToLeft = buttonToLeft; }
    public void setInfoText(JTextArea infoText) { this.infoText = infoText; }
    public void setButtonToRight(JButton buttonToRight) { this.buttonToRight = buttonToRight; }
    public void setNavbar(JPanel navbar){this.navbar = navbar;}
    public void setContainer(JPanel container){this.container = container; }

    public JTextArea getInfoText() { return this.infoText; }
    public JButton getButtonToLeft() { return this.buttonToLeft; }
    public JButton getButtonToRight() { return this.buttonToRight; }
    public JPanel  getNavBar(){ return this.navbar; }
    public JPanel  getContainer(){ return this.container; }
    
    public SubPanelView(){
        super();
        this.navbar      = new JPanel();
        this.container   = new JPanel();
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
        this.imageContainer.setBackground(new Color(255, 0, 0));
    }

    private void decoratorComponets(){
        
        ArrayList<String[]> paths = super.getModel().getAllModels();
        limit = paths.size()-1;
        JLabel images[]      = new JLabel[limit]; 
        this.imageContainers = new JPanel[limit];
        this.containers      = new JPanel[limit];

        for (int i = 0; i < limit; i++) {
            images[i] = super.setUpLabelImage(0, 0, 400, 475, escaledImage((paths.get(++i)[1]), 400,475));
            //En containeres agregar el info text
            imageContainers[i] = (JPanel) setUpPanel(50, 10, 400, 475).add(images[i]);
            containers[i]      = (JPanel) setUpPanel(150, 100, 900, 500).add(imageContainers[i]);
            
        }
    }

    private void setUpAll(){
        this.setUpImagePanel();
        //this.setUpContainer();
        this.setUpNavbar();
        //this.setUpTextArea();
        this.setUpButtonShut();
        this.setUpButtonLeft();
        this.setUpButtonRight();
    }

    private void assambleSubView(){
        
       this.setUpAll();
       navbar.add(this.buttonToLeft);
       navbar.add(this.buttonToRight);
       navbar.add(this.buttonToShutDown);
       JFrame frames[] = new JFrame[limit];
       //Al container se le asignara nueve paneles diferentes y/o nueve containeres diferentes
       for (int i = 0; i < limit; i++ ){
            super.setUpWindow(1200, 700, "Sub Panel No"+(i+1));
            super.getWindow();

            frames[i].add(this.containers[i]);
            frames[i].add(navbar);
       }
       container.add(this.imageContainer);
       container.add(this.infoText);
      
       
       super.getWindow().add(this.container);
       super.getWindow().add(this.navbar);
    }

    public void enableSubView(boolean signal){
        if(signal){
            this.assambleSubView();
            this.getWindow().setVisible(signal);
        }else
            this.getWindow().setVisible(signal);
    }

    public static void main(String args[]){
        new SubPanelView().enableSubView(true);
    }
}
