package insper.br.pi.observer;

import insper.br.pi.entity.Produto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AuditLoggerObserver implements ProdutoObserver{

    private static final Logger logger = LoggerFactory.getLogger(AuditLoggerObserver.class);

    @Override
    public void atualizar(Produto produto, String statusNovo) {
        String mensagem = String.format(
                "AUDITORIA - Status do produto: %s  - Horário: %s ",
                statusNovo,
                LocalDateTime.now()
        );
        produto.setStatus(mensagem);
        logger.info(mensagem);
    }


}
