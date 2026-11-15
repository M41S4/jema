
package br.com.backend.jema.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "item_nota")
public class ItemNota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "id_nota_fiscal", nullable = false)
    private NotaFiscal notaFiscal;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;
}
