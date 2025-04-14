
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.util.ArrayList;

public class PersonDB {
    /*
     * Siempre al crear la clase con la que va intercuar la base de datos
     * hemos de crear 7 variables privadas que nos ayudaran a conectarnos a la base de datos
     * Como 
     * -- DriverManager para indicar la ubicacion de la base de datos y acceder al servidor
     * -- Connection para crear la conexion con la base de datos
     * -- Statement para ejecutar las consultas SQL
     * -- ResultSet para almacenar los resultados de las consultas SQL
     * -- SQLException para manejar las excepciones que puedan ocurrir al interactuar con la base de datos
     * -- String para almacenar la URL de la base de datos, el usuario y la contraseña
     */

    //Los datos necesarios para conectarse a la base de datos
    private final String JDBC_URL = "jdbc:derby://localhost:1527/TestDB;";
    //private final String USER     = ""; // Usuario de la base de datos
    //private final String PASSWORD = ""; // Contraseña de la base de datos

    //Las variables para el manejo de la conexion de la base de datos 
    private Connection connection;   
    private Statement statement;
    private ResultSet resultSet;
    private ArrayList<String> listPerson;

    
    private LocalDate getActualDate(){
        return LocalDate.now();
    }

    //Este metodo conectaremos a la base de datos
    public void openDatabase() throws SQLException{
        connection = DriverManager.getConnection(JDBC_URL);
        System.out.println("Si ve esto, usted se ha conectado a la base de datos.");
    }

    //Creacion de un elemento persona en la base de datos
    public void createPerson(String name, String lastName) throws SQLException{
        String createSQL;
        
        statement = connection.createStatement();
        createSQL =  "INSERT INTO person (name, last_name, created_at, update_at)";
        createSQL += "VALUES ('" + name + "', '" + lastName + "', '" + getActualDate() + "', '" + getActualDate() + "')";
        
        statement.executeUpdate(createSQL); //Este metodo se encarga de inserccion, actualizacion y eleminacion de datos
        System.out.println("La persona ha sido creada.");
    }

    //Este metodo almacena y obtiene los elementos de la tabla persona en la DB
    public ArrayList<String> getAll() throws SQLException{
        listPerson = new ArrayList<String>();
        String sqlGet = "SELECT * FROM person";
        String name, lastName, createdAt;
        int id;

        //Este metodo se encarga de la consulta de datos
        //statement = connection.createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.FETCH_FORWARD); 
        //No ocupo scroll ni updates lo dejamos asi
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sqlGet); //Este metodo se encarga de la consulta de datos
        
        /*
         * Ese index es el de la columna no del id entoces esta mal
         * es mejor usar el nombre de la columna o el numero de la columna propia
         */
        while (resultSet.next()) {
            id        = resultSet.getInt("id_person");
            name      = resultSet.getString("name");
            lastName  = resultSet.getString("last_name");
            createdAt = resultSet.getDate("update_at").toString();
            listPerson.add(id + " " +name +" "+ lastName + " "+ createdAt);
        }

        return listPerson;
    }

    //Este metodo se encarga de cerrar la base de datos
    public void closeDatabase() throws SQLException{
        if (connection != null) {
            connection.close();
            System.out.println("Si ve esto, usted se ha desconectado de la base de datos.");
        }
    }
    
}
