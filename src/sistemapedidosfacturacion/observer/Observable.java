package sistemapedidosfacturacion.observer;
import sistemapedidosfacturacion.modelo.Pedido;

public interface Observable {
	void agregarObservador(Observador observador);
    void eliminarObservador(Observador observador);
    void notificarObservadores(Pedido pedido);
}
