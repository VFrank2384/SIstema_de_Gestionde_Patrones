package sistemapedidosfacturacion.modelo;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int id;
    private List<Producto> productos;
    private double descuento;
    private Direccion direccion;
    private String estado;

    private Pedido() {
        this.productos = new ArrayList<>();
        this.estado = "CREADO";
    }

    public int getId() { return id; }
    public List<Producto> getProductos() { return new ArrayList<>(productos); }
    public double getDescuento() { return descuento; }
    public Direccion getDireccion() { return direccion; }
    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; } // Para Observer

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) total += p.getPrecio();
        return total * (1 - descuento);
    }

    @Override
    public String toString() {
        return "Pedido #" + id + " [Estado: " + estado + ", Total: $" + calcularTotal() + "]";
    }

    // ============ BUILDER INTERNO ============
    public static class Builder {
        private Pedido pedido;

        public Builder() {
            this.pedido = new Pedido();
        }

        // FUNCIONALIDAD 1: Construcción paso a paso
        public Builder id(int id) {
            pedido.id = id;
            return this;
        }

        public Builder agregarProducto(Producto p) {
            pedido.productos.add(p);
            return this;
        }

        public Builder descuento(double d) {
            if (d < 0 || d > 0.5) throw new IllegalArgumentException("Descuento entre 0 y 0.5");
            pedido.descuento = d;
            return this;
        }

        public Builder direccion(Direccion d) {
            pedido.direccion = d;
            return this;
        }

        // FUNCIONALIDAD 2: Validaciones al construir
        public Pedido build() {
            if (pedido.productos.isEmpty()) {
                throw new IllegalStateException("ERROR: El pedido debe tener al menos un producto");
            }
            boolean tieneFisico = pedido.productos.stream().anyMatch(Producto::isEsFisico);
            if (tieneFisico && pedido.direccion == null) {
                throw new IllegalStateException("ERROR: Productos físicos requieren dirección de envío");
            }
            return pedido;
        }
    }
}
