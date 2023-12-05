package cl.litscl.proyectonotasconsolajavamodel.fk;

import cl.litscl.proyectonotasconsolajavamodel.dao.UsuarioDAO;
import cl.litscl.proyectonotasconsolajavamodel.dto.Nota;
import cl.litscl.proyectonotasconsolajavamodel.dto.Usuario;

public class NotaFK {
	private UsuarioDAO daoUsuario = new UsuarioDAO();
	private Usuario u = new Usuario();

	public String getUsuarioCorreo(Nota n) {
		u = daoUsuario.find(n.getUsuarioFK());
		return u.getCorreo();
	}
	
	public String getUsuarioNombre(Nota n) {
		u = daoUsuario.find(n.getUsuarioFK());
		return u.getNombre();
	}
	
	public String getUsuarioApellido(Nota n) {
		u = daoUsuario.find(n.getUsuarioFK());
		return u.getApellido();
	}
	
	public String getUsuarioClave(Nota n) {
		u = daoUsuario.find(n.getUsuarioFK());
		return u.getClave();
	}
	
	public String getUsuarioFecha(Nota n) {
		u = daoUsuario.find(n.getUsuarioFK());
		return u.getFecha();
	}
}
