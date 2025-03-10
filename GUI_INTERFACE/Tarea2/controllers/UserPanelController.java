package controllers;

import java.awt.Component;
import java.awt.event.MouseEvent;

import models.MultiPanelModel;
import view.MainPanelView;
import view.SubPanelView;
import view.UserPanelView;

public class UserPanelController extends MultiPanelController{
    private String userInput;

    public UserPanelController(){
        super();
    }

    public UserPanelController(MultiPanelModel mpm, MainPanelView mpv, UserPanelView upv, SubPanelView spv){
        super(mpm, mpv, upv, spv);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
       
        super.mouseClicked(e);
    }

    private void addListeners(){
        super.getUserView().getButtonSub().addMouseListener(this);
        super.getUserView().getButtonCan().addMouseListener(this);
    }
    
    public void run(){
        super.getUserView().enableUserPanel(true);
        this.addListeners();
    }

    private void runMainView(){
        MainPanelController mpc = new MainPanelController();
        super.getMainView().enableMainPanel(true);
        super.addMouseListeners(new Component[]{
            super.getMainView().getButtonShut(),
            super.getMainView().getButtonStart()
        }, mpc);
    }
}