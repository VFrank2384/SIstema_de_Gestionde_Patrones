package sistemapedidosfacturacion.modelo;

public class Producto {
	private int id;
    private String nombre;
    private double precio;
    private boolean esFisico;

    public Producto(int id, String nombre, double precio, boolean esFisico) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.esFisico = esFisico;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public boolean isEsFisico() { return esFisico; }

    @Override
    public String toString() {
        return nombre + " ($" + precio + ")" + (esFisico ? " [FÍSICO]" : " [DIGITAL]");
    }
}
