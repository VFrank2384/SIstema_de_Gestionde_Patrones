package sistemapedidosfacturacion.bridge;

import sistemapedidosfacturacion.modelo.Pedido;

public abstract class MetodoPago {

    protected ProcesadorPago procesador;

    public MetodoPago(ProcesadorPago procesador) {
        this.procesador = procesador;
    }

    public abstract boolean pagar(Pedido pedido);

    public void cambiarProcesador(ProcesadorPago nuevoProcesador) {
        this.procesador = nuevoProcesador;
    }
}
