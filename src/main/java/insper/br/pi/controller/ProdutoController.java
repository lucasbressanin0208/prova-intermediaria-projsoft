package insper.br.pi.controller;

import insper.br.pi.entity.Produto;
import insper.br.pi.repository.ProdutoRepository;
import insper.br.pi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        return produtoService.criar(produto);
    }

    @GetMapping
    public List<Produto> listar(){
        return produtoService.FindAll();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable long id){
        return produtoService.buscar(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        produtoService.deleteProduto(id);
    }

}
