// Ponte entre código e o banco de dados

package br.com.backend.jema.repository;
import br.com.backend.jema.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepo extends JpaRepository<Produto,Long> { //Quero que meu repositório herde (copie) todos os métodos de banco de dados que o Spring já deixou prontos

}
