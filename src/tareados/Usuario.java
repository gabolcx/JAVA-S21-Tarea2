
package tareados;

public class Usuario {
    
  // Atributos de los usuarios
  private final String nombre;
  private final String correo;
  private final String contraseña;
  private Libro libroAlquilado;
  private Notificador notificador;

  // Constructor de la clase Usuario
  public Usuario(String nombre, String correo, String contraseña, Notificador notificador) {
    this.nombre = nombre;
    this.correo = correo;
    this.contraseña = contraseña;
    this.libroAlquilado = null; // Por defecto, los usuarios no tienen ningún libro alquilado
    this.notificador = notificador; // Asignar el tipo de notificación que desea el usuario
  }

  // Métodos getters y setters para los atributos
  public String getNombre() {
    return nombre;
  }

  public String getCorreo() {
    return correo;
  }

  public String getContraseña() {
    return contraseña;
  }

  public Libro getLibroAlquilado() {
    return libroAlquilado;
  }

  public void setLibroAlquilado(Libro libroAlquilado) {
    this.libroAlquilado = libroAlquilado;
  }

  public Notificador getNotificador() {
    return notificador;
  }

  public void setNotificador(Notificador notificador) {
    this.notificador = notificador;
  }

  // Definir un método para alquilar un libro
  public void alquilarLibro(Libro libro) throws LibroNoDisponible, UsuarioConLibro {
    // Comprobar si el libro está disponible
    if (!libro.isDisponible()) {
      // Si no lo está, lanzar una excepción
      throw new LibroNoDisponible("El libro " + libro.getTitulo() + " no está disponible.");
    }
    // Comprobar si el usuario ya tiene un libro alquilado
    if (this.libroAlquilado != null) {
      // Si lo tiene, lanzar una excepción
      throw new UsuarioConLibro("El usuario " + this.nombre + " ya tiene un libro alquilado.");
    }
    // Si no hay excepciones, asignar el libro al usuario y cambiar su disponibilidad
    this.libroAlquilado = libro;
    libro.setDisponible(false);
    // Notificar al usuario que ha alquilado el libro con éxito
    this.notificador.notificar("Has alquilado el libro " + libro.getTitulo() + " con éxito.");
  }

  // Definir un método para devolver un libro
  public void devolverLibro() throws UsuarioSinLibro {
    // Comprobar si el usuario tiene un libro alquilado
    if (this.libroAlquilado == null) {
      // Si no lo tiene, lanzar una excepción
      throw new UsuarioSinLibro("El usuario " + this.nombre + " no tiene ningún libro alquilado.");
    }
    // Si no hay excepciones, cambiar la disponibilidad del libro y desasignarlo del usuario
    this.libroAlquilado.setDisponible(true);
    this.libroAlquilado = null;
    // Notificar al usuario que ha devuelto el libro con éxito
    this.notificador.notificar("Has devuelto el libro con éxito.");
  }
}

