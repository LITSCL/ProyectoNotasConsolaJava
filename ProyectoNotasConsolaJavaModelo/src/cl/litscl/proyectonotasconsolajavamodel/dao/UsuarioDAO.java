package cl.litscl.proyectonotasconsolajavamodel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cl.litscl.proyectonotasconsolajavamodel.dto.Usuario;
import cl.litscl.proyectonotasconsolajavamodel.util.BDUtil;

public class UsuarioDAO {
	private BDUtil bdUtil = new BDUtil();
	 
	public boolean save(Usuario u) {
		boolean resultado;
		try {
			bdUtil.conectar();
			String sql = "INSERT INTO usuario(correo, nombre, apellido, clave, fecha) VALUES(?, ?, ?, ?, NOW())";
			Connection conexion = bdUtil.getConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, u.getCorreo());
			ps.setString(2, u.getNombre());
			ps.setString(3, u.getApellido());
			ps.setString(4, u.getClave());
			ps.executeUpdate();
			resultado = true;
		} catch (Exception ex) {
			resultado = false;
		} finally { 
			bdUtil.desconectar();
		}
		return resultado;
	}
	
	public Usuario find(String correo) {
		boolean resultado;
		Usuario u = new Usuario();
		try {
			bdUtil.conectar();
			String sql = "SELECT * FROM usuario WHERE CORREO = ?";
			Connection conexion = bdUtil.getConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, correo);
			ResultSet rs = ps.executeQuery();
			resultado = true;
			while (rs.next()) {
				u.setCorreo(rs.getString(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setClave(rs.getString(4));
				u.setFecha(rs.getString(5));
			}
			rs.close();
		} catch (Exception ex) {
			resultado = false;
			return null;
		} finally { 
			bdUtil.desconectar();
		}
		return u;
	}
}
