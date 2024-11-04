package loja.cadastro_de_produtos.controladores;

import jakarta.validation.Valid;
import loja.cadastro_de_produtos.entidades.Produto;
import loja.cadastro_de_produtos.entidades.ProdutoDTO;
import loja.cadastro_de_produtos.servicos.ProdutoServico;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoServico produtoServico;

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos(){
        return ResponseEntity.ok(produtoServico.getAllProdutos());
    }

    @PostMapping
    public ResponseEntity criarProduto(@RequestBody @Valid ProdutoDTO produtoDTO){
        Produto produto = produtoServico.criarProduto(produtoDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{produtoId}")
    public ResponseEntity<Produto> alterarProduto(@PathVariable String produtoId, @RequestBody @Valid ProdutoDTO produtoDTO) {
        Produto produto = produtoServico.alterarProduto(produtoId, produtoDTO);
        return ResponseEntity.ok(produto);
    }
}
