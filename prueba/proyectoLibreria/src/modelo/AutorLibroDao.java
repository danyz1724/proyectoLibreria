package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AutorLibroDao {
	public static Connection conexion;

	public AutorLibroDao(Connection conexion) {
		this.conexion = conexion;
	}

	public static int insertar(int codigoAutor, int codigoLibro) {
		try {
			PreparedStatement stmt = conexion
					.prepareStatement("insert into autor_libro (codigo_autor, codigo_libro) values(?,?)");

			stmt.setInt(1, codigoAutor);
			stmt.setInt(2, codigoLibro);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
