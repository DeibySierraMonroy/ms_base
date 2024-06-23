package co.com.activos.model.demo.command;

import co.com.activos.model.comun.command.Command;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DemoCommand implements Command {
    public static final String NAME_COMMAND = "ms_rec_register.demo.generarPdf_HV";
    private final String idDemo;

    @Override
    public String nombre() {
        return NAME_COMMAND;
    }
}
