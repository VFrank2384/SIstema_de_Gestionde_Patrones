package sistemapedidosfacturacion.abstractfactory;

public interface FacturaFactory {
	Factura crearFactura();
    Remito crearRemito();
}
