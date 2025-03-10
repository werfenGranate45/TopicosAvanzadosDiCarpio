package controllers;

import java.awt.Component;
import java.awt.event.MouseEvent;

import view.*;
import models.MultiPanelModel;

public class MainPanelController extends MultiPanelController{
    
    public MainPanelController(){
        super();
    }

    public MainPanelController(MultiPanelModel mpm, MainPanelView mpv, UserPanelView upv, SubPanelView spv){
        super(mpm, mpv, upv, spv);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getComponent() == super.getMainView().getButtonStart()){
            //La parte del backend la verdad en este caso nada
            //La parte del frontend solo inabilita la pantalla y muestra la siguiente
            super.getMainView().enableMainPanel(false);
            //this.runSubPanelView()
            //super.getSubPanelView().enableSubPanelView(false);
        }
        if(e.getComponent() == getMainView().getButtonShut()){
            super.shutDown();
        }
        super.mouseClicked(e);
    }

    private void runSubPanelView(){


    }
}
