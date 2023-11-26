
package tareados;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear biblioteca
        try (Scanner scanner = new Scanner(System.in)) {
            // Crear biblioteca
            Biblioteca biblioteca = new Biblioteca();
            int opcion;
            do {
                // Mostrar menú
                System.out.println("\nMenu:");
                System.out.println("1. Agregar nuevo libro a la biblioteca");
                System.out.println("2. Eliminar libro existente de la biblioteca");
                System.out.println("3. Registrar usuario en el sistema");
                System.out.println("4. Alquilar libro");
                System.out.println("5. Devolver libro");
                System.out.println("6. Buscar libro por título, autor o género");
                System.out.println("0. Salir");
                System.out.print("Ingrese el número de la opción: ");
                
                // Leer la opción ingresada por el usuario
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                
                switch (opcion) {
                    case 1 -> // Agregar nuevo libro a la biblioteca
                        agregarLibro(biblioteca, scanner);
                    case 2 -> // Eliminar libro existente de la biblioteca
                        eliminarLibro(biblioteca, scanner);
                    case 3 -> // Registrar usuario en el sistema
                        registrarUsuario(biblioteca, scanner);
                    case 4 -> // Alquilar libro
                        alquilarLibro(biblioteca, scanner);
                    case 5 -> // Devolver libro
                        devolverLibro(biblioteca, scanner);
                    case 6 -> // Buscar libro por título, autor o género
                        buscarLibro(biblioteca, scanner);
                    case 0 -> // Salir del programa
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                    default -> System.out.println("Opción no válida. Intente nuevamente.");
                }
            } while (opcion != 0);
            // Cerrar el scanner al finalizar
        }
    }
    // Métodos para cada opción del menú




private static ArrayList<Libro> buscarLibrosPorTermino(Biblioteca biblioteca, String termino) {
    ArrayList<Libro> librosEncontrados = new ArrayList<>();

    for (Libro libro : biblioteca.getLibros()) {
        // Buscar por título, autor o género
        if (libro.getTitulo().toLowerCase().contains(termino.toLowerCase()) ||
            libro.getAutor().toLowerCase().contains(termino.toLowerCase()) ||
            libro.getGenero().toLowerCase().contains(termino.toLowerCase())) {
            librosEncontrados.add(libro);
        }
    }

    return librosEncontrados;
}

    
    private static void agregarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("\nIngrese los datos del nuevo libro:");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("Subgénero (si es una novela): ");
        String subgenero = scanner.nextLine();

        Libro nuevoLibro;
        if (subgenero.isEmpty()) {
            nuevoLibro = new Ensayo(titulo, autor, genero, "Tema no especificado");
        } else {
            nuevoLibro = new Novela(titulo, autor, genero, subgenero);
        }

        biblioteca.getLibros().add(nuevoLibro);
        System.out.println("Libro agregado con éxito.");
    }

    private static Usuario buscarUsuarioPorNombre(Biblioteca biblioteca, String nombre) {
    for (Usuario usuario : biblioteca.getUsuarios()) {
        if (usuario.getNombre().equalsIgnoreCase(nombre)) {
            return usuario; // Se encontró el usuario con el nombre especificado
        }
    }
    return null; // No se encontró ningún usuario con el nombre especificado
}
    
           private static Libro buscarLibroPorTitulo(Biblioteca biblioteca, String titulo) {
    for (Libro libro : biblioteca.getLibros()) {
        if (libro.getTitulo().equalsIgnoreCase(titulo)) {
            return libro; // Se encontró el libro con el título especificado
        }
    }
    return null; // No se encontró ningún libro con el título especificado
}
           
            private static void eliminarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("\nIngrese el título del libro que desea eliminar:");
        String tituloEliminar = scanner.nextLine();
        
        // Buscar el libro por título
        Libro libroEliminar = buscarLibroPorTitulo(biblioteca, tituloEliminar);

        if (libroEliminar != null) {
            biblioteca.getLibros().remove(libroEliminar);
            System.out.println("Libro eliminado con éxito.");
        } else {
            System.out.println("No se encontró un libro con el título especificado.");
        }
    }

    private static void registrarUsuario(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("\nIngrese los datos del nuevo usuario:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        Notificador notificadorEmail = new NotificadorEmail();
        Usuario nuevoUsuario = new Usuario(nombre, correo, contraseña, notificadorEmail);

        biblioteca.getUsuarios().add(nuevoUsuario);
        System.out.println("Usuario registrado con éxito.");
    }

    private static void alquilarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("\nIngrese el título del libro que desea alquilar:");
        String tituloAlquilar = scanner.nextLine();

        // Buscar el libro por título
        Libro libroAlquilar = buscarLibroPorTitulo(biblioteca, tituloAlquilar);

        if (libroAlquilar != null) {
            System.out.println("\nIngrese el nombre del usuario que desea alquilar el libro:");
            String nombreUsuario = scanner.nextLine();

            // Buscar el usuario por nombre
            Usuario usuarioAlquilar = buscarUsuarioPorNombre(biblioteca, nombreUsuario);

            if (usuarioAlquilar != null) {
                try {
                    usuarioAlquilar.alquilarLibro(libroAlquilar);
                    System.out.println("Libro alquilado con éxito.");
                } catch (LibroNoDisponible | UsuarioConLibro e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println("No se encontró un usuario con el nombre especificado.");
            }
        } else {
            System.out.println("No se encontró un libro con el título especificado.");
        }
    }

    private static void devolverLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("\nIngrese el nombre del usuario que desea devolver el libro:");
        String nombreUsuarioDevolver = scanner.nextLine();

        // Buscar el usuario por nombre
        Usuario usuarioDevolver = buscarUsuarioPorNombre(biblioteca, nombreUsuarioDevolver);

        if (usuarioDevolver != null) {
            try {
                usuarioDevolver.devolverLibro();
                System.out.println("Libro devuelto con éxito.");
            } catch (UsuarioSinLibro e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("No se encontró un usuario con el nombre especificado.");
        }
    }

    private static void buscarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("\nIngrese el término de búsqueda (título, autor o género):");
        String terminoBusqueda = scanner.nextLine();

        // Buscar libros por título, autor o género
        ArrayList<Libro> librosEncontrados = buscarLibrosPorTermino(biblioteca, terminoBusqueda);

        if (!librosEncontrados.isEmpty()) {
            System.out.println("\nLibros encontrados:");
            for (Libro libro : librosEncontrados) {
                libro.mostrarInfo();
                System.out.println("---------------------");
            }
        } else {
            System.out.println("No se encontró un libro con el título especificado.");
        }      
    }
}