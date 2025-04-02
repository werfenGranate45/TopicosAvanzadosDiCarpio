package Another_try;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private final String USER     = ""; // Usuario de la base de datos
    private final String PASSWORD = ""; // Contraseña de la base de datos

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
        connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        System.out.println("Si ve esto, usted se ha conectado a la base de datos.");
    }

    //Creacion de un elemento persona en la base de datos
    public void createPerson(String name, String lastName) throws SQLException{
        String createSQL;
        
        statement = connection.createStatement();
        createSQL =  "INSERT INTO person (name, last_name, created_at, updated_at)";
        createSQL += "VALUES ('" + name + "', '" + lastName + "', '" + getActualDate() + "', '" + getActualDate() + "')";
        
        statement.executeUpdate(createSQL); //Este metodo se encarga de inserccion, actualizacion y eleminacion de datos
        System.out.println("La persona ha sido creada.");
    }

    //Este metodo almacena y obtiene los elementos de la tabla persona en la DB
    public void getAll() throws SQLException{
        String sqlGet = "SELECT id_person FROM person";
        String name, lastName, createdAt, updatedAt;
        int index = 1, id;

        //Este metodo se encarga de la consulta de datos
        statement = connection.createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.FETCH_FORWARD); 
        resultSet = statement.executeQuery(sqlGet); //Este metodo se encarga de la consulta de datos
        
        while (resultSet.next()) {
            id        = resultSet.getInt(index);
            name      = resultSet.getString(index);
            lastName  = resultSet.getString(index);
            createdAt = resultSet.getDate(index).toString();
            index++;
        }
    }

    public void getByID(int id){
        //TODO implementar metodo para obtener un elemento de la tabla por ID o nombre
   }
    //Este metodo se encarga de cerrar la base de datos
    public void closeDatabase() throws SQLException{
        if (connection != null) {
            connection.close();
            System.out.println("Si ve esto, usted se ha desconectado de la base de datos.");
        }
    }
    
}
