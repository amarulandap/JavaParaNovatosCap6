/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.javaparanovatoscap6;

/**
 * @author Andres_Marulanda
 */

import java.io.*;

public class LecturaConBuffer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crear una variable tipo String con el nombre del Fichero.
        // String archivo = "test1";
        
        // Crear una variable de tipo String para almacenar cada línea de texto del fichero.
        String lineaArchivo = null;
        
        try{
            // Instanciamos in objeto FilReader para leer el archivo.
            FileReader leerArchivo = new FileReader("test1.txt");
            
            // Instanciamos el Buffer para la apertura del flujo de información desde el archivo.
            BufferedReader almacenamientoLineas = new BufferedReader(leerArchivo);
            
            // Leer cada una de las líneas del archivo.
            while((lineaArchivo = almacenamientoLineas.readLine()) != null){
                
             // Mostrar el contenido del archivo en pantalla.
             System.out.println(lineaArchivo);
             
            }
            almacenamientoLineas.close();                           // Cierra el flujo de información desde el fichero.
        }
        catch(FileNotFoundException ex){                            // Controlamos la excepción que se puede generar al tratar de leer el archivo.
            System.out.println("No se puede abrir el archivo");
        }
        catch(IOException ex){
            System.out.println("Error en la lectura del archivo");
        }
        
    }
    
}
