package br.com.livraria.model.dto;

import br.com.livraria.model.Aluguel;
import br.com.livraria.model.Editora;
import br.com.livraria.model.Livro;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {
    private Long id;
    private String nomeLivro;
    private String autor;
    private LocalDate lancamento;
    private int quant;
    private int quantalugado;
    private String nomeEditora;
    private Long codEditora;

    public LivroDTO (Livro livro){
        this.id = livro.getId();
        this.nomeLivro = livro.getNomeLivro();
        this.autor = livro.getAutor();
        this.lancamento = livro.getLancamento();
        this.quant = livro.getQuant();
        this.quantalugado = livro.getQuantalugado();
        this.nomeEditora = livro.getEditora().getNomeEditora();
        this.codEditora = livro.getEditora().getCodEditora();
    }

}
