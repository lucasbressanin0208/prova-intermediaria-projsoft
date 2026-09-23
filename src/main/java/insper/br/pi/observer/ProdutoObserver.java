package insper.br.pi.observer;

import insper.br.pi.entity.Produto;

public interface ProdutoObserver {
    void atualizar (Produto produto, String statusNovo);
}
