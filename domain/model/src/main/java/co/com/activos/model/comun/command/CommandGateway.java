package co.com.activos.model.comun.command;

import co.com.activos.model.comun.evento.Evento;
import reactor.core.publisher.Mono;

public interface CommandGateway {
    <T> Mono<Void> emitir(Command command);
}
