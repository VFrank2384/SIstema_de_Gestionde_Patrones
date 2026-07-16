package sistemapedidosfacturacion.abstractfactory;

public class RemitoParticular implements Remito{
	 	@Override
	    public void generar() {
	        System.out.println("Remito para PARTICULAR: Envío a domicilio particular");
	    }

	    @Override
	    public String getTipo() {
	        return "PARTICULAR";
	    }
}
