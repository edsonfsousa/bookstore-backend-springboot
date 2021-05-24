package br.com.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.livraria.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByNomeIgnoreCase(String nome);

}
