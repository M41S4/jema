package br.com.backend.jema.repository;

import br.com.backend.jema.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepo extends JpaRepository <Motorista, Long> {
}
