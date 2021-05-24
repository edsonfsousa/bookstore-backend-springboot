package br.com.livraria.model.dto;

import br.com.livraria.model.Editora;
import br.com.livraria.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditoraDTO {
    private Long codEditora;
    private String nomeEditora;
    private String cidade;

    public EditoraDTO (Editora editora){
        this.codEditora = editora.getCodEditora();
        this.nomeEditora = editora.getNomeEditora();
        this.cidade = editora.getCidade();
    }

}
