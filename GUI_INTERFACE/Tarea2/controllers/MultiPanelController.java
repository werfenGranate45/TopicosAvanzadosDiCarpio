package controllers;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import models.MultiPanelModel;
import view.MainPanelView;
import view.SubPanelView;
import view.UserPanelView;

public class MultiPanelController extends MouseAdapter{
    private MainPanelView mpv;
    private UserPanelView upv;
    private SubPanelView spv;
    private MultiPanelModel mpm;

    public MultiPanelController(){
        this.mpm = new MultiPanelModel();
        this.mpv = new MainPanelView();
        this.upv = new UserPanelView();
        this.spv = new SubPanelView();
    }

    public MultiPanelController(MultiPanelModel mpm, MainPanelView mpv, UserPanelView upv, SubPanelView spv){
        this.mpm = mpm;
        this.mpv = mpv;
        this.upv = upv;
        this.spv = spv;
    }

    public void setMainView(MainPanelView mpv){ this.mpv = mpv; }
    public void setUserView(UserPanelView upv){ this.upv = upv; }
    public void setSubView(SubPanelView spv){ this.spv = spv; }
    public void setModel(MultiPanelModel mpm){ this.mpm = mpm; }

    public MainPanelView getMainView(){ return this.mpv; }
    public UserPanelView getUserView(){ return this.upv; }
    public SubPanelView getSubPanelView(){ return this.spv; }
    public MultiPanelModel getModel(){ return this.mpm; }

    
    protected void shutDown(){
        JOptionPane.showMessageDialog(null, "Ha finalizado", "Se Acavoid", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    protected void connectModeltoView(String inputUser){
        mpm.setPathToModels(inputUser);
        mpv.setModel(mpm);
        spv.setModel(mpm);
    }

    protected void addMouseListeners(Component components[], MouseListener mouselistener){
        for (int i = 0; i < components.length; i++) 
            components[i].addMouseListener(mouselistener);
    }

    

    /**
    * Para que jale todo lo que hemos hecho tenemos que colocarlo dentro del controlador asi bien perron
    * Quien lo diria no??
    */
    protected void runView(boolean signal, Component comp[], MouseListener MouseListener){
        this.addMouseListeners(comp, MouseListener);
    }
}


