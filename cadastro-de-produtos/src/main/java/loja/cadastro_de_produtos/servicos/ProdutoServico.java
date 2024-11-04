package loja.cadastro_de_produtos.servicos;

import loja.cadastro_de_produtos.entidades.Produto;
import loja.cadastro_de_produtos.entidades.ProdutoDTO;
import loja.cadastro_de_produtos.entidades.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServico {
    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    public List<Produto> getAllProdutos() {

        return produtoRepositorio.findAll();
    }

    public Produto criarProduto(ProdutoDTO produtoDTO){
        Produto produto = new Produto(produtoDTO);
        return produtoRepositorio.save(produto);
    }

    public Produto alterarProduto(String produtoId, ProdutoDTO produtoDTO){
        Optional<Produto> optionalProduto = produtoRepositorio.findById(produtoId);
        if(optionalProduto.isPresent()){
            Produto produto = optionalProduto.get();
            produto.setNome(produtoDTO.nome());
            produto.setPreco(produtoDTO.preco());
            return produtoRepositorio.save(produto);
        } else {
            return null;
        }
    }
}
