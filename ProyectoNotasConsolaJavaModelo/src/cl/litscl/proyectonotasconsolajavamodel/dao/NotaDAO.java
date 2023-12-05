package cl.litscl.proyectonotasconsolajavamodel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.litscl.proyectonotasconsolajavamodel.dto.Nota;
import cl.litscl.proyectonotasconsolajavamodel.util.BDUtil;

public class NotaDAO {
	private BDUtil bdUtil = new BDUtil();
	 
	public boolean save(Nota n) {
		boolean resultado;
		try {
			bdUtil.conectar();
			String sql = "INSERT INTO nota(titulo, descripcion, fecha, usuario_correo) VALUES(?, ?, NOW(), ?)";
			Connection conexion = bdUtil.getConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, n.getTitulo());
			ps.setString(2, n.getDescripcion());
			ps.setString(3, n.getUsuarioFK());
			ps.executeUpdate();
			resultado = true;
		} catch (Exception ex) {
			resultado = false;
		} finally { 
			bdUtil.desconectar();
		}
		return resultado;
	}
	
	public List<Nota> getAll() {
		boolean resultado;
		List<Nota> notas = new ArrayList<Nota>();
		try {
			bdUtil.conectar();
			String sql = "SELECT * FROM nota";
			Connection conexion = bdUtil.getConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			resultado = true;
			while (rs.next()) {
				Nota n = new Nota();
				n.setId(rs.getInt(1));
				n.setTitulo(rs.getString(2));
				n.setDescripcion(rs.getString(3));
				n.setFecha(rs.getString(4));
				n.setUsuarioFK(rs.getString(5));
		
				notas.add(n);
			}
			rs.close();
		} catch (Exception ex) {
			notas = null;
			resultado = false;
		} finally { 
			bdUtil.desconectar();
		}
		return notas;
	}
	
	public boolean delete(int id) {
		boolean resultado;
		try {
			bdUtil.conectar();
			String sql = "DELETE FROM nota WHERE id = ?";
			Connection conexion = bdUtil.getConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			resultado = true;	
		} catch (Exception ex) {
			resultado = false;
		} finally { 
			bdUtil.desconectar();
		}
		return resultado;
	}
}
