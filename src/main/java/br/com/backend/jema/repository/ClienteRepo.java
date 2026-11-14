package br.com.backend.jema.repository;

import br.com.backend.jema.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository <Cliente,Long> {
}
