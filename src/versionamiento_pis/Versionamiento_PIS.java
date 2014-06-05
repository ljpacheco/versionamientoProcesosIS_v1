/*
 * Proyecto: Archivos 
 * Descripcion: Crear, Escribir y Leer archivos .txt
 * Fecha de Creacion: 03-Junio_2014
 * Autor: Liliana Pacheco Jara
 *
 *  ----Historial de Modificacion----
   Version	Modificador	Fecha	  	Actividad              Comentario
     1.1	L.Pacheco	03/06/2014	Crear Proyecto         Inicio del proyecto
     1.2	L.Pacheco 	03/06/2014	Crear  Metodos         Se crearon los metodos Crear y Escribir archivos
     1.3	L.Pacheco 	04/06/2014	Crear  Metodos         Leer archivo, se lee el archivo previamente creado
     1.4	L.Pacheco 	04/06/2014	Documentar             Se realiza la documentación de todos los metodos construidos
 */

package versionamiento_pis;

//importacion de librerias
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Versionamiento_PIS {
    //creacion de variables e inicializacion con los datos de una persona
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
    
    static String ruta="C:\\Users\\katty-henrry\\Desktop\\DatosPersonales.txt"; //esta ruta es en la cual se va a crear el archivo
     public static void main(String[] args) throws IOException {
        //se crea un switch con la finalidad de que se pueda escoger la opcion que el usuario desee
         //escribir archivo o leer alguno si ya esta creado
         
         int opcion=0;
         Scanner lector = new Scanner(System.in);
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una opción \n 1. -- Crear archivo -- \n 2. -- Leer archivo --"));
        switch(opcion) {
        case 1: 
             EscribirArchivo(); //llamada metodo escribir
             break;
         case 2: 
             LeerArchivo(); //llamada al metodo leer 
             break;
         }
         
      } 
      // Metodos -  Escribir archivo con las variables antes declaradas
     public static void EscribirArchivo() throws IOException{
        File archivo = new File(ruta);
         if (!archivo.exists()) { //solo en caso de que el archivo no esxita crearlo con los siguientes datos
             BufferedWriter escribir = new BufferedWriter(new FileWriter(ruta)); //creacion del archivo
             escribir.write("************ DATOS PERSONALES ************" + "\n" ); // de esta linea hasta clouse son los datos que se van a escribir en el archivo
             escribir.write("Nombres: " + nombre + "\n");
             escribir.write("Apellidos: " + apellidos + "\n");
             escribir.write("Telefono: " + telefono + "\n");
             escribir.write("Cedula: "  + ci);
             escribir.write("Carrera/Titulacion: " + carrera + "\n");
             escribir.write("Ciclo: " + ciclo + "\n" );
             escribir.close();
             
             //mensaje de creacion del archivo
             System.out.println("El archivo se ha creado con exito.. :D");
         }else{
             //mensaje en caso de error de creacion de archivo
             System.out.println("El archivo ya se encuentra creado, cambie el nombre o la ruta");
          
         }
    }
     // Metodos -  leer archivos previamente creados
      public static void LeerArchivo(){
         BufferedReader leer = null;
 		try {
 			String Linea;
 			leer = new BufferedReader(new FileReader(ruta)); //para leer el archivo linea por linea
 			while ((Linea = leer.readLine()) != null) { //Cada que se invoca el método readLine() se busca una linea y el cursor pasa a la siguiente linea cuando no hay mas lineas regresa null
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