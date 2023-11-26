package tareados;

public class Ensayo extends Libro {
    
      // Atributo específico de los ensayos
  private String tema;

  // Constructor de la clase Ensayo
  public Ensayo(String titulo, String autor, String genero, String tema) {
    super(titulo, autor, genero); // Llamar al constructor de la clase padre
    this.tema = tema; // Inicializar el atributo propio
  }

  // Método getter y setter para el atributo tema
  public String getTema() {
    return tema;
  }

  public void setTema(String tema) {
    this.tema = tema;
  }

  // Implementar el método mostrarInfo() de la clase padre
  @Override
  public void mostrarInfo() {
    System.out.println("Título: " + getTitulo());
    System.out.println("Autor: " + getAutor());
    System.out.println("Género: " + getGenero());
    System.out.println("Tema: " + getTema());
    System.out.println("Disponibilidad: " + (isDisponible() ? "Sí" : "No"));
  }
}
