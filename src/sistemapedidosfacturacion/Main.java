package sistemapedidosfacturacion;
import sistemapedidosfacturacion.modelo.*;
import sistemapedidosfacturacion.observer.*;
import sistemapedidosfacturacion.abstractfactory.*;
import sistemapedidosfacturacion.prototype.*;

public class Main {
	public static void main(String[] args) {
        System.out.println("=== SISTEMA DE PEDIDOS Y FACTURACIÓN ===");
        System.out.println("=== DEMOSTRACIÓN: BUILDER + OBSERVER ===\n");

        // 1. DEMOSTRACIÓN DEL BUILDER
        System.out.println("--- PARTE 1: BUILDER ---");
        Producto laptop = new Producto(1, "Laptop Gamer", 1200.0, true);
        Producto mouse = new Producto(2, "Mouse Inalámbrico", 45.0, true);
        Producto software = new Producto(3, "Antivirus Premium", 60.0, false);
        Direccion direccion = new Direccion("Av. Principal 123", "Ciudad de México");

        Pedido pedido = new Pedido.Builder()
                .id(1)
                .agregarProducto(laptop)
                .agregarProducto(mouse)
                .agregarProducto(software)
                .descuento(0.1)
                .direccion(direccion)
                .build();
        System.out.println("Pedido creado: " + pedido);

        
        // 2. DEMOSTRACIÓN DEL OBSERVER
        System.out.println("\n--- PARTE 2: OBSERVER ---");

        // Crear el gestor (sujeto)
        GestorPedidos gestor = new GestorPedidos();

        // Crear observadores
        NotificadorEmail email = new NotificadorEmail();
        RegistradorLogs logger = new RegistradorLogs();

        // Suscribir observadores
        gestor.agregarObservador(email);
        gestor.agregarObservador(logger);

        System.out.println("Observadores suscritos: Email y Logger\n");

        // FUNCIONALIDAD 1: Cambiar estado y notificar automáticamente
        System.out.println("--- FUNCIONALIDAD 1: Notificación automática ---");
        gestor.cambiarEstadoPedido(pedido, "PAGADO");
        gestor.cambiarEstadoPedido(pedido, "ENVIADO");

        // FUNCIONALIDAD 2: Ejecutar acciones automáticas (ya se ven en la salida)
        System.out.println("\n--- FUNCIONALIDAD 2: Acciones automáticas ---");
        System.out.println("Email enviado automáticamente (ver arriba)");
        System.out.println("Log registrado automáticamente (ver arriba)");

        // Probar con otro pedido
        System.out.println("\n--- Probando con otro pedido ---");
        Pedido pedido2 = new Pedido.Builder()
                .id(2)
                .agregarProducto(new Producto(4, "E-book Java", 25.0, false))
                .build();
        gestor.cambiarEstadoPedido(pedido2, "PAGADO");
        
        // 3. DEMOSTRACIÓN DEL ABSTRACT FACTORY
        System.out.println("\n--- PARTE 3: ABSTRACT FACTORY ---");

        // FUNCIONALIDAD 1: Crear facturas para diferentes tipos de cliente
        System.out.println("1. CREANDO FACTURAS:");
        FacturaFactory factoryParticular = new FacturaFactoryParticular();
        Factura facturaParticular = factoryParticular.crearFactura();
        facturaParticular.generar();
        System.out.println("   Tipo: " + facturaParticular.getTipo());

        FacturaFactory factoryEmpresa = new FacturaFactoryEmpresa();
        Factura facturaEmpresa = factoryEmpresa.crearFactura();
        facturaEmpresa.generar();
        System.out.println("   Tipo: " + facturaEmpresa.getTipo());

        // FUNCIONALIDAD 2: Crear remitos asociados a esas facturas
        System.out.println("\n2. CREANDO REMITOS ASOCIADOS:");
        Remito remitoParticular = factoryParticular.crearRemito();
        remitoParticular.generar();
        System.out.println("   Tipo: " + remitoParticular.getTipo());

        Remito remitoEmpresa = factoryEmpresa.crearRemito();
        remitoEmpresa.generar();
        System.out.println("   Tipo: " + remitoEmpresa.getTipo());

        // Demostrar que cada fábrica crea una familia completa
        System.out.println("\n3. FAMILIAS COMPLETAS:");
        System.out.println("Cliente PARTICULAR → Factura + Remito:");
        Factura f1 = factoryParticular.crearFactura();
        Remito r1 = factoryParticular.crearRemito();
        f1.generar();
        r1.generar();

        System.out.println("Cliente EMPRESA → Factura + Remito:");
        Factura f2 = factoryEmpresa.crearFactura();
        Remito r2 = factoryEmpresa.crearRemito();
        f2.generar();
        r2.generar();
        
        // 4. DEMOSTRACIÓN DEL PROTOTYPE
        System.out.println("\n--- PARTE 4: PROTOTYPE ---");

        // Crear productos
        Producto tablet = new Producto(1, "Tablet Xiaomi Pad 6", 1200.0, true);
        Producto audifonos = new Producto(2, "AirPods Pro 2", 45.0, true);

        // Crear una plantilla de pedido
        PlantillaPedido plantillaBase = new PlantillaPedido("Plantilla Cliente Frecuente");
        plantillaBase.agregarProducto(tablet);
        plantillaBase.agregarProducto(audifonos);

        // Registrar plantilla en el catálogo
        CatalogoPlantillas catalogo = new CatalogoPlantillas();
        catalogo.registrarPlantilla("cliente_frecuente", plantillaBase);

        // FUNCIONALIDAD 1: Clonar la plantilla
        System.out.println("1. CLONANDO PLANTILLA:");
        PlantillaPedido pedidoClonado = catalogo.obtenerClon("cliente_frecuente");
        System.out.println("   Original: " + plantillaBase.getNombre());
        System.out.println("   Clon: " + pedidoClonado.getNombre());

        // FUNCIONALIDAD 2: Modificar el clon sin afectar al original
        System.out.println("\n2. MODIFICANDO EL CLON:");
        pedidoClonado.setNombre("Pedido Clonado - Con Descuento");
        pedidoClonado.agregarProducto(new Producto(3, "Antivirus", 60.0, false));
        System.out.println("   Original: " + plantillaBase.getNombre() + " (productos: " + plantillaBase.getProductos().size() + ")");
        System.out.println("   Clon modificado: " + pedidoClonado.getNombre() + " (productos: " + pedidoClonado.getProductos().size() + ")");
        System.out.println("   ✅ El clon se modificó sin afectar al original");
        
        System.out.println("\n=== FIN DEMOSTRACIÓN ===");
    }
}
