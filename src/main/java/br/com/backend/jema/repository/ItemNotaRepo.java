
package br.com.backend.jema.repository;

import br.com.backend.jema.model.ItemNota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemNotaRepo extends JpaRepository<ItemNota, Long> {

    @Query("""
        SELECT i
        FROM ItemNota i
        JOIN FETCH i.notaFiscal
        JOIN FETCH i.produto
    """)
    List<ItemNota> buscarItensComNotaEProduto();
}
