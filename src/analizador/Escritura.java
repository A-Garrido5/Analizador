/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Adrián
 */
public class Escritura {
    
    public Escritura(HashMap permisosBuscados, HashMap publicidadBuscada, String paquete, String version){
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("Output.txt");
            pw = new PrintWriter(fichero);
            
            pw.println("% Nombre del paquete:  "+paquete);
            pw.println();
            
            pw.println("% Version:  "+version);
            pw.println();
            pw.println();
            pw.println();
            
            pw.print("@RELATION  Permissions");
            pw.println();
            pw.println();
             
                       
            Iterator it = permisosBuscados.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry e = (Map.Entry)it.next();
                
                pw.println("@ATTRIBUTE "+e.getKey()+"  {true,false}");
                //pw.println(e.getKey() + "             " + e.getValue());
            }
            
            pw.println();
            
            pw.println("@data");
            
            pw.println();
            
            Iterator ite = permisosBuscados.entrySet().iterator();

            while (ite.hasNext()) {
                Map.Entry r = (Map.Entry)ite.next();
                
                pw.println(r.getValue());
                //pw.println(e.getKey() + "             " + e.getValue());
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
    }
    
}
