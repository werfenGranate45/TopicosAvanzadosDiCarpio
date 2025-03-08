import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserPanelView extends MultipanelView{
      private JTextField pathField;

      public void setFieldText(JTextField fieldText){ this.pathField = fieldText; }
      public JTextField getFieldText(){ return this.pathField; }
     
      /**
       * Metodo que configura un Boton de subir solo lo contruye y le da vista
       * Nota: Estoy usando los botones de la clase principal sabe como salga
       * NOTA: Son privados que esta bien por que no los quiero importar sin embargo a lo mejor es
       * NOTA: Es util UN SetUPButtonSubimt para la clase principal
       * @param x Posicion del boton eje X
       * @param y Posicion del boton ejen Y
       * @param width Ancho del Boton
       * @param height Altura del Boton
       * @param text Texto que aparece en el boton
       * @return Un objeto de tipo Boton
       */
      private JButton setUpButtonSubmit(int x, int y, int width, int height, String text){
         super.setButtonRight(new JButton());
         //super.getButtonRight().setBounds(600, 150, 100, 50);;
         super.getButtonRight().setBounds(x,y,width,height);
         super.getButtonRight().setText(text);
         
         return super.getButtonRight();
      }

       /**
       * Metodo que configura un Boton de subir solo lo contruye y le da vista
       * Nota: Estoy usando los botones de la clase principal sabe como salga
       * Lo unico que cambia es el de cancelar
       * @param x Posicion del boton eje X
       * @param y Posicion del boton ejen Y
       * @param width Ancho del Boton
       * @param height Altura del Boton
       * @param text Texto que aparece en el boton
       * @return Un objeto de tipo Boton
       */
      private JButton setUpButtonShutDown(int x, int y, int width, int height, String text){
         super.setButtonLeft(new JButton());
         //super.getButtonLeft().setBounds(450, 150, 100, 50);
         super.getButtonLeft().setBounds(x,y,width,height);
         super.getButtonLeft().setText(text);
         
         return super.getButtonLeft();
      }

      /**
       * Este metodo configura un Campo de texto para usarse en el programa 
       * Este es el atributo que tiene la vista
       * @param columns Numero de columnas
       * @param x Pocision en X adentro del panel
       * @param y Pocision en Y adentro del panel
       * @param width Ancho del campo de texto
       * @param height Largo del campo de texto
       * @return Un objeto de tipo Text Field
       */
      public JTextField setUpTextField(int columns, int x, int y, int width, int height){
         pathField.setColumns(columns);
         pathField.setBounds(x, y, width, height);
         pathField.setBorder(null);
         pathField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
         
         return this.pathField;
      }

      /**
       * Configura el panel que el usuario usara para capturar su sistema de archivos
       * Lo tengo planeado que regrese por que se utilizara en el Controlador
       * Para quitarlo o agregarlo
       * IDEA QUE SURGE: Probablemente la vista solo usaremos los SetUp de los componetes osea quitar assamble View y ShowAll
       * @return Un objeto de tipo Panel
       */
      public JPanel setUpUserView(){
         super.setContainer(new JPanel());
         this.setUpTextField(10,55,75,590,50);
         JPanel panelUser = (JPanel) super.setUpCotainer(150,200,700,200);
         panelUser.add(this.setUpButtonSubmit(600, 150, 100, 50,"Enviar"));
         panelUser.add(this.setUpButtonShutDown(450, 150, 100, 50,"Cancelar"));
         panelUser.add(pathField);

         return panelUser;
     }

      public void showUserView(boolean signal){
         setUpUserView().setVisible(signal);
      }

      /*  
      Metodo inituil no se va usar a la verga 
      public void initView(){
         super.setWindow(new JFrame());
         super.setUpWindow(1000, 600, "Penis").add(this.setUpUserView());
         super.showWindow(true);
      }
         */
      /*
     public static void main(String[] args) { UserPanelView upv = new UserPanelView(); upv.setFieldText(new JTextField()); upv.initView(); }
      */
}
