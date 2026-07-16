package sistemapedidosfacturacion.abstractfactory;

public class FacturaFactoryEmpresa implements FacturaFactory{
	@Override
    public Factura crearFactura() {
        return new FacturaEmpresa();
    }

    @Override
    public Remito crearRemito() {
        return new RemitoEmpresa();
    }
}
