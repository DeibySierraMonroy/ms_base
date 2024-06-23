package co.com.activos.model.comun.archivo;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;


public interface ArchivoRepository {

    Mono<String> convertirAPDF(String imagen) throws IOException;
    Mono<String> unirPDF(List<String> pdfs) throws Exception;
    Mono<String> reducirPdf(String documento)  throws Exception;

}
