package sistemapedidosfacturacion.observer;
import sistemapedidosfacturacion.modelo.Pedido;

public class NotificadorEmail implements Observador{
	// FUNCIONALIDAD 2 (parte 1): Enviar email cuando el pedido cambia a "PAGADO" o "ENVIADO"
    @Override
    public void actualizar(Pedido pedido) {
        String estado = pedido.getEstado();
        if (estado.equals("PAGADO")) {
            System.out.println(" Email: Su pedido #" + pedido.getId() + 
                               " ha sido pagado. Total: $" + pedido.calcularTotal());
        } else if (estado.equals("ENVIADO")) {
            System.out.println(" Email: Su pedido #" + pedido.getId() + 
                               " ha sido enviado. ¡Gracias por su compra!");
        } else {
            System.out.println(" Email: Estado del pedido #" + pedido.getId() + 
                               " actualizado a: " + estado);
        }
    }
}
