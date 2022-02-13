package projeto.quarkus;

import io.quarkus.arc.Lock;
import org.graalvm.polyglot.Value;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class FrutasService {

    @Inject
    IdentificadorTransacao identificadorTransacao;

    @Lock(value = Lock.Type.READ, time = 3, unit = TimeUnit.SECONDS)
    public List<Fruta> list() {
        System.out.printf(identificadorTransacao.getIdentificadorTransacao());
        return Fruta.listAll();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public void novaFruta(InserirFrutaDTO inserirFrutaDTO) {
        System.out.printf(identificadorTransacao.getIdentificadorTransacao());
        Fruta fruta = new Fruta();
        fruta.nome = inserirFrutaDTO.getNome();
        fruta.qtd = inserirFrutaDTO.getQtd();
        fruta.persist();
    }

}
