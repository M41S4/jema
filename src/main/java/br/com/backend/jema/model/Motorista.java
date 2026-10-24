package br.com.backend.jema.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "motorista")
public class Motorista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cpf;
    private String nomeMotorista;
    private String sobrenomeMotorista;
    private String cnhMotorista;
    private String observacao;
    @Lob // Indica que é um objeto grande
    @Column(name = "foto", columnDefinition = "oid") // No PostgreSQL, o tipo ideal para @Lob é 'oid' ou 'bytea'
    private byte[] foto;

    @OneToMany(mappedBy = "motorista", cascade = CascadeType.ALL)
    private List<DisponibilidadeMotorista> disponibilidades;

    @OneToOne
    @JoinColumn(name = "id_transportadora")
    private Transportadora transportadoraMotorista;

}
