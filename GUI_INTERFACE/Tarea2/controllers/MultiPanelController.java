package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    
    private void shutDown(){
        JOptionPane.showMessageDialog(null, "Ha finalizado", "Se Acavoid", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private void connectModeltoView(String inputUser){
        mpm.setPathToModels(inputUser);
        mpv.setModel(mpm);
        spv.setModel(mpm);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent() == upv.getButtonSub()){
            //Que se realiza en el parte del backend obtener el input del usuario
            String userInput = upv.getFieldText().getText();
            this.connectModeltoView(userInput);
            //Que se hace de parte en la vista solo se inabilita y habre la otra
            upv.enableUserPanel(false);
            this.runMainView(true);
        }
        if(e.getComponent() == mpv.getButtonStart()){
            System.out.println("Hola");
        }
        if(e.getComponent() == upv.getButtonCan() 
            || e.getComponent() == mpv.getButtonShut()
            || e.getComponent() == spv.getButtonShut()  )
            shutDown();
        
        super.mouseClicked(e);
    }

    /**
    * Para que jale todo lo que hemos hecho tenemos que colocarlo dentro del controlador asi bien perron
    * Quien lo diria no??
    */
    public void runView(){
        upv.enableUserPanel(true);
        upv.getButtonSub().addMouseListener(this);
        upv.getButtonCan().addMouseListener(this);
    }

    private void runMainView(boolean signal){
        mpv.enableMainPanel(signal);
        mpv.getButtonShut().addMouseListener(this);
        mpv.getButtonStart().addMouseListener(this);
    }
}


