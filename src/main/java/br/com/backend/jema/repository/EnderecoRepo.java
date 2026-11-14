package br.com.backend.jema.repository;

import br.com.backend.jema.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepo extends JpaRepository <Endereco,Long> {
}
