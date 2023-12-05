package cl.litscl.proyectonotasconsolajava;

import cl.litscl.proyectonotasconsolajava.controller.NotaControlador;
import cl.litscl.proyectonotasconsolajava.controller.UsuarioControlador;
import cl.litscl.proyectonotasconsolajava.util.ConsolaUtil;
import cl.litscl.proyectonotasconsolajavamodel.dto.Usuario;

public class Start {
	private static UsuarioControlador usuarioControlador = new UsuarioControlador();
	private static NotaControlador notaControlador = new NotaControlador();
	private static ConsolaUtil cu = new ConsolaUtil();
	
	//Menu Principal.
	public static boolean menu() { 
		boolean continuar = true;
		
		System.out.println("Acciones disponibles:");
		System.out.println("1. Registro");
		System.out.println("2. Identificarse");
		System.out.println("0. Salir");
		
		System.out.println("¿Que quieres hacer?");
		
		switch (cu.validarString()) {
		case "1":
			usuarioControlador.registro();
			break;
		case "2":
			Usuario u = usuarioControlador.identificacion();
			if (u != null) {
				while(menuSesion(u));
			}
			break;
		case "0":
			continuar = false;
			break;
		default:
			System.out.println("Opcion incorrecta");
			break;
		}
		return continuar;	
	}
	
	//Menu de sesión.
	public static boolean menuSesion(Usuario u) {
		boolean continuar = true;
		
		System.out.println("Acciones disponibles:");
		System.out.println("1. Crear nota");
		System.out.println("2. Mostrar notas");
		System.out.println("3. Eliminar nota");
		System.out.println("0. Salir");
		
		System.out.println("¿Que quieres hacer?");
		
		switch (cu.validarString()) {
		case "1":
			notaControlador.crear(u);
			break;
		case "2":
			notaControlador.mostrar();
			break;
		case "3":
			notaControlador.eliminar();
			break;
		case "0":
			continuar = false;
			break;
		default:
			System.out.println("Opcion incorrecta");
			break;
		}
		return continuar;	
	}

	public static void main(String[] args) {
		while(menu());
	}

}
