package br.com.backend.jema.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "veiculos")
public class Veiculos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomeVeiculo;
    private String modeloVeiculo;
    private String tipoVeiculo;
    private String placa;
    private String chassi;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
    private List<ManutencaoVeiculo> manutencoes;
}
