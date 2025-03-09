import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JOptionPane;

public class MultiPanelController extends MouseAdapter{
    private UserPanelView upv;
    private MultiPanelModel mpm;

    public MultiPanelController(){
        upv	= new UserPanelView();
        mpm = new MultiPanelModel();
    }

    private void shutDown(){
        JOptionPane.showMessageDialog(null, "Ha finalizado", "Se Acavoid", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private void getFieldText(){
        String rutaUser = upv.getFieldText().getText();
        mpm.setPathToModels(rutaUser);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent() == upv.getButtonSub()) {
            this.getFieldText();
            upv.enableUserPanel(false);
        }
        if(e.getComponent() == upv.getButtonCan()){
            this.shutDown();
        }
    }

    private void addListeners(){
        upv.getButtonCan().addMouseListener(this);
        upv.getButtonSub().addMouseListener(this);
    }
    

    public void run(){
        upv.assamble();
        this.addListeners();
    }
}


