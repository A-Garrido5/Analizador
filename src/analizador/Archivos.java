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
import java.util.HashMap;

/**
 *
 * @author Adrián
 */
public class Archivos {
    
    HashMap<String,Integer> permisosBuscados = new HashMap<String, Integer>();
    
    ArrayList publicidad = new ArrayList();
    
    ArrayList permisosObtenidos = new ArrayList();
    
    ArrayList <File> files = new ArrayList();
    
    public void revisarPermisos() throws FileNotFoundException, IOException{
        
        FileReader archivo = new FileReader("Permisos.txt");
        
        BufferedReader lector = new BufferedReader(archivo);
        
        String linea;
        
        while ((linea = lector.readLine()) != null) {
            
            //System.out.println(linea);
            this.permisosBuscados.add(linea);
        
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
        
        revisionArchivo revision = new revisionArchivo();
        
        permisosObtenidos=revision.revisar(files);
        
        
        for(int i=0;i<permisosObtenidos.size();i++){
            
            System.out.println(permisosObtenidos.get(i));
        }
        
    }
}
