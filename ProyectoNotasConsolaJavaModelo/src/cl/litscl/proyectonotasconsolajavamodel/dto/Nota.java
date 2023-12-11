package cl.litscl.proyectonotasconsolajavamodel.dto;

public class Nota {
	private int id;
	private String titulo;
	private String descripcion;
	private String fecha;
	private String usuarioFK;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getUsuarioFK() {
		return usuarioFK;
	}
	
	public void setUsuarioFK(String usuarioFK) {
		this.usuarioFK = usuarioFK;
	}
}
