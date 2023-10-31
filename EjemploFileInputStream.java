/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.javaparanovatoscap6;

/**
 * @author Andres_Marulanda
 */

import java.io.*;

public class EjemploFileInputStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Instanciamos un objeto de la clase File.
        File archivo = new File("test2.txt");
        
        // Declaramos el objeto de tipo FileInputStream.
        FileInputStream fips = null;
        
        // Variable para almacenar el tamaño del fichero.
        int tamañoFichero;
        
        try{
            // Instanciamos el objeto de tipo FIS.
            fips = new FileInputStream(archivo);
            
            // Validamos el tamaño del fichero.
            System.out.println("Tamaño del fichero: " + fips.available());
            
            while((tamañoFichero = fips.read()) != -1){
                // Convertir el byte leido en un caracter.
                System.out.print((char) tamañoFichero);
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(fips != null){
                    fips.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
}
