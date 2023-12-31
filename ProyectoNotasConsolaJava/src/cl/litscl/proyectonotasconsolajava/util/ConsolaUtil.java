package cl.litscl.proyectonotasconsolajava.util;

import java.util.Scanner;

public class ConsolaUtil {
	static Scanner sc = new Scanner(System.in); //Se crea el objeto de tipo Scanner.
	
	public String validarString() { //Método que verifica el ingreso correcto de datos de tipo String.
		
		String strings; //Se declara la variable a retornar.
		
		do {
			
			strings = sc.nextLine().trim(); //Se lee la variable.
			if (strings.isEmpty() == true) {
				System.out.println("No ingresó ningún caracter, ingrese el dato nuevamente");
			}
			
		} while (strings.isEmpty() == true); //Solo sale del bucle si se ingreso algún caracter en la variable.
		
		return strings; //Retorna lo que el usuario ingreso en la variable.
	}
	
	public int validarInt() { //Método que verifica el ingreso correcto de datos de tipo int.
		
		int ints = -1; //Se declara la variable a retornar.
		String lectura; //Se declara el String utilizado para la lectura de datos.
		
		do {
			
			try {
				lectura = sc.nextLine().trim(); //El usuario ingresa el valor.
				ints = Integer.parseInt(lectura); // El valor de la variable anterior se almacena en ésta variable.
			} catch (Exception ex) {
				lectura = ""; //Si el valor ingresado por el usuario contenia caracteres se lee ésta instrucción.
				System.out.println("El valor que ingresó no es de tipo entero, ingrese el dato nuevamente");
			}
			
		} while (lectura.isEmpty() == true); //Solo sale del bucle si se ingresó algún número en la variable Lectura.
		
		return ints;
	}
}
