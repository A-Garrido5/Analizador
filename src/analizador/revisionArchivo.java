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
    
    public ArrayList<String> revisar(ArrayList<File> files) throws FileNotFoundException, IOException{
        
        ArrayList <String> nombresPermisos = new ArrayList();
        
        String paquete;
        
        int contadorLineas=0,contadorPermisos=0;
        
        for(int i=0;i<files.size();i++){
            //System.out.println(files.get(i).getName());
           
            if(files.get(i).getName().equalsIgnoreCase("AndroidManifest.xml")){
            
                String cadena;
                FileReader n = new FileReader(files.get(i).getAbsoluteFile());
                BufferedReader b = new BufferedReader(n);

                while((cadena = b.readLine())!=null) {

                    int encontrarNombrePaquete=cadena.indexOf("package=\"");
                 
                    if(encontrarNombrePaquete!=-1){
                        
                       paquete=cadena.substring(encontrarNombrePaquete+9);
                       
                       paquete=paquete.substring(0, paquete.indexOf("\""));
                       //System.out.println("Nombre del paquete =  "+paquete+"\n");
                       
                    }
                    
                    int encontrarPermisos=cadena.indexOf("uses-permission");
                    
                    if(encontrarPermisos>0){
                        
                                       
                        int encontrarNombrePermiso=cadena.indexOf("android:name=\"android.permission.");
                        
                        if(encontrarNombrePermiso>0){
                            contadorLineas++;
                            String name=cadena.substring(encontrarNombrePermiso+33,cadena.length()-3);
                            
                            
                            
                            if(name.indexOf("android:permissionGroup")>0){
                                
                                
                                
                            }
                            
                            else{
                                nombresPermisos.add(name);
                                // System.out.println((contadorPermisos+1)+".- Nombre de permiso =  "+name+"\n");
                            }
                            
                            contadorPermisos++;
                        }
                        
                        
                    }
                    

                }
            
            }
                 
                    
        }
        
        return nombresPermisos;
        
    }
    

    
}
