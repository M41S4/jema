package br.com.backend.jema.repository;

import br.com.backend.jema.model.CorProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorProdutoRepo extends JpaRepository<CorProduto,Long> {
}
