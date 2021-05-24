package br.com.livraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*import br.com.livraria.model.Perfil;*/
import br.com.livraria.model.Usuario;
import br.com.livraria.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario salvar (Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario alterar(Usuario usuario) {
        return null;
    }

    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> buscarPorNome(String nome) {
        return usuarioRepository.findByNomeIgnoreCase(nome);
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }



}
