package test;

import java.util.ArrayList;
import main.java.managerdb.ManagerDB;

public class Test {
    

    public static void main(String[] args) {
    
        ManagerDB db = new ManagerDB("jdbc:derby:./database/TestAPI");
        ArrayList<String> array;
        
        db.openDatabase();
        
        array = db.getAll("libro",new String[]{
            "titulo",
            "autor",
            "precio"
        });

        for (String data : array) {
            System.out.println(data);            
        }
        db.closeDatabase();

    }
    
}
