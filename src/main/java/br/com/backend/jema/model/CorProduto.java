package br.com.backend.jema.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "corProduto")
public class CorProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCor;
}
