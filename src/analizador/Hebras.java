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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrián
 */
public class Hebras extends Thread{
    
    ArrayList <File> files;
    String packageName;
    boolean presencia = false;
    
    
    public Hebras (String str, ArrayList<File> files){
        super(str);
        this.packageName=str;
        this.files=files;
        
        
    }
    
    public void run(){
        
            for(int j=0;j<files.size();j++){

                    String cadena;
                    FileReader n = null;
                try {
                    n = new FileReader(files.get(j).getAbsoluteFile());
                } 
                catch (FileNotFoundException ex) {
                    Logger.getLogger(Hebras.class.getName()).log(Level.SEVERE, null, ex);
                }
                    BufferedReader b = new BufferedReader(n);

                try {
                    while((cadena = b.readLine())!=null) {

                        if(cadena.contains(this.packageName)){
                            this.presencia=true;
                        }
                        
                        //System.out.println(e.getKey() + " " + e.getValue());
                    }  
                } 
                
                catch (IOException ex) {
                    Logger.getLogger(Hebras.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
            //System.out.println(getName()+"    "+presencia);
    }
    
    
}
