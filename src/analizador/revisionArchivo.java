/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Adrián
 */
public class revisionArchivo {
    
    public revisionArchivo(ArrayList<File> files) throws FileNotFoundException, IOException{
        
        for(int i=0;i<files.size();i++){
            System.out.println(files.get(i).getName());
           
            if(files.get(i).getName().equalsIgnoreCase("AndroidManifest.xml")){
            
                String cadena;
                FileReader n = new FileReader(files.get(i).getAbsoluteFile());
                BufferedReader b = new BufferedReader(n);

                while((cadena = b.readLine())!=null) {

                    System.out.println(cadena);

                }
            
            }
                 
                    
        }
        
    }
    
}
