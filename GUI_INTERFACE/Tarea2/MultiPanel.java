import controllers.*;
import view.*;
import models.*;

public class MultiPanel{
   public static void main(String[] args) {
    MultiPanelController init;
    init = new MultiPanelController(new MultiPanelModel(), new MainPanelView(), new UserPanelView(), new SubPanelView());
    init.runView();
   }
}