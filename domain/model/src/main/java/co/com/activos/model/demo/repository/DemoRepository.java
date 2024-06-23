package co.com.activos.model.demo.repository;


import co.com.activos.model.demo.Demo;
import reactor.core.publisher.Mono;

public interface DemoRepository {

    Mono<Demo> accesoABaseDeDatos(Integer idDemo);

}


