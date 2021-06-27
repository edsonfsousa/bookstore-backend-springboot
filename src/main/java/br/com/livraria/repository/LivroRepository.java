package br.com.livraria.repository;

import br.com.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query("select a from Livro a where a.quant > a.quantalugado")
    List<Livro> findDisponivel();

}
