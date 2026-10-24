package br.com.backend.jema.repository;

import br.com.backend.jema.model.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculosRepo extends JpaRepository<Veiculos,Long> {
}
