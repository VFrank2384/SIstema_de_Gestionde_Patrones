package sistemapedidosfacturacion.observer;
import sistemapedidosfacturacion.modelo.Pedido;
import java.time.LocalDateTime;

public class RegistradorLogs implements Observador{
	// FUNCIONALIDAD 2 (parte 2): Registrar en un log cualquier cambio de estado
    @Override
    public void actualizar(Pedido pedido) {
        String timestamp = LocalDateTime.now().toString().replace("T", " ");
        System.out.println(" LOG [" + timestamp + "] Pedido #" + pedido.getId() + 
                           " Estado: " + pedido.getEstado() + 
                           " | Total: $" + pedido.calcularTotal());
    }
}
