/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.javaparanovatoscap6;

/**
 * @author Andres_Marulanda
 */

import java.io.File;
        
public class PruebaFile {

    public static void main(String[] args) {
        
        // Instanciamos un objeto de tipo File.
        File f = null;
        
        
        // Creamos un arreglo tipo String.
        String [] ficheros = {"test1.txt", "test2.txt"};
        
        // Instanciamos un objeto de tipo FileReader.
        // FileReader fr = new FileReader("C:\Users\Andres_Marulanda\Documents\NetBeansProjects\JavaParaNovatosCap6\test1.txt");
        
        try{
            // Recorrer el array ficheros.
            for(String nombreFich:ficheros){
                
                f = new File(nombreFich);                   // Abrir el flujo hacia el fichero.
                
                // Validamos si el fichero ya existe.
                if(!f.exists()){
                    f.createNewFile();
                }
                
                // Validamos si el fichero tiene permisos de escritura.
                boolean escritura = f.canWrite();
                
                // Recuperamos la ruta absoluta del fichero.
                String rutaFichero = f.getAbsolutePath();
                
                // Mostrar en pantalla los datos recuperados.
                System.out.println("Ruta: " + rutaFichero);
                System.out.println("Permiso escritura: " + escritura);
            }
                
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
