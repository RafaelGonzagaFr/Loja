package loja.cadastro_de_produtos.entidades;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto, String> {
}
