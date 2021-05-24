package br.com.livraria.repository;

import br.com.livraria.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
}
