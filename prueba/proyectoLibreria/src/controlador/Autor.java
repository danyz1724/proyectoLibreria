package controlador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Autor {
	private int codigo_autor;
	private String nombre;
	private String direccion;
	private String telefono;

	public int getCodigo_autor() {
		return codigo_autor;
	}

	public void setCodigo_autor(int codigo_autor) {
		this.codigo_autor = codigo_autor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	private ArrayList<Libro> libros = new ArrayList<Libro>();

	public Autor(int codigo_autor, String nombre, String direccion, String telefono) {
		super();
		this.codigo_autor = codigo_autor;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Autor() {
	}

	public void pedirDatos() {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		try {
			System.out.println("introduce el codigo del autor");
			codigo_autor = sc.nextInt();
			System.out.println("introduce el nombre del autor");
			nombre = sc1.nextLine();
			System.out.println("introduce la direccion del autor");
			direccion = sc1.nextLine();
			System.out.println("introduce el telefono del autor");
			direccion = sc1.nextLine();
		} catch (InputMismatchException ex) {
			System.out.println("introduzca el valor correctamente");
			sc = new Scanner(System.in);
			sc1 = new Scanner(System.in);
			pedirDatos();
		}
	}
}
