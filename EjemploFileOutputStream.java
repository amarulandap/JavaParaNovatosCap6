/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.javaparanovatoscap6;

/**
 * @author Andres_Marulanda
 */

import java.io.*;                                   // Importamos el paquete Java.io que es donde están las clases para 
                                                    // manipulación de ficheros.

public class EjemploFileOutputStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Declaramos un objeto de la clase FileOutputStream.
        FileOutputStream fops = null;
        
        // Declaramos un objeto de la clase File.
        File archivo;
        
        // Creamos un objeto de la clase String que contendrá lo que enviaremos al fichero.
        String contenido = "Este es el primer texto que enviamos al archivo test1;"
                + "Los procesadores Intel® Core™ de 14ᵃ Generación presentan una arquitectura;"
                + " híbrida de desempeño1 con hasta ocho Performance-cores (P-cores) y hasta;"
                + " 16 Efficient-cores (E-cores), combinados con direccionamiento inteligente;"
                + " de las cargas de trabajo mediante Intel® Thread Director2. ";
        
        try{
            archivo = new File ("test1.txt");            // Instanciamos el objeto de tipo File a partir de uno de los ficheros.
            fops = new FileOutputStream(archivo);           // Instanciamos el objeto de tipo FOS a partir del objeto de tipo File.
            
            // Si el fichero no existe, lo creamos.
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            
            // Recuperar la dirección del fichero.
            String direccionFichero = archivo.getAbsolutePath();
            System.out.println(direccionFichero);
            
            
            // Convertimos el String en Bytes para poder escribirlo (FOS solo admite Bytes).
            byte[] contenidoEnBytes = contenido.getBytes();
            
            // Enviamos la serialización al fichero test1.
            fops.write(contenidoEnBytes);
            
            // Validamos que no hay mas datos para enviar.
            fops.flush();
            
            // Cerramos el flujo hacia el fichero.
            fops.close();
            
            System.out.println("Escritura realizada con éxito.");
            
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(fops != null){
                    fops.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
}
