/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Adrián
 */
public class DirectorioApp {
    ArrayList<File> javarchivos=new ArrayList();
    
    public ArrayList revisarDirectorio() throws IOException{
        
                
        File f = new File("src");
        
        
        File[] ficheros = f.listFiles();
        
        javarchivos=searchForDatFiles(f,javarchivos);
        
        return javarchivos;
        
    }
    
    public ArrayList<File> searchForDatFiles(File root,ArrayList<File> lista)
    {
        
        boolean esta=false;
    
        if(root.isDirectory())
        {
            

            for(File file : root.listFiles())
                searchForDatFiles(file,lista);
        }
        
        else {
            //System.out.println(root.getName());
            for(int i=0;i<lista.size();i++){
                if(lista.get(i).getName().equalsIgnoreCase(root.getName())){
 
                    esta=true;
                }
            }
            
            if(!esta){
                lista.add(root);
            }
        }

        
        esta=false;
        
        return lista;
    }
}
