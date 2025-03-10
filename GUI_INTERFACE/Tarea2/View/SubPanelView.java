package view;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class SubPanelView extends MainPanelView{
    private JTextArea infoText;
    private JButton buttonToLeft, buttonToRight, buttonShutDown;
    
    public void setButtonToLeft(JButton buttonToLeft) { this.buttonToLeft = buttonToLeft; }
    public void setInfoText(JTextArea infoText) { this.infoText = infoText; }
    public void setButtonToRight(JButton buttonToRight) { this.buttonToRight = buttonToRight; }
    public void setButtonShutDown(JButton buttonShutDown) { this.buttonShutDown = buttonShutDown;}

    public JTextArea getInfoText() { return infoText; }
    public JButton getButtonToLeft() { return buttonToLeft; }
    public JButton getButtonToRight() { return buttonToRight; }
    public JButton getButtonShutDown() { return buttonShutDown; }
    
    public SubPanelView(){
        super();
        infoText       = new JTextArea();
        buttonToLeft   = new JButton();
        buttonToRight  = new JButton();
        buttonShutDown = new JButton();
    }

    
}
