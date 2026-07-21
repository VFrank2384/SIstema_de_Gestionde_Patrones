package sistemapedidosfacturacion.bridge;

public interface ProcesadorPago {

    boolean procesarPago(double monto, String descripcion);
}
