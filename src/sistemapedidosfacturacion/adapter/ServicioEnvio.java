package sistemapedidosfacturacion.adapter;

import sistemapedidosfacturacion.modelo.Direccion;

public interface ServicioEnvio {
    /**
     * Realiza el envío a una dirección específica.
     */
    boolean enviar(String codigoPedido, Direccion direccion);

    /**
     * Calcula el costo de envío con base en el peso en kg y el código postal.
     */
    double calcularCostoEnvio(double pesoKg, String codigoPostal);
}