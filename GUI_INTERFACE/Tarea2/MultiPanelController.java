import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class MultiPanelController {

    private MultipanelView mpv;

    public MultiPanelController(){
        mpv = new MultipanelView();
    }

    public void start(){
        MouseController mc = new MouseController();
        mc.run();
    } 

    //Controlador para apagar el programa
    private class MouseController implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
           if(e.getComponent() == mpv.buttonShutdown)
                this.shutDown();
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
        private void shutDown(){
            JOptionPane.showMessageDialog(null, "Ha finalizado", "Se Acavoid", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        private void addListener(){
            mpv.buttonShutdown.addMouseListener(this);
        }

        public void run(){
            this.addListener();
            mpv.initView();
        }
        
    }
}
