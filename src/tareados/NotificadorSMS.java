
package tareados;


public class NotificadorSMS implements Notificador {
    
    // Implementar el método notificar() de la interfaz
  @Override
  public void notificar(String mensaje) {
    // Simular el envío de un SMS con el mensaje
    System.out.println("Enviando SMS con el mensaje: " + mensaje);
  } 
    
}
