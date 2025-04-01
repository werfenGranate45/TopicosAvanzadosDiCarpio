package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
    private int selecter = 0; //

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
        JOptionPane.showMessageDialog(null, 
        "Ha finalizado", 
        "Se Acavoid", 
        JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private void connectModeltoView(String inputUser){
        mpm.setPathToModels(inputUser);
        mpm.setTheModels(new ArrayList<String[]>());
        mpv.setModel(mpm);
        spv.setModel(mpm);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String userInput;

        if(e.getComponent() == upv.getButtonSub()){
            
            userInput = upv.getFieldText().getText(); //Que se realiza en el parte del backend obtener el input del usuario
            this.connectModeltoView(userInput);       //Que se hace de parte en la vista solo se inabilita y abre la otra
            upv.enableUserPanel(false);
            this.runMainView(true);
        }
        if(e.getComponent() == mpv.getButtonStart()){
            this.mpv.enableMainPanel(false);
            this.runSubPanelView(true, ++selecter);
        }
        if(e.getComponent() == spv.getButtonToRight() ){
            this.runSubPanelView(false, selecter);
            selecter = (selecter == mpm.sizeOfModels()-1) ? selecter : ++selecter;
            this.runSubPanelView(true, selecter);
        }
        if(e.getComponent() == spv.getButtonToLeft()){
            this.runSubPanelView(false, selecter);
            selecter = (selecter == 1) ? 1 : --selecter;
            this.runSubPanelView(true, selecter);
        }
        if(e.getComponent() == upv.getButtonCan() 
            || e.getComponent() == mpv.getButtonShut()
            || e.getComponent() == spv.getButtonShut())
                shutDown();
        
        super.mouseClicked(e);
    }

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

    private void runSubPanelView(boolean signal, int number){
        spv.enableSubPanel(signal,number);
        spv.getButtonToLeft().addMouseListener(this);
        spv.getButtonToRight().addMouseListener(this);
        spv.getButtonShut().addMouseListener(this);
    }
}


