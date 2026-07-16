package sistemapedidosfacturacion.abstractfactory;

public class RemitoEmpresa implements Remito{
	@Override
    public void generar() {
        System.out.println("Remito para EMPRESA: Envío a oficina con horario comercial");
    }

    @Override
    public String getTipo() {
        return "EMPRESA";
    }
}
