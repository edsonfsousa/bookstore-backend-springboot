package br.com.livraria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 20)
    @Column(nullable = false, length = 60)
    private String nomeLivro;

    @NotBlank
    @Size(min = 3, max = 20)
    @Column(nullable = false, length = 60)
    private String autor;

    @NotBlank
    @Column(nullable = false)
    private LocalDate lancamento;

    @Column(nullable = false, length = 60)
    private int quant;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Aluguel> alugueis;

    @ManyToOne
    @JoinColumn(name = "editora")
    private Editora editora;
}
