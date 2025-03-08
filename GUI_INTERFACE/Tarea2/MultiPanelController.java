import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class MultiPanelController {
    private MultipanelView mpv;
    private UserPanelView upv;

    public MultiPanelController(){
        mpv = new MultipanelView();
        upv	= new UserPanelView();
    }

    public void setMultipanelView(MultipanelView mpv){ this.mpv = mpv; }
    public MultipanelView getMultipanelView(){ return this.mpv; } 

    public void start(){
        MouseController mc = new MouseController();
    } 

    private void shutDown(){
        JOptionPane.showMessageDialog(null, "Ha finalizado", "Se Acavoid", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    //Controlador para darle vida al programa
    private class MouseController implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if( e.getComponent() == mpv.getButtonOff()){
                shutDown();
            }
           
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
        
        //Acciones a realizar cuando se presiona cada boton
        /**
         * Este es la accion para el boton de apagar
         */
       
    }     
}

