import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonManager {
    PersonDB managerDB;
    private Scanner  scanner;
    //Instanciamos el objeto

    PersonManager(){
        managerDB = new PersonDB();
        scanner   = new Scanner(System.in);
    }

    public int menu(){

        System.out.println("----------------------------------");
        System.out.println("1. Para agregar persona.");
        System.out.println("2. Para obtener todas las personas");
        System.out.println("3. Salir");
        System.out.println("----------------------------------");
        int opc = scanner.nextInt();

        return opc;
    }

    public void createPerson() throws SQLException{
        String name, lastName;

        System.out.print("Dame el nombre de la person: ");
        name = scanner.nextLine();
        System.out.print("Dame el apellido: ");
        lastName = scanner.nextLine();
        managerDB.createPerson(name, lastName);
    }

    public void readPerson() throws SQLException{
        ArrayList<String> persons = managerDB.getAll();

        for (String person : persons) 
            System.out.println(person);
    }

    public void selecter(int opc) throws SQLException{

        switch (opc) {
            case 1:
            scanner.nextLine(); 
            createPerson(); 
            break;
            case 2: readPerson(); break; 
            case 3: System.out.println("Adios"); break;
        }
    }

    public static void main(String[] args) throws SQLException {
        PersonManager pm = new PersonManager();
        int opc = 0;
        pm.managerDB.openDatabase();

        do {    
            opc = pm.menu();
            pm.selecter(opc);
        } while (opc != 3);

        pm.managerDB.closeDatabase();
        pm.scanner.close();
    }
}
