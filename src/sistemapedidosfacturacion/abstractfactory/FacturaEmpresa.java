package sistemapedidosfacturacion.abstractfactory;

public class FacturaEmpresa implements Factura{
	@Override
    public void generar() {
        System.out.println("   📄 Factura para EMPRESA: Incluye RFC y razón social");
    }

    @Override
    public String getTipo() {
        return "EMPRESA";
    }
}
