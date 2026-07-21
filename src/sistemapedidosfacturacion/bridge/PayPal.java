package sistemapedidosfacturacion.bridge;

import sistemapedidosfacturacion.modelo.Pedido;

public class PayPal extends MetodoPago {

    private String correo;

    public PayPal(ProcesadorPago procesador, String correo) {
        super(procesador);
        this.correo = correo;
    }

    @Override
    public boolean pagar(Pedido pedido) {

        System.out.println("\n=== PAGO CON PAYPAL ===");
        System.out.println("Cuenta PayPal: " + correo);

        double monto = pedido.calcularTotal();

        return procesador.procesarPago(
                monto,
                "Pago del Pedido #" + pedido.getId()
        );
    }
}
