package br.com.backend.jema.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List; // 1. Certifique-se de ter essa importação

@Entity
@Data
@Table(name = "transportadora")
public class Transportadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String razaoSocial;
    private String cnpjTransportadora;
    private String telefoneTransportadora;


    @OneToMany(mappedBy = "transportadoraMotorista")
    private List<Motorista> motoristas;

    @OneToMany(mappedBy = "transportadora")
    private List<Veiculos> veiculos;
}
