import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

public class MultiPanelModel {

    /*
     * Como modelo tendremos que usar las imagenes del Left
     * Los sonidos de cada infectado
     */

    private String pathToModels;
    private BufferedReader fileToRead;

    public void setPathToModels(String path){ this.pathToModels = path; }
    public String getPathToModels(){ return this.pathToModels; }

    private void openFile(String path){

        try {
            fileToRead      = new BufferedReader(new FileReader(path));
        } catch (Exception e) {
            System.err.println("No se pudo abrir el archivo");
            System.exit(0);
        }
    }

    private String[] readFile(String path){
        this.openFile(path);
        String[] pathToModels = new String[100];
        int i = 0;

        try {
            fileToRead.readLine();
            while (fileToRead.ready()) 
                pathToModels[i++] = fileToRead.readLine();
            
            this.closeFile(fileToRead);
            
        } catch (Exception e) {
            System.err.println("Se acavoid el programa");
            System.exit(0);
        }

        return pathToModels;
    }

    private void closeFile(BufferedReader dummyFile) throws IOException{ dummyFile.close(); }

    /*Falta mejor implementacion para que te divida el arregleo con uso de split*/
    public String[] getAllModels(){
        this.openFile(pathToModels);
        return this.readFile(pathToModels);
    }
}
