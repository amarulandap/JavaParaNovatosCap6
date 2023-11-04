/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaparanovatoscap6;

/**
 *
 * @author Andres_Marulanda
 */
public class Persona implements java.io.Serializable {
    
    // Declaramos los atributos de la clase.
    private int identificacion;
    private String nombre;
    private int edad;
    
    // Constructor.
    Persona(int identificacion, String nombre, int edad){
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.edad = edad;
    }
    
    // Setters and Getters.
    public void setIdentificacion(int identificacion){
        this.identificacion = identificacion;
    }
    
    public int getIdentificacion(){
        return identificacion;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public int getEdad(){
        return edad;
    }
    
    // Métodos.
    public void imprimir(){
        System.out.println("Identificación: " + identificacion + "  Nombre: " + nombre + "  Edad: " + edad);
    } 
}
