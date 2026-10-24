package br.com.backend.jema.model;
import jakarta.persistence.*; //serve para conectar suas classes Java a um banco de dados relacional de forma automática
import lombok.Data; // Não precisa declarar getters e setters o tempo todo

@Entity
@Data
@Table(name = "produto")
public class Produto {
    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cria números sequenciais para os Id's
    private Long id;
    private String sku_produto;
    private String nome_produto;
    private String descricao_produto;
    private float peso;
    private float altura;
    private float comprimento;
    private float largura;

    // Chave estrangeira, um produto pode ter várias cores
    @ManyToOne
    @JoinColumn(name = "id_cor_produto", nullable = false)
    private CorProduto cor_produto;
}
