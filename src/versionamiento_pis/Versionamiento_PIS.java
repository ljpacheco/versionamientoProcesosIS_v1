/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package versionamiento_pis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author katty-henrry
 */
public class Versionamiento_PIS {

    static String nombre="Lily";
    static String apellidos="Pacheco Jara";
    static String ci="1105210627";
    static String estadoCivil="Soltera";
    static String telefono="072664281";
    static String direccion="IV Centenario";
    static String ocupacion="Estudiante";
    static String carrera="Ingenieria en sistemas y Computación";
    static String ciclo="Decimo";
    
    // Metodos -  Crear y escribir archivos con datos personales
    static String ruta="C:\\Users\\katty-henrry\\Desktop\\DatosPersonales.txt";
     public static void main(String[] args) throws IOException {
         int opcion=0;
         Scanner lector = new Scanner(System.in);
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una opción \n 1. -- Crear archivo -- \n 2. -- Leer archivo --"));
         switch(opcion) {
         case 1: 
             EscribirArchivo();
             break;
         case 2: 
             LeerArchivo();
             break;
         }
         
      } 
      // Metodos -  Escribir 
     public static void EscribirArchivo() throws IOException{
        File archivo = new File(ruta);
         if (!archivo.exists()) {
             BufferedWriter escribir = new BufferedWriter(new FileWriter(ruta));
             escribir.write("************ DATOS PERSONALES ************" + "\n" );
             escribir.write("Nombres: " + nombre + "\n");
             escribir.write("Apellidos: " + apellidos + "\n");
             escribir.write("Telefono: " + telefono + "\n");
             escribir.write("Cedula: "  + ci);
             escribir.write("Carrera/Titulacion: " + carrera + "\n");
             escribir.write("Ciclo: " + ciclo + "\n" );
             escribir.close();
             
             System.out.println("El archivo se ha creado con exito.. :D");
         }else{
             System.out.println("El archivo ya se encuentra creado, cambie el nombre o la ruta");
          
         }
    }
     // Metodos -  leer
      public static void LeerArchivo(){
         BufferedReader leer = null;
 		try {
 			String Linea;
 			leer = new BufferedReader(new FileReader(ruta));
 			while ((Linea = leer.readLine()) != null) { 
                             System.out.println(Linea); 
 			}
 		} catch (IOException e) {
 			e.printStackTrace();
 		} finally {
 			try {
 				if (leer != null)leer.close();
 			} catch (IOException ex) {
 				ex.printStackTrace();
 			}
 		}
     }
 } 