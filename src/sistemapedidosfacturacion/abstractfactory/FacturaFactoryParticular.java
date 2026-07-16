package sistemapedidosfacturacion.abstractfactory;

public class FacturaFactoryParticular implements FacturaFactory{
	@Override
    public Factura crearFactura() {
        return new FacturaParticular();
    }

    @Override
    public Remito crearRemito() {
        return new RemitoParticular();
    }
}
