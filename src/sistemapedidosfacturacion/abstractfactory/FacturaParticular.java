package sistemapedidosfacturacion.abstractfactory;

public class FacturaParticular implements Factura{
	 @Override
	    public void generar() {
	        System.out.println("   📄 Factura para PARTICULAR: Incluye nombre y CURP");
	    }

	 @Override
	    public String getTipo() {
	        return "PARTICULAR";
	    }
}

