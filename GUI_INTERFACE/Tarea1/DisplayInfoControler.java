package Tarea1;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DisplayInfoControler extends MouseAdapter{
    private DisplayInfoView  div;
    private JLabel dummyLabel;

    public DisplayInfoControler(){
        this.div        = new DisplayInfoView();
        this.dummyLabel = new JLabel();
    }

    public ImageIcon escaledImage(ImageIcon image, int width, int height){
        return new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    @Override
    public void mouseClicked(MouseEvent e){
        

        if(e.getComponent() == div.button1){ 
            
           dummyLabel.setIcon(escaledImage(div.image1,300,500));
           dummyLabel.setBounds(0, 0, 300, 500);
           div.containerInfo.add(dummyLabel);
           div.containerInfo.setVisible(true);
           //div.containerInfo.setBackground(new Color(0, 0, 255));
        }
        if(e.getComponent() == div.button2){ 
            dummyLabel.setIcon(escaledImage(div.image2, 300, 500));
            dummyLabel.setBounds(0, 0, 300, 500);
            div.containerInfo.add(dummyLabel);
            div.containerInfo.setVisible(true);
            //div.containerInfo.setBackground(new Color(255, 255, 0));
        }
        if(e.getComponent() == div.button3){ 
            dummyLabel.setIcon(escaledImage(div.image3, 300, 500));
            dummyLabel.setBounds(0, 0, 300, 500);
            dummyLabel.setLocation(0, 0);
            div.containerInfo.add(dummyLabel);
            div.containerInfo.setVisible(true);
            //div.containerInfo.setBackground(new Color(250, 128, 114));
        }
    }

    private void addListeners(){
        this.div.button1.addMouseListener(this);
        this.div.button2.addMouseListener(this);
        this.div.button3.addMouseListener(this);
    }

    //public void reload(){}

    public void stat(){ 

        addListeners(); 
        this.div.initView();
    }

}