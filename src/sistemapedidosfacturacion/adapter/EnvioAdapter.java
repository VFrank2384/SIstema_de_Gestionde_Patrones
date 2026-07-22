package sistemapedidosfacturacion.adapter;

import sistemapedidosfacturacion.modelo.Direccion;

public class EnvioAdapter implements ServicioEnvio {

    private final ServicioExterno servicioExterno;
    private static final double KG_A_LIBRAS = 2.20462;

    public EnvioAdapter(ServicioExterno servicioExterno) {
        this.servicioExterno = servicioExterno;
    }

    @Override
    public boolean enviar(String codigoPedido, Direccion direccion) {
        if (direccion == null) {
            System.err.println("[Adapter Error] La dirección de envío no puede ser nula.");
            return false;
        }

        String destinoFormateado = String.format("%s, %s, CP: %s",
                direccion.getCalle(),
                direccion.getCiudad(),
                direccion.getCodigoPostal());

        // Convertimos a libras para la API externa
        double pesoLibrasSimulado = 2.5 * KG_A_LIBRAS;

        String resultado = servicioExterno.despacharPaquete(codigoPedido, destinoFormateado, pesoLibrasSimulado);
        return resultado != null && resultado.startsWith("DISPATCHED_OK");
    }

    @Override
    public double calcularCostoEnvio(double pesoKg, String codigoPostal) {
        double pesoLibras = pesoKg * KG_A_LIBRAS;
        return servicioExterno.obtenerTarifaSurcharge(codigoPostal, pesoLibras);
    }
}