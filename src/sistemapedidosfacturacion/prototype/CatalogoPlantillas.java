package sistemapedidosfacturacion.prototype;
import java.util.HashMap;
import java.util.Map;

public class CatalogoPlantillas {

    private Map<String, PlantillaPedido> plantillas;

    public CatalogoPlantillas() {
        this.plantillas = new HashMap<>();
    }

    public void registrarPlantilla(
            String clave,
            PlantillaPedido plantilla
    ) {
        plantillas.put(clave, plantilla);
    }

    public PlantillaPedido obtenerClon(String clave) {
        PlantillaPedido plantilla = plantillas.get(clave);

        if (plantilla == null) {
            throw new IllegalArgumentException(
                    "No existe una plantilla con la clave: " + clave
            );
        }

        return plantilla.clonar();
    }

    public boolean existePlantilla(String clave) {
        return plantillas.containsKey(clave);
    }
}
