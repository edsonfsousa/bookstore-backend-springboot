package br.com.livraria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "editoras")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codEditora;

    @NotBlank
    @Size(min = 3, max = 80)
    @Column(nullable = false)
    private String nomeEditora;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(nullable = false)
    private String cidade;

    @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Livro> livros;

}


