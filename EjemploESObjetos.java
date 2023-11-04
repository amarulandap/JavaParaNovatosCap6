/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.javaparanovatoscap6;

/**
 * @author Andres_Marulanda
 */

import java.io.*;
import java.util.Scanner;

public class EjemploESObjetos {

    /**
     * @param args the command line arguments
     */
    
     // Declarar un conjunto de variables de clase.
    static File archivo;
    static FileInputStream fips;
    static FileOutputStream fops;
    static ObjectInputStream objetoEntrada;     // Objeto a través del cual recibiremos la info del fichero.
    static ObjectOutputStream objetoSalida;     // Objeto a través del cual enviaremos info hacia el fichero.
    
    public static void main(String[] args) {
        
        // Instanciar arreglos tipo String e int.
        int[] identificacion = {71388303, 22039862, 1017528963, 1254789652};
        String[] nombre = {"Andres Felipe", "Ana Maria", "Cristina", "Juan Jose"};
        int[] edad = {42, 28, 45, 34};
        
        // Escribir en el fichero.
        try{
            // Instanciar el objeto fops a partir de un fichero existente.
            fops = new FileOutputStream("alumnos.txt");
            
            // Instanciar el objeto Object a partir del objeto fops.
            objetoSalida = new ObjectOutputStream(fops);
            
            // Recorrer los tres arreglos de manera simultanea para enviar la info al fichero.
            for(int i=0; i < identificacion.length; i++){
                Persona alumno = new Persona(identificacion[i], nombre[i], edad[i]);
                objetoSalida.writeObject(alumno);
            }
            if(objetoSalida != null){
                // Cerramos el flujo de información en ambos objetos.
                objetoSalida.close();
                fops.close();
            }    
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        // Leer el fichero.
        try{
            archivo = new File("alumnos.txt");
            if(archivo.exists()){
                // Instanciamos el objeto FileInputStream.
                fips = new FileInputStream(archivo);
                
                // Instanciamos el objeto de tipo OIS.
                objetoEntrada = new ObjectInputStream(fips);
                
                // Instanciamos un objeto de tipo persona.
                Persona alumno = null;
                
                while(fips.available() > 0){
                    alumno = (Persona) objetoEntrada.readObject();   // casteo para convertir alumno a Persona.
                    alumno.imprimir();
                }
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException cnf){
            cnf.printStackTrace();
        }
    }   
}
