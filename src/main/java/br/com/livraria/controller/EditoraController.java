package br.com.livraria.controller;


import br.com.livraria.model.Editora;
import br.com.livraria.model.dto.EditoraDTO;
import br.com.livraria.model.dto.LivroDTO;
import br.com.livraria.repository.EditoraRepository;
import br.com.livraria.service.EditoraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/editoras")
@Api(value="API REST Livraria")
@CrossOrigin(origins = {"*"})
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @GetMapping("/buscartodos")
    @ApiOperation(value="Retorna uma lista de editoras")
    public ResponseEntity<List<EditoraDTO>> buscarTodos() {
            List<EditoraDTO> editoraDTOs = editoraRepository.findAll().stream().map(editora -> new EditoraDTO(editora)).collect(Collectors.toList());
               return new ResponseEntity<>(editoraDTOs, HttpStatus.OK);
    }

    @PostMapping("/inserir")
    @ApiOperation(value="Insere uma editora")
    public Editora salvar(@RequestBody Editora editora){
        return editoraRepository.save(editora);
    }

    @PutMapping("/alterar")
    @ApiOperation(value="Altera uma editora")
    public Editora alterar(@RequestBody Editora editora) {
        return editoraRepository.save(editora);

    }

    @DeleteMapping("/deletar")
    @ApiOperation(value="Deleta uma editora")
    public void excluir(@RequestBody Editora editora) {
        editoraRepository.delete(editora);
    }
}
