package models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Un programa multipanel que va cambiar de imagen cada que aprieta una tecla 
 * Cada panel tendra la imagen del infectado, una descripcion del mismo y se reproduce el sonido de identicacion
 * Como modelo tendremos a un archivo csv que apunta a las urls de la ubicacion de las imagenes, sonidos e informacion
 * Los paneles no tendran fondo en cada despliegue para que se vea bonito
 * 
 * 1_* Paso descargamos las imagenes en formato jpg y le quitamos el fondo
 * 
 */

 /*
  * + MultiPanel
  * ---------------
  * - PathDelModelo: String
  * ---------------
  * + setPathDelModelo(string: pathDelModelo): void
  * + getPathDelModelo(): String  
  * - LeerArchivo(): String[]
  * - AbrirArchivo(): void
  * - CerrarArchivo(): void
  * + leerArchivo(string: path): String[]
  */

  //Crear o buscar una clase que se llame Manage Files para la lectura, escritura y manejo de archivos

public class MultiPanelModel {

    private String pathToModels;
    private ArrayList<String[]> theModels;
    private BufferedReader fileToRead;
    private final String extesion = "csv";

    private boolean isCSV(){
        return (pathToModels.endsWith(extesion)) ? true : false;
    }

    private void showMessageError(String message){
        JOptionPane.showMessageDialog(null, 
                                       message, 
                                       "Error", 
                                       JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }

    private void openFile(){
        if(this.isCSV())
            try {
                fileToRead      = new BufferedReader(new FileReader(this.pathToModels));
            } catch (Exception e) {
                this.showMessageError("No se pudo abrir el archivo.");
            }
        else
            this.showMessageError("No es un archivo CSV.");
    }

    private String[] readFileCSV(){
        
        String[] pathToModels = new String[100];
        int i = 0;

        try {
            fileToRead.readLine();

            while (fileToRead.ready()) 
                pathToModels[i++] = fileToRead.readLine();
            
            this.closeFile();
            
        } catch (Exception e) {
          this.showMessageError("No se pudo leer el archivo.");
        }

        return pathToModels;
    }

    private void splitLines(String[] readPaths){
        int i = 0;
            
        do
            theModels.add(readPaths[i++].split(","));
        while(readPaths[i] != null);

    }

    private void closeFile() throws IOException{ 
        this.fileToRead.close(); 
    }

    public void searchModel(){
        this.openFile();
        this.splitLines(this.readFileCSV());
    }

    public void setTheModels(ArrayList<String[]> theModels){
        this.theModels = theModels;
    }

    public ArrayList<String[]> getTheModels(){
        return this.theModels;
    }

    public void setPathToModels(String path){ 
        this.pathToModels = path; 
    }
    public String getPathToModels(){ 
        return this.pathToModels; 
    }

    public int sizeOfModels(){
        return this.theModels.size();
    }
}
