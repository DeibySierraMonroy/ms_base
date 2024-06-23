package co.com.activos.model.comun.evento;

import reactor.core.publisher.Mono;

public interface EventoGateway {
    <T> Mono<Void> emitir(Evento event);
}
