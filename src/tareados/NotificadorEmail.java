
package tareados;

public class NotificadorEmail implements Notificador {
  
    // Implementar el método notificar() de la interfaz
  @Override
  public void notificar(String mensaje) {
    // Simular el envío de un correo electrónico con el mensaje
    System.out.println("Enviando correo electrónico con el mensaje: " + mensaje);
  }
    
}
