package insper.br.pi.service;

import insper.br.pi.entity.Produto;
import insper.br.pi.observer.ProdutoObserver;
import insper.br.pi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired(required = false)
    private List<ProdutoObserver> produtoObservers;

    public void notificarObservadores(Produto produto, String statusNovo){
        for (ProdutoObserver observer : produtoObservers) {
            observer.atualizar(produto, statusNovo);
        }
    }

    public Produto criar(Produto produto)
        {
        Produto salvo = produtoRepository.save(produto);
        if (produto.getQuantidade() < 10) {
            notificarObservadores(salvo,"Estoque Baixo");
        }
        notificarObservadores(salvo, "Criado");
        return  salvo;
        }

    public List<Produto> FindAll()
        {
        return produtoRepository.findAll();
        }

    public Produto buscar(long id) {
        return produtoRepository.findById(id);
    }

    public void deleteProduto(long id) {
        Produto produto = produtoRepository.findById(id);
        notificarObservadores(produto, "deletado");
        produtoRepository.delete(produto);
    }
}
