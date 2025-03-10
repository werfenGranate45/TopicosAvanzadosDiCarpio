import controllers.*;
import view.*;
import models.*;

public class MultiPanel{
   private UserPanelView userView = new UserPanelView();
   private MainPanelView mainView = new MainPanelView();
   private SubPanelView  subpView = new SubPanelView();


   
   public static void main(String[] args) {
    UserPanelController init;
    init = new UserPanelController(new MultiPanelModel(), new MainPanelView(), new UserPanelView(), new SubPanelView());
    init.run();

   }
}