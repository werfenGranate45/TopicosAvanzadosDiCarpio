package main.java.model;
import main.java.managerdb.ManagerDB;

import java.util.Random;

public class ModelWordle {
    private int upperLimit;
    private int lowerLimit;
    private int pkWord;
    private ManagerDB managerDB;
    private final String[] metaData = {
        "jdbc:derby:./database/WordleDB",
        "words",
        "PKWord",
        "word"
    };
   
    /**
     * Constructor que inicializa el limite superior y limite donde se buscara la llave
     * primaria dentro de la base de datos e inicializa un objeto de tipo ManagerDB
     */
    public ModelWordle(int upperLimit, int lowerLimit){
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
        managerDB.setURLDB(metaData[0]);

        managerDB.openDatabase();
        word = (String) managerDB.getDataByPk(metaData[1], metaData[2], metaData[3], pkWord);
        managerDB.closeDatabase();

        return word;
    }
}
