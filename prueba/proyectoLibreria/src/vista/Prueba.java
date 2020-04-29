package vista;

import modelo.AutorDao;
import modelo.ConexionDao;
import modelo.LibroDao;

public class Prueba {

	public static void main(String[] args) {
		ConexionDao conDao = new ConexionDao();
		AutorDao auDao = new AutorDao(conDao.getConexion());
		LibroDao liDao = new LibroDao(conDao.getConexion());
		/*
		 * Autor aut = new Autor(45657, "mario", "la cuenta de la vieja",
		 * "914587554"); int filasAfectadas = AutorDao.insertar(aut); if
		 * (filasAfectadas == 1) { System.out.println("autor introducido"); }
		 * else { System.out.println("Error al insertar autor."); }
		 * 
		 * // Libro li = new Libro(14254, "4587126N", "el dragon de dragonlania"
		 * , // "el dia del libro", 05 - 02 - 2001); Libro li = new Libro();
		 * li.pedirDatos(); int filasAfectadas1 = LibroDao.insertar(li); if
		 * (filasAfectadas1 == 1) { System.out.println("autor introducido"); }
		 * else { System.out.println("Error al insertar autor."); }
		 */
		auDao.consultarAutor();
		liDao.consultarlibro();
	}

}
