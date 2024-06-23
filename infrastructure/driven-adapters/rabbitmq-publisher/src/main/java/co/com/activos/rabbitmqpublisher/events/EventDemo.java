package co.com.activos.rabbitmqpublisher.events;

import co.com.activos.model.comun.error.ErrorAplicacion;
import co.com.activos.model.comun.evento.Evento;
import co.com.activos.model.comun.evento.EventoGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableDomainEventBus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.logging.Level;

@Log
@Component
@EnableDomainEventBus
@RequiredArgsConstructor
public class EventDemo implements EventoGateway {

    private final DomainEventBus domainEventBus;

    @Override
    public <T> Mono<Void> emitir(Evento event) {
        log.log(Level.INFO, "Emitiendo evento de dominio: {0}: {1}", new String[]{event.nombre(), event.toString()});
        return Mono.from(domainEventBus.emit(new DomainEvent<>(event.nombre(),
                UUID.randomUUID().toString(),event)))
                .onErrorResume(throwable ->
                    Mono.error(new ErrorAplicacion("Error publicando el evento" + event.nombre()))
                );
    }
}
