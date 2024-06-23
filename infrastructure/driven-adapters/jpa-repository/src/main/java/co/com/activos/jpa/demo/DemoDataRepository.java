package co.com.activos.jpa.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;


public interface DemoDataRepository extends CrudRepository<DemoData, String>, QueryByExampleExecutor<DemoData> {

}
