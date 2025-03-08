import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
public class SubPanelManage extends MultipanelView{
     private JLabel image;
        private JPanel container;
        private JTextArea infoOfThing;
        private MultipanelView mpv;

        public void setImage(JLabel image){ this.image = image; }
        public void setMainView(MultipanelView mpv){ this.mpv = mpv;}
        public void setContainer(JPanel panel){ this.container = panel; }
        public void setTextArea(JTextArea textArea){ this.infoOfThing = textArea; }

        public JPanel getContainer(){ return this.container; }
        public JTextArea getTextArea(){ return this.infoOfThing; }
        public MultipanelView getViewMain(){ return this.mpv; }

        private void assemblePanel(){
            container.setSize(500,300);
            container.setBounds(250, 200, 500, 300);
            //Colocar imagen en el contendor
            infoOfThing.setBounds(400, 100, 500, 300);
            infoOfThing.setText("Hola aqui quiza va texto");
            infoOfThing.setToolTipText("Hola va texto");
        }

        private void joinComponent(){
            window.add(menu);
            window.add(this.container);
            window.add(this.infoOfThing);
        }

        private void noShow(){
            window.setVisible(false);
        }

        private void show(){
            window.setVisible(false);
        }
}
 */