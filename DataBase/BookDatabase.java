import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


//Este seria un DataBaseManager entonces
public class BookDatabase {

    private static final String JDBC_URL = "jdbc:derby://localhost:1527/library_book;";
    private static final String USER = "";
    private static final String PASSWORD = "";

    private Connection connection;

    public BookDatabase() throws SQLException {
        this.connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    public void openDatabase() throws SQLException{
        connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        System.out.println("Usted se ha conectado a la base de datos.");
    }

    private LocalDate getActualDate(){
        return LocalDate.now();
    }

    public void createBook(String title, String author, String publisher, int year, float price) throws SQLException {
        Statement statement = connection.createStatement();
        
        String sql = "INSERT INTO book (title, author, publisher, year, created_at, updated_at) VALUES ('" + title + "', '" + author + "', '" + publisher + "', " + year + ", '" + getActualDate()+ "', '" + getActualDate()+ "')";
        
        statement.executeUpdate(sql);
        
        System.out.println("El libro ha sido creado.");
    }

    public void readBook() throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM book");

        while (resultSet.next()) {
            String title     = resultSet.getString("title");
            String author    = resultSet.getString("author");
            String publisher = resultSet.getString("publisher");
            int year         = resultSet.getInt("year");
            System.out.println("Title: " + title + ", Author: " + author + ", Publisher: " + publisher + ", Year: " + year);
        }
    }

    public void closeDatabase() throws SQLException {
        if (connection != null) {
            connection.close();
            System.out.println("Usted se ha desconectado de la base de datos.");
        }
    }

    
    
}
