package sistemapedidosfacturacion;
import sistemapedidosfacturacion.modelo.*;

public class Main {
	public static void main(String[] args) {
        System.out.println("=== SISTEMA DE PEDIDOS Y FACTURACIÓN ===");
        System.out.println("=== DEMOSTRACIÓN PATRÓN BUILDER ===\n");

        // PRODUCTOS
        Producto laptop = new Producto(1, "Laptop Gamer", 1200.0, true);
        Producto mouse = new Producto(2, "Mouse Inalámbrico", 45.0, true);
        Producto software = new Producto(3, "Antivirus Premium", 60.0, false);

        // DIRECCIÓN
        Direccion direccion = new Direccion("Av. Principal 123", "Ciudad de México");

        // --- FUNCIONALIDAD 1: Construcción paso a paso ---
        System.out.println("1. CONSTRUCCIÓN PASO A PASO:");
        Pedido pedidoValido = new Pedido.Builder()
                .id(1)
                .agregarProducto(laptop)
                .agregarProducto(mouse)
                .agregarProducto(software)
                .descuento(0.1)
                .direccion(direccion)
                .build();

        System.out.println(" Pedido creado: " + pedidoValido);
        System.out.println(" Productos: " + pedidoValido.getProductos());
        System.out.println(" Dirección: " + pedidoValido.getDireccion());

        // --- FUNCIONALIDAD 2: Validaciones ---
        System.out.println("\n2. VALIDACIONES:");

        // Validación 1: Sin productos
        try {
            System.out.println("Intentando pedido sin productos...");
            new Pedido.Builder().id(2).build();
        } catch (IllegalStateException e) {
            System.out.println(" " + e.getMessage());
        }

        // Validación 2: Producto físico sin dirección
        try {
            System.out.println(" Intentando pedido físico sin dirección...");
            new Pedido.Builder()
                .id(3)
                .agregarProducto(new Producto(4, "Teclado Mecánico", 80.0, true))
                .build();
        } catch (IllegalStateException e) {
            System.out.println(" " + e.getMessage());
        }

        // Validación 3: Producto digital sin dirección (SÍ funciona)
        System.out.println(" Pedido digital sin dirección (válido):");
        Pedido pedidoDigital = new Pedido.Builder()
                .id(4)
                .agregarProducto(new Producto(5, "E-book Java", 25.0, false))
                .build();
        System.out.println("   " + pedidoDigital);

        System.out.println("\n=== FIN DEMOSTRACIÓN BUILDER ===");
    }
}
