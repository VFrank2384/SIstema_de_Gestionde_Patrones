package sistemapedidosfacturacion.prototype;
import java.util.ArrayList;
import java.util.List;
import sistemapedidosfacturacion.modelo.Direccion;
import sistemapedidosfacturacion.modelo.Pedido;
import sistemapedidosfacturacion.modelo.Producto;

public class PlantillaPedido implements Plantilla<PlantillaPedido> {

    private String nombre;
    private List<Producto> productos;
    private double descuento;
    private Direccion direccion;

    public PlantillaPedido(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    private PlantillaPedido(PlantillaPedido original) {
        this.nombre = original.nombre;
        this.productos = new ArrayList<>(original.productos);
        this.descuento = original.descuento;
        this.direccion = original.direccion;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public double getDescuento() {
        return descuento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void setDescuento(double descuento) {
        if (descuento < 0 || descuento > 0.5) {
            throw new IllegalArgumentException(
                    "Descuento entre 0 y 0.5"
            );
        }
        this.descuento = descuento;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public PlantillaPedido clonar() {
        return new PlantillaPedido(this);
    }

    public Pedido crearPedido(int id) {
        Pedido.Builder builder = new Pedido.Builder()
                .id(id)
                .descuento(descuento);

        for (Producto producto : productos) {
            builder.agregarProducto(producto);
        }

        if (direccion != null) {
            builder.direccion(direccion);
        }

        return builder.build();
    }

    @Override
    public String toString() {
        return "PlantillaPedido{"
                + "nombre='" + nombre + '\''
                + ", productos=" + productos.size()
                + ", descuento=" + descuento
                + ", direccion=" + direccion
                + '}';
    }
}
