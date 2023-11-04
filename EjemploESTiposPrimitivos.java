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

public class EjemploESTiposPrimitivos {

    // Declarar un conjunto de variables globales de clase.
    private static File archivo;
    private static FileInputStream fips;
    private static FileOutputStream fops;
    private static DataInputStream entradaDatos;
    private static DataOutputStream salidaDatos;
    
    static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        // Crear y escribir en un nuevo fichero.
        try{
            // Instanciamos un objeto de tipo FileOutputStream para abrir el fujo de información hacia el fichero.
            fops = new FileOutputStream("alumnos.txt");
            
            // Instanciamos el objeto para escribir en el archivo.
            salidaDatos = new DataOutputStream(fops);
            
            // Ingresar los datos de los alumnos.
            while (true) { 
                
                int opcion = 0;
                int idAlumno = 0;
                String nombreAlumno;
                int edadAlumno = 0;
                
                System.out.println("Seleccione una opción: ");
                System.out.println("\t 1. Ingresar un alumno. ");
                System.out.println("\t 2. Actualizar datos del alumno. ");
                System.out.println("\t 3. Eliminar un alumno. ");
                System.out.println("\t 4. Salir. ");
                System.out.print(": ");
                
                opcion = leer.nextInt();
                
                if (opcion == 1) {
                    System.out.print("Identificación del alumno: ");    // nextLine no fucniona correctamente dentro de los ciclos.
                    idAlumno = leer.nextInt();   
                    salidaDatos.writeInt(idAlumno);
                    
                    System.out.print("Nombre del alumno: ");
                    nombreAlumno = leer.next();
                    salidaDatos.writeUTF(nombreAlumno);             // Escribimos el nombre del alumno en el fichero.

                    System.out.print("Edad del alumno: ");
                    edadAlumno = leer.nextInt();
                    salidaDatos.writeInt(edadAlumno);                // Escribimos la edad del alumno en el fichero.

                } else if(opcion == 2){
                    System.out.println("Modificar alumno");
                }else if(opcion == 3){
                    System.out.println("Eliminar alumno.");
                }else if(opcion == 4){
                    break;
                }else{
                    System.out.println("Error, seleccione una opción valida");
                }
                    
            }
            if(salidaDatos != null){
                salidaDatos.close();                                // Cerramos el flujo de información hacia el fichero.
                fops.close();
            }   
        }catch(IOException e){
            e.printStackTrace();
        }
        
        // Leer el fichero.
        try{
            archivo = new File("alumnos.txt");
            
            // Leemos el archivo.
            if(archivo.exists()){
                
                // Instanciamos un objeto de tipo FileInputStream para abrir el fujo de información hacia el fichero.
                fips = new FileInputStream("alumnos.txt");
                
                // Leemos el fichero con un objeto DataInputStream.
                entradaDatos = new DataInputStream(fips);
                
                String nombreAlumno = null;
                int edadAlumno = 0;
                int idAlumno = 0;
                
                // Mostrar en pantalla el contenido del fichero.
                System.out.println("Alumnos: ");
                
                while(fips.available() > 0){
                    idAlumno = entradaDatos.readInt();
                    nombreAlumno = entradaDatos.readUTF();
                    edadAlumno = entradaDatos.readInt();
                    System.out.println("Id: " + idAlumno + " Nombre: " + nombreAlumno + " edad: " + edadAlumno);
                }
            }
            if(entradaDatos != null){
                entradaDatos.close();
                fips.close();
            }
        }catch(FileNotFoundException ex){
            System.out.println("Archivo Alumnos no encontrado.");
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }  
}
