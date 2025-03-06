package Tarea1;

import java.io.File;

public class DisplayInfoModel {
    //Uso de lectura de archivos para cambiar al informacion en cualquier momento
    //Por ahora usamos desde el codigo
    //Se reuiere manejo de archivos
    //Por ahora pura mierda son constantes a la madre
    private String titleWindow;
    private String mainPath;
    //String imagesPath[] = new String[10];

    public boolean setTitleWindow(String titleWindow){
        if(titleWindow.length() != 0){
            this.titleWindow = titleWindow;
            return true;
        }else return false;

    }

    public boolean setMainPath(String mainPath){
        if(mainPath.length() != 0){
            this.mainPath = mainPath;
            return true;
        }else return false;
    }

    public String getTitleWindow(){ return this.titleWindow; }
    public String getMainPath(){ return this.mainPath; }

    private File[] openSources(String path){
        File directory = new File(path);
        File[] files   = null;

        if(directory.isDirectory())
            files = directory.listFiles();
            
        return files;
    }

    public String[][] nameAndPaths(){
        File[] files        = this.openSources(this.mainPath);
        String[][] pathName = new String[files.length][files.length];

        for (int i = 0; i < files.length; i++) {
                String[] pathAndName = {files[i].getAbsolutePath(), files[i].getName()};
                pathName[i]          = pathAndName;
            }
        
        return pathName;
    }

    public String[][] nameAndPaths(String path){
        File[] files        = this.openSources(path);
        String[][] pathName = new String[files.length][files.length];

        for (int i = 0; i < files.length; i++) {
                String[] pathAndName = {files[i].getAbsolutePath(), files[i].getName()};
                pathName[i]          = pathAndName;
            }
        
        return pathName;
    }
      
}
    
