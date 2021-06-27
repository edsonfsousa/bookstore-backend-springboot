package br.com.livraria.controller;


import br.com.livraria.model.Aluguel;
import br.com.livraria.model.Editora;
import br.com.livraria.model.Livro;
import br.com.livraria.model.dto.AluguelDTO;
import br.com.livraria.model.dto.EditoraDTO;
import br.com.livraria.repository.AluguelRepository;
import br.com.livraria.repository.LivroRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/alugueis")
@Api(value="API REST Livraria")
@CrossOrigin(origins = {"*"})
public class AluguelController {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("/buscartodos")
    @ApiOperation(value="Retorna uma lista de alugueis")
    public ResponseEntity<List<AluguelDTO>> buscarTodos() {
        List<AluguelDTO> aluguelDTOs = aluguelRepository.findAll().stream().map(aluguel -> new AluguelDTO(aluguel)).collect(Collectors.toList());
        return new ResponseEntity<>(aluguelDTOs, HttpStatus.OK);
    }

    @PostMapping("/inserir")
    @ApiOperation(value="Insere um aluguel")
    public ResponseEntity<Aluguel> salvar(@RequestBody Aluguel aluguel){
        Livro livro = livroRepository.getOne(aluguel.getLivro().getId());

        if(aluguel.getDataPrevisao().isBefore(aluguel.getDataAluguel())){
            return new ResponseEntity("Previsão maior que Aluguel", HttpStatus.BAD_REQUEST);
        }else{
            if (livro.getQuantalugado() != livro.getQuant()) {
                livro.setQuantalugado(livro.getQuantalugado() +1);
                livroRepository.save(livro);

                return new ResponseEntity(aluguelRepository.save(aluguel), HttpStatus.OK);
            }
            else{
                return new ResponseEntity("Quantidade alugada menor que a quantidade", HttpStatus.BAD_REQUEST);
            }

        }
    }

    @PutMapping("/alterar")
    @ApiOperation(value="Altera um aluguel")
    public ResponseEntity<Aluguel> alterar(@RequestBody Aluguel aluguel) {
        Livro livro = livroRepository.getOne(aluguel.getLivro().getId());

        if(aluguel.getDataPrevisao().isBefore(aluguel.getDataAluguel())){
            return new ResponseEntity("Previsão maior que Aluguel", HttpStatus.BAD_REQUEST);
        }else{

            livro.setQuantalugado(livro.getQuantalugado() -1);
            livroRepository.save(livro);

            return new ResponseEntity(aluguelRepository.save(aluguel), HttpStatus.OK);
        }

    }

    @DeleteMapping("/deletar")
    @ApiOperation(value="Deleta um aluguel")
    public void excluir(@RequestBody Aluguel aluguel) {
        aluguelRepository.delete(aluguel);
    }

}
