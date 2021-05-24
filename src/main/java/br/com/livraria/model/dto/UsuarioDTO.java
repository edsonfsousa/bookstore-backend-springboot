package br.com.livraria.model.dto;


import br.com.livraria.model.Aluguel;
import br.com.livraria.model.Livro;
import br.com.livraria.model.Usuario;
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
public class UsuarioDTO {


    private Long id;
    private String nome;
    private String cidade;
    private String endereco;
    private String email;

    public UsuarioDTO (Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.cidade = usuario.getCidade();
        this.endereco = usuario.getEndereco();
        this.email = usuario.getEmail();
    }
}
