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
        LocalDate dateToday         = LocalDate.now();
        String pattern              = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String dateFormated         = dateToday.format(formatter);
        CharSequence dateString     = dateFormated;
        LocalDate a = LocalDate.parse(dateString, formatter);
        
        return a;
    }

    public void createBook(String title, String author, String publisher, int year, float price) throws SQLException {
        Statement statement = connection.createStatement();
        String sqlTable  = "INSERT INTO book (title, author, publisher, year, created_at, updated_at)";
        String sqlValues = "VALUES ('" + title + "', '" + author + "', '" + publisher + "', " + year + ", "+this.getActualDate() + ", "+ this.getActualDate() + ")";

        String sql = sqlTable + sqlValues;
        statement.executeUpdate(sql);
        System.out.println("El libro ha sido creado.");
    }

    public void closeDatabase() throws SQLException {
        if (connection != null) {
            connection.close();
            System.out.println("Usted se ha desconectado de la base de datos.");
        }
    }

    
    
}
