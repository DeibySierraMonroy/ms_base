package co.com.activos.model.demo.evento;


import co.com.activos.model.comun.evento.Evento;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DemoEvent implements Evento {

    public static final String NOMBRE_EVENTO = "ms_rec_register.demo.generarPdf";
    private final String idDemo;

    @Override
    public String nombre() {
        return NOMBRE_EVENTO;
    }

}
