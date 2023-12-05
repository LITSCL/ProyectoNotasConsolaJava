package cl.litscl.proyectonotasconsolajava.controller;

import cl.litscl.proyectonotasconsolajava.util.ConsolaUtil;
import cl.litscl.proyectonotasconsolajava.util.EncriptacionUtil;
import cl.litscl.proyectonotasconsolajavamodel.dao.UsuarioDAO;
import cl.litscl.proyectonotasconsolajavamodel.dto.Usuario;

public class UsuarioControlador {
	private UsuarioDAO daoUsuario = new UsuarioDAO();
	private ConsolaUtil cu = new ConsolaUtil();
	private EncriptacionUtil ec = new EncriptacionUtil();
	
	public void registro() {
		System.out.println("Seleccionaste Registro");
		
		System.out.println("Introduce tu correo: ");
		String correo = cu.validarString();
		
		System.out.println("¿Cual es tu nombre?: ");
		String nombre = cu.validarString();
		
		System.out.println("¿Cual es tu apellido?: ");
		String apellido = cu.validarString();
		
		System.out.println("Introduce tu contraseña: ");
		String clave = cu.validarString();
		
		String claveEncriptada = ec.encriptarClave(clave);
		
		Usuario u = new Usuario();
		u.setCorreo(correo);
		u.setNombre(nombre);
		u.setApellido(apellido);
		u.setClave(claveEncriptada);
		
		if (daoUsuario.save(u) == true) {
			System.out.println("Usuario creado correctamente");
		}
		else {
			System.out.println("Error al crear el usuario");
		}
	}
	
	public Usuario identificacion() {
		System.out.println("Seleccionaste Login");
		
		System.out.println("Introduce tu correo: ");
		String correo = cu.validarString();
		
		System.out.println("Introduce tu contrase�a: ");
		String clave = cu.validarString();
		
		if (daoUsuario.find(correo) != null) {
			Usuario u = daoUsuario.find(correo);
			if (ec.verificarClave(clave, u.getClave()) == true) {
				System.out.println("Bienvenido " + u.getCorreo() + ", eres miembro desde " + u.getFecha());
				return u;
			}
			else {
				System.out.println("Clave incorrecta");
				return null;
			}
		}
		else {
			System.out.println("El correo ingresado no existe en el sistema");
			return null;
		}
	}
}
