package co.com.activos.rabbitmqsubscription.convertidor;

import co.com.activos.rabbitmqsubscription.dto.DemoDto;

public class Convertidor {
    private Convertidor() {
        throw new IllegalStateException("Clase de utilidad");
    }
    public static String obtenerIdDemo(DemoDto data) {
        return data.getIdDemo();
    }

}
