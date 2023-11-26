package tareados;

public class Novela extends Libro {
  // Atributo específico de las novelas
  private String subgenero;

  // Constructor de la clase Novela
  public Novela(String titulo, String autor, String genero, String subgenero) {
    super(titulo, autor, genero); // Llamar al constructor de la clase padre
    this.subgenero = subgenero; // Inicializar el atributo propio
  }

  // Método getter y setter para el atributo subgenero
  public String getSubgenero() {
    return subgenero;
  }

  public void setSubgenero(String subgenero) {
    this.subgenero = subgenero;
  }

  // Implementar el método mostrarInfo() de la clase padre
  @Override
  public void mostrarInfo() {
    System.out.println("Título: " + getTitulo());
    System.out.println("Autor: " + getAutor());
    System.out.println("Género: " + getGenero());
    System.out.println("Subgénero: " + getSubgenero());
    System.out.println("Disponibilidad: " + (isDisponible() ? "Sí" : "No"));
  }
}
