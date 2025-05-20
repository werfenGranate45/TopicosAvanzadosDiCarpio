package main.java.model;
import main.java.managerdb.ManagerDB;

import java.util.Random;

public class ModelWordle { //Clase que se encarga de tener el problema
    private int upperLimit;
    private int lowerLimit;
    private int pkWord;
    private ManagerDB managerDB;
    private final String dbURL = "jdbc:derby:./database/WordleDB";
    private final String tableName = "words";
    private final String pkColumn  = "PKWord";
    private final String column = "word";

    
    //Verificar que upperloweLimit sea menor que upperLimit+1
   
    /**
     * Constructor que inicializa el limite superior y limite donde se buscara la llave
     * primaria dentro de la base de datos e inicializa un objeto de tipo ManagerDB
     */
    public ModelWordle(int lowerLimit, int upperLimit){
        this.upperLimit = upperLimit+1;
        this.lowerLimit = lowerLimit;
        managerDB       = new ManagerDB();
    }

    /**
     * Le asigna un valor random a la llave primaria a buscar
     */
    private void getRandomNumber(){
        pkWord = new Random().nextInt(lowerLimit, upperLimit);
    }

    /**
     * Busca la palabra dentro de la base de datos por la llave primaria
     * @return Regresa la palabra como objeto de tipo String
     */
    public String getRandomWord(){
        String word;
        this.getRandomNumber();
        //Checar que se guarden dentro de la base de datos correctamente
        managerDB.setURLDB(dbURL);

        managerDB.openDatabase();
        word = (String) managerDB.getDataByPk(tableName, pkColumn, column, pkWord);
        managerDB.closeDatabase();

        return word;
    }
}
