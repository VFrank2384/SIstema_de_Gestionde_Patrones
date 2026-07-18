package sistemapedidosfacturacion.bridge;

import sistemapedidosfacturacion.modelo.Pedido;

public class TarjetaCredito extends MetodoPago {

    private String titular;
    private String numeroTarjeta;

    public TarjetaCredito(
            ProcesadorPago procesador,
            String titular,
            String numeroTarjeta) {

        super(procesador);
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public boolean pagar(Pedido pedido) {

        System.out.println("\n=== PAGO CON TARJETA DE CRÉDITO ===");
        System.out.println("Titular: " + titular);
        System.out.println("Tarjeta: " + ocultarNumeroTarjeta());

        double monto = pedido.calcularTotal();

        return procesador.procesarPago(
                monto,
                "Pago del Pedido #" + pedido.getId()
        );
    }

    private String ocultarNumeroTarjeta() {
        if (numeroTarjeta == null || numeroTarjeta.length() < 4) {
            return "****";
        }

        return "**** **** **** "
                + numeroTarjeta.substring(numeroTarjeta.length() - 4);
    }
}
