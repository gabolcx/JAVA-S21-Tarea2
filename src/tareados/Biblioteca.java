
package tareados;

import java.util.ArrayList;

public class Biblioteca {
    
   // Atributos de la biblioteca
  private ArrayList<Libro> libros; // Lista de libros de la biblioteca
  private ArrayList<Usuario> usuarios; // Lista de usuarios registrados en el sistema

  // Constructor de la clase Biblioteca
  public Biblioteca() {
    this.libros = new ArrayList<>(); // Inicializar la lista de libros vacía
    this.usuarios = new ArrayList<>(); // Inicializar la lista de usuarios vacía
  }

  // Métodos getters y setters para los atributos
  public ArrayList<Libro> getLibros() {
    return libros;
  }

  public void setLibros(ArrayList<Libro> libros) {
    this.libros = libros;
  }

  public ArrayList<Usuario> getUsuarios() {
    return usuarios;
  }
}