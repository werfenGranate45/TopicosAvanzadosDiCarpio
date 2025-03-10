package view;

import javax.swing.JPanel;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import models.MultiPanelModel;

public class MainPanelView extends ManageView{
    private JPanel navbar, container;
    private JButton buttonStar, buttonShutDown;

    public MainPanelView(){
        super();
        this.navbar         = new JPanel();
        this.container      = new JPanel();
        this.buttonStar     = new JButton();
        this.buttonShutDown = new JButton();
    }

    public MainPanelView(JFrame win, MultiPanelModel mpm, JPanel navbar, JPanel container, JButton btoStart, JButton btoShut){
        super(win, mpm);
        this.navbar         = navbar;
        this.container      = container;
        this.buttonStar     = btoStart;
        this.buttonShutDown = btoShut;
    }

    public void setNavbar(JPanel navbar){this.navbar = navbar;}
    public void setContainer(JPanel container){this.container = container; }
    public void setBtonStart(JButton buttonStart){this.buttonStar = buttonStart; }
    public void setBtonShut(JButton buttonShut){this.buttonShutDown = buttonShut; }

    public JPanel  getNavBar(){ return this.navbar; }
    public JPanel  getContainer(){ return this.container; }
    public JButton getButtonStart(){ return this.buttonStar; }
    public JButton getButtonShut(){ return this.buttonShutDown; }

    private void setUpContainer(){
        this.container = super.setUpPanel(100, 50, 800, 400);
    }

    private void setUpNavbar(){
        this.navbar = super.setUpPanel(0, 470, 1000, 100);
    }

    private void setUpBtoStart(){
        this.buttonStar = super.setUpButton(800,10,100,70, "Start");
    }

    private void setUpBtoShut(){
        this.buttonShutDown = super.setUpButton(650, 10, 100, 70,"Apagar");
    }

    private void setUpAll(){
        this.setUpContainer();
        this.setUpNavbar();
        this.setUpBtoStart();
        this.setUpBtoShut();
    }

    public void giveTheModel(MultiPanelModel mpm){
        super.setModel(mpm);
    }

    //Consigo las direcciones asi bien insano
    private void decorateComponentes(){
        ArrayList<String[]> paths = super.getModel().getAllModels();
        ImageIcon imageOfContainer = super.escaledImage(paths.get(0)[2],800,400);

        JLabel labelInfo  = super.setUpLabelImage(0, 0, 500, 100, null);
        labelInfo.setText("Bienvenido a mi nuevo post");
        JLabel labelOfContainer = super.setUpLabelImage(0, 0, 800, 400, imageOfContainer);

        this.navbar.setOpaque(true);
        this.navbar.setBackground(new Color(0,0,0,0));
        this.container.add(labelOfContainer);
    }

    private void assambleView(){
        this.setUpAll();
        super.setUpWindow(1000, 600, "Main View");

        this.navbar.add(this.buttonShutDown);
        this.navbar.add(this.buttonStar);
        this.decorateComponentes();

        super.getWindow().add(this.navbar);
        super.getWindow().add(this.container);
    }

    public void enableMainPanel(boolean signal){
        if (signal){
            this.assambleView();
            this.getWindow().setVisible(signal);
        }else
            this.getWindow().setVisible(signal);
    }
}
