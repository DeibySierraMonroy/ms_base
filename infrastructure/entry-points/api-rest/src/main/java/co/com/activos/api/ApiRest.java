package co.com.activos.api;

import co.com.activos.model.comun.error.ErrorAplicacion;
import co.com.activos.usecase.DemoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    //    private final MyUseCase useCase;
    private DemoUseCase demoUseCase;


    @GetMapping(path = "/path")
    public String commandName() {
//      return useCase.doAction();
        return "Hello World";
    }

    @PostMapping(path = "/emitirEvent")
    public Mono<Void> sendEvent(@RequestBody String message) {
        return demoUseCase.emitirEvent(message)
                .onErrorResume(throwable -> Mono.error(new
                        ErrorAplicacion("Error al Enviar el evento debido a : " + throwable)));
    }

    @PostMapping(path = "/emitirCommand")
    public Mono<Void> sendCommand(@RequestBody String idDemo) {
        return demoUseCase.emitircommando(idDemo).onErrorResume(throwable ->
                Mono.error(new ErrorAplicacion("Error al Enviar el evento debido a : " + throwable)));

    }
}
