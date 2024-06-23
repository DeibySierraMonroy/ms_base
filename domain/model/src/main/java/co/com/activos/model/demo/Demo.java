package co.com.activos.model.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Demo {
    private final String name;
    private final String id;

    // Crear enum
    @Getter
    public enum Estado {

        RECIBIDA("Recibida");
        private final String nombre;

        Estado(String nombre) {
            this.nombre = nombre;
        }
    }
}
