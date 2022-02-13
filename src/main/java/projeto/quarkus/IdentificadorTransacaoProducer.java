package projeto.quarkus;
import io.quarkus.arc.DefaultBean;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;


public class IdentificadorTransacaoProducer {


    @Produces
    @DefaultBean
    public IdentificadorTransacao produce(InjectionPoint ip){
        return new IdentificadorTransacao("");
    }
}
