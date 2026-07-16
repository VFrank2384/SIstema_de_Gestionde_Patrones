package sistemapedidosfacturacion.observer;
import sistemapedidosfacturacion.modelo.Pedido;

public interface Observador {
	void actualizar(Pedido pedido);
}
