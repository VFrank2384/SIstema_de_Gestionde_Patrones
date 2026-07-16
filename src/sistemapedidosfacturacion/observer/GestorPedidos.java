package sistemapedidosfacturacion.observer;
import java.util.ArrayList;
import java.util.List;
import sistemapedidosfacturacion.modelo.Pedido;

public class GestorPedidos implements Observable{
	private List<Observador> observadores = new ArrayList<>();

    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(Pedido pedido) {
        for (Observador obs : observadores) {
            obs.actualizar(pedido);
        }
    }

    // FUNCIONALIDAD 1: Cambiar estado y notificar automáticamente
    public void cambiarEstadoPedido(Pedido pedido, String nuevoEstado) {
        String estadoAnterior = pedido.getEstado();
        pedido.setEstado(nuevoEstado);
        System.out.println("🔄 Gestor: Pedido #" + pedido.getId() + 
                           " cambió de '" + estadoAnterior + "' a '" + nuevoEstado + "'");
        // Notificar a todos los observadores
        notificarObservadores(pedido);
    }
}
