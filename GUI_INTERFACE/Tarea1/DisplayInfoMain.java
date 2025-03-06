package Tarea1;

public class DisplayInfoMain {
    public static void main(String[] args) {
        new DisplayInfoModel();
        new DisplayInfoView();
        DisplayInfoControler dic = new DisplayInfoControler();
        dic.stat();
        
        
    }
}
