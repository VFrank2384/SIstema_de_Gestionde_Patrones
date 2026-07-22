package sistemapedidosfacturacion.adapter;

public interface ServicioExterno {
    String despacharPaquete(String idTracking, String destinoCompleto, double pesoLibras);
    double obtenerTarifaSurcharge(String zipCode, double pesoLibras);
}