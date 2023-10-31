/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.javaparanovatoscap6;

/**
 * @author Andres_Marulanda
 */

import java.io.*;

public class EjemploEntradaSalidaTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int finalFichero = 0;           // Variable que indica que no hay mas datos en el fichero.
        int contadorCaracteres = 0;
        
        char[] caracteresFichero = new char[2000];
        
        try{
            // Instanciamos un objeto del tipo FileReader para leer el archivo.
            FileReader leerFichero = new FileReader("test2.txt");
            
            // Instanciamos un objeto de tipo FileWriter para escribir en el archivo.
            FileWriter escribirFichero = new FileWriter("test1.txt");
            
            while(finalFichero != -1){                  // El valor -1 indicará el final del fichero de entrada.
                finalFichero = leerFichero.read();
                
                while((finalFichero != -1) && (contadorCaracteres < 2000)){
                    
                    // Guardamos el caracter en el Array.
                    caracteresFichero[contadorCaracteres] = (char)finalFichero; 
                    contadorCaracteres++;
                    finalFichero = leerFichero.read();
                }
                // Escribimos en el Array.
                escribirFichero.write(caracteresFichero);
            }
            if(leerFichero != null){
                leerFichero.close();
            }
            if(escribirFichero != null){
                escribirFichero.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
