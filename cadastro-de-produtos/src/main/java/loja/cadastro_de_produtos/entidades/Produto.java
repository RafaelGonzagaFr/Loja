package loja.cadastro_de_produtos.entidades;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "produtos")
@Entity(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String preco;

    public Produto(ProdutoDTO produtoDTO){
        this.nome = produtoDTO.nome();
        this.preco = produtoDTO.preco();
    }
}
