package tareados;

public abstract class Libro {

     // Atributos comunes a todos los libros
  private final String titulo;
  private final String autor;
  private final String genero;
  private boolean disponible;

  // Constructor de la clase Libro
  public Libro(String titulo, String autor, String genero) {
    this.titulo = titulo;
    this.autor = autor;
    this.genero = genero;
    this.disponible = true; // Por defecto, los libros están disponibles
  }

  // Métodos getters y setters para los atributos
  public String getTitulo() {
    return titulo;
  }

  public String getAutor() {
    return autor;
  }

  public String getGenero() {
    return genero;
  }

  public boolean isDisponible() {
    return disponible;
  }

  public void setDisponible(boolean disponible) {
    this.disponible = disponible;
  }

  // Definir un método abstracto para mostrar la información del libro
  public abstract void mostrarInfo();
}