package view;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.MultiPanelModel;

public class UserPanelView extends ManageView{
      private JTextField pathField;
      private JButton buttonSumbmit;
      private JButton buttonCancel;
      private JPanel panelUser;
      private JFrame win;

      public UserPanelView(){
         new ManageView();
         this.pathField     = new JTextField();
         this.buttonSumbmit = new JButton();
         this.buttonCancel  = new JButton();
         this.panelUser     = new JPanel();
      }

      public UserPanelView(JFrame window, MultiPanelModel mpm, JTextField textF, JButton buttonSub, JButton buttonCan){
         super(window,mpm);
         this.pathField     = new JTextField();
         this.buttonSumbmit = new JButton();
         this.buttonCancel  = new JButton();
         this.panelUser     = new JPanel();
      }

      public void setPanelUser(JPanel panelUser){this.panelUser = panelUser; }
      public void setButtonSub(JButton buttonS){this.buttonSumbmit = buttonS; }
      public void setButtonCan(JButton buttonC){this.buttonCancel = buttonC; }
      public void setFieldText(JTextField fieldText){ this.pathField = fieldText; }

      public JPanel getPanelUser(){ return this.panelUser; }
      public JTextField getFieldText(){ return this.pathField; }
      public JButton getButtonSub(){ return this.buttonSumbmit; }
      public JButton getButtonCan(){ return this.buttonCancel; }

      
     

      /**
       * Apartado para todas las construcciones y la arquitectura de la aplicacion
       * Usaremos los postulados de POO para acceder a los atributos por medio
       * de los getteres, claro que cuando usemos las funciones setUps 
       * Ya estaran listos para usarse debido a que ya estan configurados
       * @see setUpButton
       */

      private void setUpButtonSub(){
         this.buttonSumbmit = super.setUpButton(600, 150, 100, 50, "Enviar");
      }

       private void setUpPathField(){
        this.pathField = super.setUpTextField(10, 55, 75, 590, 50);
      }

      private void setUpButtonCan(){
         this.buttonCancel = super.setUpButton(450, 150, 100, 50,"Cancelar");
      }

      private void setUpUserView(){  
         this.panelUser = super.setUpPanel(150,200,700,200);
      }

      /**
       * Este metodo sirve para configurar de una todos los atributos de las clases
       */
      private void setUpAll(){
         this.setUpPathField();
         this.setUpButtonSub();
         this.setUpButtonCan();
         this.setUpUserView();
      }

      /**
       * La verdad esta mal organizado pero simplemente es un metodo que decora los componentes de la clase
       * en esta vista no usamos un modelo para alimentar la vista sino recursos publicos de la computadora
       * que se esten usando.
       */
      private void decoratorComponets(){
         ImageIcon x       = super.escaledImage("_RecursoPublicos\\FondoParaCapturaPath.jpg",700,200);
         JLabel labelPanel = super.setUpLabelImage(0, 0, 700, 200, x);
         JLabel advice     = super.setUpLabelImage(195, 0, 400, 55, null);
         advice.setText("Capture la ruta de su modelo.");
         advice.setForeground(new Color(255, 255, 255));
         advice.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
         labelPanel.setIcon(x);
         this.panelUser.add(advice);
         this.panelUser.add(labelPanel);
      }

      /**
       * Este metodo hace la accion de ensamblar todos los atributos del panel y lo añade a la ventana
       * @apiNote El atributo ventana esta en la clase padre 
       * NOTA: Tengo duda si de verdad deberiamos configurar la ventana y agregar
       * el componente del panel ensamblado a la ventan o si usar un metodo aparte
       */
      private void assambleView(){
         this.setUpAll();
         this.win = super.setUpWindow(1000, 600, "User View",true,new Color(0,0,0,0));
         
         this.panelUser.add(pathField);
         this.panelUser.add(buttonCancel);
         this.panelUser.add(buttonSumbmit);
         this.decoratorComponets();

         win.add(this.panelUser);
      }

      /**
       * Metodo que sirve para el controlador para descativar y esconder el componente
       * @param signal Boleano que indica si se despliega y esconde el componente
       */
      public void enableUserPanel(boolean signal){
         if(signal){
            this.assambleView();
            this.win.setVisible(signal);
         }else{
            this.win.setVisible(signal);
         }
      }
}
