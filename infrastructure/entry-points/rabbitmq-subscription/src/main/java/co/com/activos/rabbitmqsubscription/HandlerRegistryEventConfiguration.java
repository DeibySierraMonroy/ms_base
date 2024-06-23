package co.com.activos.rabbitmqsubscription;

import co.com.activos.rabbitmqsubscription.convertidor.Convertidor;
import co.com.activos.rabbitmqsubscription.dto.DemoDto;
import co.com.activos.usecase.DemoUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.async.api.HandlerRegistry;
import org.reactivecommons.async.impl.config.annotations.EnableMessageListeners;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static co.com.activos.model.demo.command.DemoCommand.NAME_COMMAND;
import static org.reactivecommons.async.api.HandlerRegistry.register;

@Log
@Configuration
@RequiredArgsConstructor
@EnableMessageListeners
public class HandlerRegistryEventConfiguration {

    private static final String NOMBRE_EVENTO = "ms_rec_register.demo.generarPdf";

    private final DemoUseCase demoUseCase;
    @Bean
    public HandlerRegistry subscripcionEventos() {
        return register()
                .listenEvent(NOMBRE_EVENTO,
                        event -> demoUseCase.handlerEvent(Convertidor.obtenerIdDemo(event.getData()))
                                .then(),
                        DemoDto.class);

    }

    @Bean
    public HandlerRegistry subscripcionComando() {
        return register()
                .handleCommand(NAME_COMMAND,objectCommand -> demoUseCase.handlerCommand(
                                Convertidor.obtenerIdDemo(objectCommand.getData()))
                        .then(),DemoDto.class);
    }


}
