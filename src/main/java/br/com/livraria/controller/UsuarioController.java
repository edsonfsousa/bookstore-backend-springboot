package br.com.livraria.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.livraria.model.dto.AluguelDTO;
import br.com.livraria.model.dto.UsuarioDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.livraria.model.Usuario;
import br.com.livraria.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuarios")
@Api(value="API REST Livraria")
@CrossOrigin(origins = {"*"})
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping("/buscartodos")
    @ApiOperation(value="Retorna uma lista de usuários")
    public ResponseEntity<List<UsuarioDTO>> buscarTodos() {
        List<UsuarioDTO> usuarioDTOs = usuarioRepository.findAll().stream().map(usuario -> new UsuarioDTO(usuario)).collect(Collectors.toList());
        return new ResponseEntity<>(usuarioDTOs, HttpStatus.OK);
    }

    @PostMapping("/inserir")
    @ApiOperation(value="Insere um usuário")
    public Usuario inserir(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);

    }

    @PutMapping("/alterar")
    @ApiOperation(value="Altera um usuário")
    public Usuario alterar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);

    }

    @DeleteMapping("/deletar")
    @ApiOperation(value="Deleta um usuário")
    public void excluir(@RequestBody Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    /*@GetMapping("/buscarid/{id}")
    public Optional<Usuario> buscarPorId(@PathVariable("id") Long id) {
        return usuarioRepository.findById(id);
    }*/

    /*@GetMapping("/buscarnome/{nome}")
    public List<Usuario> buscarPorNome(@PathVariable("nome") String nome) {
        return usuarioRepository.findByNomeIgnoreCase(nome);
    }

    @GetMapping("/buscarnomeesenha")
    public List<Usuario> buscarPorNomeEsenha(@RequestParam("nome") String nome, @RequestParam("senha") String senha) {
        return usuarioRepository.findByNomeAndSenha(nome, senha);
    }

    @PostMapping("/autenticar")
    public List<Usuario> autenticar(@RequestBody Usuario usuario) throws UsuarioNaoEncontradoException {
        List<Usuario> l = usuarioRepository.findByNomeAndSenha(usuario.getNome(), usuario.getSenha());

        if (l == null && l.size() == 0) {
            throw new UsuarioNaoEncontradoException();
        } else {
            return l;
        }
    }*/


    /*@GetMapping("/buscarporperfil")
    List<Usuario> buscarPorPerfil(@RequestParam("descricao") String descricao) {
        return usuarioRepository.buscarPorPerfil(descricao);

    }*/

}