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
public class Archivos {
    
    ArrayList permisos = new ArrayList();
    ArrayList publicidad = new ArrayList();
    
    ArrayList <File> files = new ArrayList();
    
    public void revisarPermisos() throws FileNotFoundException, IOException{
        
        FileReader archivo = new FileReader("Permisos.txt");
        
        BufferedReader lector = new BufferedReader(archivo);
        
        String linea;
        
        while ((linea = lector.readLine()) != null) {
            
            //System.out.println(linea);
            this.permisos.add(linea);
        
        }       
        
        
    }
    
    public void revisarPublicidad() throws FileNotFoundException, IOException{
        
        FileReader archivo = new FileReader("Publicidad.txt");
        
        BufferedReader lector = new BufferedReader(archivo);
        
        String linea;
        
        while ((linea = lector.readLine()) != null) {
            
            //System.out.println(linea);
            this.publicidad.add(linea);
            
           
           
        
        }  
        
        DirectorioApp appInsegura = new DirectorioApp();
           
        files=appInsegura.revisarDirectorio();
    }
}
