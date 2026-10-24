package br.com.backend.jema.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Data
@Table(name = "manutencao_veiculo")
public class ManutencaoVeiculo {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    private String resumoManutencao;
    private String descricaoManutencao;
    private BigDecimal valorManutencao;
    private Date dataManutencao;

    @ManyToOne
    @JoinColumn(name = "id_veiculo", nullable = false)
    private Veiculos veiculo;

}
