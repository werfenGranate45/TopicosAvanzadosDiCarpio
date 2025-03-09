package View;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MultiPanelModel;

public class UserPanelView extends ManageView{
      private JTextField pathField;
      private JButton buttonSumbmit;
      private JButton buttonCancel;
      private JPanel panelUser;

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
       * Este metodo configura un Campo de texto para usarse en el programa 
       * Este es el atributo que tiene la vista
       * @param columns Numero de columnas
       * @param x Pocision en X adentro del panel
       * @param y Pocision en Y adentro del panel
       * @param width Ancho del campo de texto
       * @param height Largo del campo de texto
       * No retorna nada es un setUP si quieres acceder con el usas los gettees
       */
      private void setUpTextField(int columns, int x, int y, int width, int height){
         this.pathField.setColumns(columns);
         this.pathField.setBounds(x, y, width, height);
         this.pathField.setBorder(null);
         this.pathField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
      }

      /**
       * Apartado para todas las construcciones y la arquitectura de la aplicacion
       * Usaremos los postulados de POO para acceder a los atributos por medio
       * de los getteres, claro que cuando usemos las funciones setUps 
       * Ya estaran listos para usarse 
       * @see setUpButton
       */

      private void setUpButtonSub(int x,int y, int widht, int height, String text){
         this.buttonSumbmit = super.setUpButton(x, y, widht, height, text);
      }

      private void setUpButtonCan(int x, int y, int widht, int height, String text){
         this.buttonCancel = super.setUpButton(x, y, widht, height,text);
      }

      private void setUpUserView(int x, int y, int widht, int height){  
         this.panelUser = super.setUpCotainer(x, y, widht, height);
      }


      private void setUpAll(){
         this.setUpTextField(10, 55, 75, 590, 50);
         this.setUpButtonSub(600, 150, 100, 50, "Enviar");
         this.setUpButtonCan(450, 150, 100, 50,"Cancelar");
         this.setUpUserView(150,200,700,200);
      }

      /**
       * La verdad esta mal organizado pero simplemente es un decorador que no pertenece
       * al modelo al que se va mostrar entoces esta bien supungo
       */
      private void decoratorComponets(){
         ImageIcon x       = super.escaledImage("RecursoPublicos\\FondoParaCapturaPath.jpg",700,200);
         JLabel labelPanel = super.setUpLabelImage(0, 0, 700, 200, x);
         JLabel advice     = super.setUpLabelImage(195, 0, 400, 55, null);
         advice.setText("Capture la ruta de su modelo.");
         advice.setForeground(new Color(255, 255, 255));
         advice.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
         labelPanel.setIcon(x);
         this.panelUser.add(advice);
         this.panelUser.add(labelPanel);
      }

      //Este metodo servira para ensamblar todos los componentes en uno
      //Solo vamos usar el atributo ventana de la clase padre
      public void assamble(){
         this.setUpAll();
        
         super.setUpWindow(1000, 600, "User View");
         
         this.panelUser.add(pathField);
         this.panelUser.add(buttonCancel);
         this.panelUser.add(buttonSumbmit);
         this.decoratorComponets();

         super.getWindow().add(this.panelUser);
         super.getWindow().setVisible(true);

      }

      public void enableUserPanel(boolean signal){
         this.panelUser.setEnabled(signal);
         this.panelUser.setVisible(signal);

      }
}
