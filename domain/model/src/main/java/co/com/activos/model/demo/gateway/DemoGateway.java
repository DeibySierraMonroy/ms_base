package co.com.activos.model.demo.gateway;

import co.com.activos.model.demo.Demo;
import reactor.core.publisher.Mono;

public interface DemoGateway {
    Mono<String> consumosExternoRest(Demo demo);
    Mono<Void> commandDemo(String idDemo);
}
