package co.com.activos.jpa.demo;


import co.com.activos.jpa.helper.AdapterOperations;
import co.com.activos.model.demo.Demo;
import co.com.activos.model.demo.repository.DemoRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public class DemoRepositoryAdapter extends AdapterOperations<Demo, DemoData, String, DemoDataRepository>
        implements DemoRepository {

    public DemoRepositoryAdapter(DemoDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Demo.DemoBuilder.class).build());
    }


    @Override
    public Mono<Demo> accesoABaseDeDatos(Integer idDemo) {
        return Mono.empty();
    }
}
