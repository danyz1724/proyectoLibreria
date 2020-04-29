package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import controlador.Libro;
import utilidades.Utilidades;

public class LibroDao {
	public static Connection conexion;

	public LibroDao(Connection conexion) {
		this.conexion = conexion;
	}

	public static int insertar(Libro li) {
		try {

			PreparedStatement stmt = conexion.prepareStatement(
					"insert into libros(codigo_libro,isbn, titulo,editorial,fecha) value (?,?,?,?,?)");

			stmt.setInt(1, li.getCodigo_libro());
			stmt.setString(2, li.getIsbn());
			stmt.setString(3, li.getTitulo());
			stmt.setString(4, li.getEditorial());
			/**
			 * Tenemos una fechaAlta en el objeto empleado que es de tipo
			 * java.util.Date Por otro lado tenemos una fecha_alta en BBDD que
			 * es de tipo sql.TimeStamp para guardar en bbdd tenemos que
			 * transformar de una a otra
			 */
			stmt.setTimestamp(5, Utilidades.parsearFechaSQL(li.getFecha()));

			// ExecuteUpdate cuando quiero realizar una modificacion en la bbdd
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static ArrayList<Libro> consultarlibro() {
		ArrayList<Libro> libros = new ArrayList<Libro>();

		try {
			Statement st = conexion.createStatement();
			// ResultSet: tipo de dato donde se recoge lo que venga de la tabla
			ResultSet rs = st.executeQuery("SELECT * FROM libros");

			while (rs.next()) {
				int codigo = rs.getInt("codigo_libro");
				String isbn = rs.getString("isbn");
				String titulo = rs.getString("titulo");
				String editorial = rs.getString("editorial");
				Date fecha = rs.getDate("fecha");

				Libro li = new Libro(codigo, isbn, titulo, editorial, fecha);

				libros.add(li);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return libros;
	}

	static public ArrayList<Libro> consultaLibrosPorNumeroAutores(int num) {
		// Creo el arrayList de departamentos donde los ire guardando
		ArrayList<Libro> aLibro = new ArrayList<Libro>();
		try {
			PreparedStatement st = conexion.prepareStatement("SELECT * FROM libros where codigo_libro= ?");
			st.setInt(1, num);
			// ResultSet: tipo de dato donde se recoge lo que venga de la tabla
			ResultSet rs = st.executeQuery();
			// Automaticamente se coloca en la posicion 0
			// rs.next() devuelve true si hay algo en la siguiente posicion
			while (rs.next()) {
				// Entre comillas va EL NOMBRE DE LA COLUMNA EN LA BBDD
				int codigo_libro = rs.getInt("codigo_libro");
				String isbn = rs.getString("isbn");
				String titulo = rs.getString("titulo");
				String editorial = rs.getString("editorial");
				Date fecha = rs.getDate("fecha");
				Libro li = new Libro(codigo_libro, isbn, titulo, editorial, fecha);
				// Guardo en el array de departamentos el que acabo de crear
				aLibro.add(li);
			}
			return aLibro;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
