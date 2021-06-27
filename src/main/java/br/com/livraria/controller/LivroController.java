package br.com.livraria.controller;

import br.com.livraria.model.Editora;
import br.com.livraria.model.Livro;
import br.com.livraria.model.dto.LivroDTO;
import br.com.livraria.repository.LivroRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
@Api(value="API REST Livraria")
@CrossOrigin(origins = {"*"})
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("/buscartodos")
    @ApiOperation(value="Retorna uma lista de livros")
    public ResponseEntity<List<LivroDTO>> buscarTodos() {
        /*return livroRepository.findAll();*/
        List<LivroDTO> livroDTOs = livroRepository.findAll().stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
        return new ResponseEntity<>(livroDTOs, HttpStatus.OK);
    }
    @GetMapping("/buscardisp")
    @ApiOperation(value="Retorna uma lista de livros disponiveis")
    public ResponseEntity<List<LivroDTO>> buscarDisp() {
        List<LivroDTO> livroDTOs = livroRepository.findDisponivel().stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
        return new ResponseEntity<>(livroDTOs, HttpStatus.OK);
    }

    @PostMapping("/inserir")
    @ApiOperation(value="Insere um livro")
    public Livro salvar(@RequestBody Livro livro){
        return livroRepository.save(livro);
    }


    @PutMapping("/alterar")
    @ApiOperation(value="Altera um livro")
    public Livro alterar(@RequestBody Livro livro){
        livro.setQuantalugado(livro.getQuantalugado());
        return livroRepository.save(livro);

    }

    @DeleteMapping("/deletar")
    @ApiOperation(value="Deleta um livro")
    public void excluir(@RequestBody Livro livro) {
        livroRepository.delete(livro);
    }
}
