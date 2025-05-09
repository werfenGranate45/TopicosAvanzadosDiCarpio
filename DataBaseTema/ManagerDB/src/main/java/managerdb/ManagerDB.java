package main.java.managerdb;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase de uso generica que tiene como funcionamiento conectar a la base de datos 
 * usandolo como dependencia con cualquier modelo que se vaya usar
 * cabe recalcar que es la metodologia usando Derby 
 * 
 * @version 1.0
 * @author Eduardo Agustin Cervantes Guerrero <23240389@leon.tecnm.mx>
 */
public class ManagerDB{
   
    private String urlDataBase;
    private String user;
    private String password;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    /**
     * Constructor por omision
     */
    public ManagerDB(){}

    /**
     * Contructor para inicialzar la ruta de la database
     * @param urlDB Direccion de la DataBase
     */
    public ManagerDB(String urlDB){
        this.urlDataBase = urlDB;
    }
    
    /**
     * Constructor para conectarse a la DataBase en caso de que tenga credenciales
     * Usuario y Contraseña
     * @param urlDB Direccion de la DataBase
     * @param user Usuario de la DataBase
     * @param password Contraseña de la DataBase
     */
    public ManagerDB(String urlDB, String user, String password){
        this.urlDataBase = urlDB;
        this.user        = user;
        this.password    = password;
    }


    private void showMessageError(String message, SQLException e){
        JOptionPane.showMessageDialog(
            null,
            "Error al conectar a la base de datos:\n" + e.getMessage(),
            "Error de SQL",
            JOptionPane.ERROR_MESSAGE
        );
    }

    /**
     * Hace la conexion de la DataBase 
     */
    public void openDatabase(){
        try{
            if(user != null && password != null)
                connection = DriverManager.getConnection(urlDataBase,user,password);
            else
                connection = DriverManager.getConnection(urlDataBase);

        }catch(SQLException e){
            this.showMessageError("No se pudo conectar a la base de datos", e);
        }
    }

    /**
     * Cierra la conexion de la base de datos
     */
    public void closeDatabase(){
        try {
            connection.close();
        } catch (SQLException e) {
            this.showMessageError("No se pudo cerrar la conexion a la base de datos", e);
        }
    }

    /**
     * Identifica si la conexion de la base de datos esta cerrada o abierta
     * si esta abierta manda True si esta cerrada manda False
     * @return Si esta abierta la conexion regresa {@code true}; De lo contrario {@code false}
     */
    public boolean isOpen(){
        boolean isOpen = false;

        try {
            isOpen = !(connection.isClosed());
            
        } catch (SQLException e) {
           this.showMessageError("No se puede verificar la apertura de la DataBase", e);
            isOpen = false;
        }

        return isOpen;
    }
    
    private void searchRecordByPk(String tableName, String columnPkey, int pKey) {
        String sql = "SELECT * FROM ";
        sql += tableName + " WHERE ";
        sql += columnPkey + " = "+ pKey;

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        }catch(SQLException e){
            this.showMessageError("No se pudo hacer la consulta especificada", e);
        }
    }

    /**
     * Metodo que te regresa todo los datos de una tabla dentro de la base de datos a al que hiciste conexion
     * Almacenaran y se retornaran en forma de una lista cada dato se hara en una oracion dividido por comas
     * 
     * Por ejemplo de una tabla de libro con las columnas 
     * {@code [Nombre, autor, precio, Editoriales]}
     * Entregara la siguiente informacion
     * {@code ["1984","George Orwell","500.99","Editores de Mexicanos"]
     * 
     * @return Un ArrayList con la informacion de cada columna 
     */
    public ArrayList<String> getAll(String tableName, String[] columns){
        ArrayList<String> info = new ArrayList<String>();
        
        String sql     = "SELECT * FROM "+tableName, data = "";
        int lenColumn  = columns.length; //Obtengo la cantidad de columnas a buscar
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                for (int i = 0; i < lenColumn; i++) {
                    data = resultSet.getObject(columns[i]).toString();
                    if(i < lenColumn - 1)
                        data += ",";
                }

                info.add(data);
                data = ""; //Reiniciamos el valor data en el que se guarda en el arreglo
            }
        } catch (SQLException e) {
            this.showMessageError("Hubo un error en la Base de datos: ", e);
            info = null;
        }

        return info;
    }

    /**
     * Metodo para obtener el valor del registro dado el nombre de la columna 
     * Busca el registro de la Base de datos filtrando por la llave primaria 
     * exacta dada usando el script sql {@code SELECT * FROM tableName WHERE idName = INTValue}
     * durante la ejecucion de este metodo asigna el atributo de la clase resultSet listo
     * para obtener informacion del registro unico que se obtuvo esta planeado solo
     * para tablas que carezcan llaves foraneas por ahora.
     * 
     * @param columnName El nombre de la columna
     * @param tableName El nombre de la tabla en la que se va buscar
     * @param columnPkey  El nombre de la columna que contenga la llave primaria
     * @param pKey El id del registro que se quiera buscar
     * @return Un objeto generico al que se le puede ser cast
     */
    public Object getDataByPk(String tableName, String columnPkey, String columnName, int pKey){

        try{
            searchRecordByPk(tableName, columnPkey, pKey);
            return (resultSet.next()) ? resultSet.getObject(columnName) : null;
        }catch(SQLException e){
            showMessageError("No se pudo obtener el valor del registro", e);
        }

        return null;
    }

    //Desde este punto se escriben los setters y getters de la base de datos

    /**
     * Configura el valor de ruta a la base de datos
     * @param urlDB Ruta de la base de datos
     * @return True si el valor es diferente de null de lo contrario falso
     */
    public boolean setURLDB(String urlDB){
        if (urlDB != null){ 
            this.urlDataBase = urlDB; 
            return true;
        }else return false; 
    }

    /**
     * Configura el valor del usuario de para acceder a la base de datos
     * @param user El nombre del usuario
     * @return Verdadero si el valor del usuario no fue nulo de los contrario falso
     */
    public boolean setUser(String user){
        if(user != null){
            this.user = user;
            return true;
        }else return false;
    }

    /**
     * Cambia el valor de la contraseña para acceder a la base de datos
     * @param password el valor de la contraseña
     * @return Verdadero si el valor del usuario no fue nulo, de lo contrario falso
     */
    public boolean setPassword(String password){
        if(password != null){
            this.password = password;
            return true;
        }else return false;
    }

    //Obtenemos los atributos de la clse Manager DB
    public String getURLDB(){ return this.urlDataBase; }
    public String getUser(){ return this.user;}
    public String getPassword(){ return this.password; }
}