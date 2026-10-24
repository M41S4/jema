package br.com.backend.jema.repository;

import br.com.backend.jema.model.DisponibilidadeMotorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisponibilidadeRepo extends JpaRepository <DisponibilidadeMotorista,Long> {
}
