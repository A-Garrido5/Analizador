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
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Adrián
 */
public class Archivos {
    
    HashMap permisosBuscados = new HashMap();
    
    HashMap publicidadBuscada = new HashMap();
    
    ArrayList permisosObtenidos = new ArrayList();
    
    ArrayList <File> files = new ArrayList();
    
    public Archivos() throws IOException{
        
        this.permisosBuscados = revisarPermisos();
        this.publicidadBuscada =revisarPublicidad();
        
        DirectorioApp appInsegura = new DirectorioApp();
           
        files=appInsegura.revisarDirectorio();
        
        revisionArchivo revision = new revisionArchivo();
        
        permisosObtenidos=revision.revisar(files);
        
        
        for(int i=0;i<permisosObtenidos.size();i++){
            
            if(permisosBuscados.containsKey(permisosObtenidos.get(i))){
                permisosBuscados.replace(permisosObtenidos.get(i),true);
            }
        }
        
        

//        Iterator it = this.permisosBuscados.entrySet().iterator();
//
//        while (it.hasNext()) {
//            Map.Entry e = (Map.Entry)it.next();
//            System.out.println(e.getKey() + " " + e.getValue());
//        }
    }
    
    public HashMap revisarPermisos() throws FileNotFoundException, IOException{
        
        FileReader archivo = new FileReader("Permisos.txt");
        
        BufferedReader lector = new BufferedReader(archivo);
        
        String linea;
        
        while ((linea = lector.readLine()) != null) {
            
            //System.out.println(linea);
            this.permisosBuscados.put(linea, false);
            //System.out.println(permisosBuscados.size());
        
        }       
        
        
        
        return permisosBuscados;
    }
    
    public HashMap revisarPublicidad() throws FileNotFoundException, IOException{
        
        FileReader archivo = new FileReader("Publicidad.txt");
        
        BufferedReader lector = new BufferedReader(archivo);
        
        String linea;
        
        while ((linea = lector.readLine()) != null) {
            
            //System.out.println(linea);
            this.publicidadBuscada.put(linea,0);
            
           
           
        
        }  
        
       
        
        
        
        
        return publicidadBuscada;
        
        
    }

    
}
