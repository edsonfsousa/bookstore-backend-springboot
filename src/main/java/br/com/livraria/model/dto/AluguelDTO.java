package br.com.livraria.model.dto;

import br.com.livraria.model.Aluguel;
import br.com.livraria.model.Livro;
import br.com.livraria.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AluguelDTO {
    private Long id;
    private String nomeLivro;
    private String nome;
    private LocalDate dataAluguel;
    private LocalDate dataPrevisao;
    private Long livroId;
    private Long usuarioId;

    public AluguelDTO (Aluguel aluguel){
        this.id = aluguel.getId();
        this.nomeLivro = aluguel.getLivro().getNomeLivro();
        this.nome = aluguel.getUsuario().getNome();
        this.dataAluguel = aluguel.getDataAluguel();
        this.dataPrevisao = aluguel.getDataPrevisao();
        this.livroId = aluguel.getLivro().getId();
        this.usuarioId = aluguel.getUsuario().getId();
    }
}
