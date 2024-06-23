package co.com.activos.rabbitmqpublisher.command;

import co.com.activos.model.comun.command.Command;
import co.com.activos.model.comun.command.CommandGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.async.api.DirectAsyncGateway;
import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Log
@Component
@EnableDirectAsyncGateway
@RequiredArgsConstructor
public class CommandDemo implements CommandGateway {

    private final DirectAsyncGateway directAsyncGateway;
    public static final String APP_DESTINO = "ms_rec_register";


    @Override
    public <T> Mono<Void> emitir(Command command) {
        return directAsyncGateway
                .sendCommand(new org.reactivecommons.api.domain.Command<>(command.nombre()
                                , UUID.randomUUID().toString()
                                , command)
                        , APP_DESTINO);
    }
}

