package cl.litscl.proyectonotasconsolajava.controller;

import java.util.List;

import cl.litscl.proyectonotasconsolajava.util.ConsolaUtil;
import cl.litscl.proyectonotasconsolajavamodel.dao.NotaDAO;
import cl.litscl.proyectonotasconsolajavamodel.dto.Nota;
import cl.litscl.proyectonotasconsolajavamodel.dto.Usuario;

public class NotaControlador {
	private NotaDAO daoNota = new NotaDAO();
	private ConsolaUtil cu = new ConsolaUtil();
	
	public void crear(Usuario u) {
		System.out.println("Seleccionaste Crear");
		
		System.out.println("Introduce el título: ");
		String titulo = cu.validarString();
		
		System.out.println("Introduce la descripción: ");
		String descripcion = cu.validarString();
		
		String correoUsuario = u.getCorreo();
		
		Nota n = new Nota();
		n.setTitulo(titulo);
		n.setDescripcion(descripcion);
		n.setUsuarioFK(correoUsuario);
		
		if (daoNota.save(n) == true) {
			System.out.println("Nota creada correctamente");
		}
		else {
			System.out.println("Error al crear la nota");
		}
	}
	
	public void mostrar() {
		System.out.println("Seleccionaste Mostrar");
		
		List<Nota> notas = daoNota.getAll();
		for (Nota n : notas) {
			System.out.println("ID: " + n.getId() + "; Título: " + n.getTitulo() + "; Descripción: " + n.getDescripcion() + "; Fecha: " + n.getFecha() + "; Correo: " + n.getUsuarioFK());
		}
	}
	
	public void eliminar() {
		System.out.println("Seleccionaste Eliminar");
		
		System.out.println("Introduce el ID de la nota que deseas eliminar: ");
		int id = cu.validarInt();
		
		if (daoNota.delete(id) == true) {
			System.out.println("Nota eliminada correctamente");
		}
		else {
			System.out.println("Error al eliminar la nota");
		}
	}
}
