package controlador;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import utilidades.Utilidades;

public class Libro {
	private int codigo_libro;
	private String isbn;
	private String titulo;
	private String editorial;
	private Date fecha;
	private ArrayList<Autor> autores = new ArrayList<Autor>();

	public int getCodigo_libro() {
		return codigo_libro;
	}

	public void setCodigo_libro(int codigo_libro) {
		this.codigo_libro = codigo_libro;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}

	public Libro(int codigo_libro, String isbn, String titulo, String editorial, Date fecha) {
		super();
		this.codigo_libro = codigo_libro;
		this.isbn = isbn;
		this.titulo = titulo;
		this.editorial = editorial;
		this.fecha = fecha;
	}

	public Libro() {
	}

	public void pedirDatos() {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		try {
			String fecha = null;
			System.out.println("introduce el codigo del libro");
			codigo_libro = sc.nextInt();
			System.out.println("introduce el isbn del libro");
			isbn = sc1.nextLine();
			System.out.println("introduce el titulo del libro");
			titulo = sc1.nextLine();
			System.out.println("introduce la editorial del libro");
			editorial = sc1.nextLine();
			System.out.println("introduce la fecha del libro");
			this.fecha = Utilidades.parsearFechaString(fecha);
		} catch (ParseException ex) {
			System.out.println("introduzca el valor correctamente");
			sc = new Scanner(System.in);
		}
	}
}
