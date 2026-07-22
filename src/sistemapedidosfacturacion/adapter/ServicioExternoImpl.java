package sistemapedidosfacturacion.adapter;

public class ServicioExternoImpl implements ServicioExterno {

    @Override
    public String despacharPaquete(String idTracking, String destinoCompleto, double pesoLibras) {
        System.out.println("[API Externa Logistics] Procesando guía de despacho...");
        System.out.println("   -> Tracking ID: " + idTracking);
        System.out.println("   -> Destino: " + destinoCompleto);
        System.out.println("   -> Peso convertido: " + pesoLibras + " lbs");
        return "DISPATCHED_OK_" + idTracking;
    }

    @Override
    public double obtenerTarifaSurcharge(String zipCode, double pesoLibras) {
        double tarifaBase = 12.0;
        double cargoPeso = pesoLibras * 1.8;
        double recargoZona = (zipCode != null && zipCode.startsWith("15")) ? 5.0 : 15.0;
        return tarifaBase + cargoPeso + recargoZona;
    }
}