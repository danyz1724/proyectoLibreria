package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controlador.Autor;
import controlador.Libro;

public class AutorDao {

	public static Connection conexion;

	public AutorDao(Connection conexion) {
		this.conexion = conexion;
	}

	public static int insertar(Autor au) {
		try {

			PreparedStatement stmt = conexion
					.prepareStatement("insert into autores(codigo_autor,nombre, direccion,telefono) value (?,?,?,?)");

			// Ahora sustituimos las interrogaciones por el contenido del objeto
			// depart
			stmt.setInt(1, au.getCodigo_autor());
			stmt.setString(2, au.getNombre());
			stmt.setString(3, au.getDireccion());
			stmt.setString(4, au.getTelefono());

			// ExecuteUpdate cuando quiero realizar una modificacion en la bbdd
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static ArrayList<Autor> consultarAutor() {
		ArrayList<Autor> autores = new ArrayList<Autor>();

		try {
			Statement st = conexion.createStatement();
			// ResultSet: tipo de dato donde se recoge lo que venga de la tabla
			ResultSet rs = st.executeQuery("SELECT * FROM autores");

			while (rs.next()) {
				int codigo = rs.getInt("codigo_autor");
				String nombre = rs.getString("nombre");
				String direccion = rs.getString("direccion");
				String telefono = rs.getString("telefono");

				Autor au = new Autor(codigo, nombre, direccion, telefono);

				autores.add(au);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return autores;
	}

	static public Autor consultaAutorPorNumero(int numero) {
		// Creo el arrayList de departamentos donde los ire guardando
		ArrayList<Libro> aLibro = null;
		Autor au = null;
		try {
			PreparedStatement st = conexion.prepareStatement("SELECT * FROM autores where numero= ?");

			st.setInt(1, numero);
			// ResultSet: tipo de dato donde se recoge lo que venga de la tabla
			ResultSet rs = st.executeQuery();
			// Automaticamente se coloca en la posicion 0
			// rs.first() se posiciona en la primera posicion del resultset
			if (rs.first()) {
				// Entre comillas va EL NOMBRE DE LA COLUMNA EN LA BBDD
				int codigo_autor = rs.getInt("codigo_autor");
				String nombre = rs.getString("nombre");
				String direccion = rs.getString("direccion");
				String telefono = rs.getString("telefono");
				au = new Autor(codigo_autor, nombre, direccion, telefono);
				aLibro = LibroDao.consultaLibrosPorNumeroAutores(numero);
				au.setLibros(aLibro);
			}
			return au;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
