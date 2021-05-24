package br.com.livraria.repository;

import br.com.livraria.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
