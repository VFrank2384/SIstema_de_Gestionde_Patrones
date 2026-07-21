package sistemapedidosfacturacion.bridge;

public class ProcesadorSeguro implements ProcesadorPago {

    @Override
    public boolean procesarPago(double monto, String descripcion) {
        System.out.println("\n--- PROCESADOR SEGURO ---");
        System.out.println("Verificando datos de seguridad...");
        System.out.println("Validando autenticación...");
        System.out.println("Procesando: " + descripcion);
        System.out.println("Monto: $" + String.format("%.2f", monto));
        System.out.println("Pago procesado de forma segura.");
        
        return true;
    }
}
