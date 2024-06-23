package co.com.activos.usecase;

import co.com.activos.model.comun.command.CommandGateway;
import co.com.activos.model.comun.error.ErrorAplicacion;
import co.com.activos.model.comun.evento.EventoGateway;
import co.com.activos.model.demo.command.DemoCommand;
import co.com.activos.model.demo.evento.DemoEvent;
import co.com.activos.model.demo.gateway.DemoGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import reactor.core.publisher.Mono;

import java.util.logging.Level;

@Log
@RequiredArgsConstructor
public class DemoUseCase {

    private final EventoGateway eventoGateway;
    private final CommandGateway commandGateway;

    public Mono<String> handlerEvent(String idEvent) {
        log.log(Level.INFO, "Recibiendo evento de dominio: {0}", new String[]{idEvent});
        return Mono.just("Evento Recibido : " + idEvent)
                .onErrorResume(throwable ->
                        Mono.error(new ErrorAplicacion("Error al escuchar el evento")));
    }

    public Mono<String> handlerCommand(String idCommand) {
        log.log(Level.INFO, "Recibiendo comando de dominio: {0}", new String[]{idCommand});
        return Mono.just("Evento Recibido : " + idCommand)
                .onErrorResume(throwable ->
                        Mono.error(new ErrorAplicacion("Error al escuchar el comando")));
    }

    public Mono<Void> emitirEvent(String message) {
        return eventoGateway.emitir(new DemoEvent(message));
    }

    public Mono<Void> emitircommando(String message){
        return commandGateway.emitir(new DemoCommand(message));
    }
}
