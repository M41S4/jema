package br.com.backend.jema.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "veiculos")
public class Transportadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String razaoSocial;
    private String cnpjTransportadora;
    private String telefoneTransportadora;

    @OneToMany
    @JoinColumn(name = "id_veiculo", nullable = false)
    private Veiculos veiculosTransportadora;
}
