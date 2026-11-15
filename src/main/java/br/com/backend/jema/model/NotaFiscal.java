
package br.com.backend.jema.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "nota_fiscal")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero_nf;
    private String serie_nf;
    private String chave_nf;
    private LocalDateTime data_emissao;
}
