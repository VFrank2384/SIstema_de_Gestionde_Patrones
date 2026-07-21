package sistemapedidosfacturacion.bridge;

public class ProcesadorRapido implements ProcesadorPago {

    @Override
    public boolean procesarPago(double monto, String descripcion) {
        System.out.println("\n--- PROCESADOR RÁPIDO ---");
        System.out.println("Procesando pago inmediatamente...");
        System.out.println("Procesando: " + descripcion);
        System.out.println("Monto: $" + String.format("%.2f", monto));
        System.out.println("Pago procesado rápidamente.");
        
        return true;
    }
}
