package br.com.backend.jema.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cepEndereco;
    private String logradouroEndereco;
    private String nomeLogradouro;
    private String numeroEndereco;
    private String codigoCidade;
    private String cidadeEndereco;
    private String ufEndereco;
    private String bairroEndereco;
    private String codigoPais;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente_endereco;

}
