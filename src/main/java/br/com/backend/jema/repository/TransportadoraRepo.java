package br.com.backend.jema.repository;

import br.com.backend.jema.model.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportadoraRepo extends JpaRepository <Transportadora, Long> {
}
