package br.com.backend.jema.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List; // Importação necessária

@Entity
@Data
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeCliente;
    private String cpfCliente;
    private String cpnjCliente; // Dica: caso queira corrigir depois, o padrão é 'cnpjCliente' :)
    private String telefoneCliente;
    private String emailCliente;


    @OneToMany(mappedBy = "cliente_endereco", cascade = CascadeType.ALL)
    private List<Endereco> endereco_cliente;
}
