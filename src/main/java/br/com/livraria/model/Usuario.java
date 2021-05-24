package br.com.livraria.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 20)
    @Column(nullable = false, length = 60)
    private String nome;


    @NotBlank
    @Size(min = 3, max = 20)
    @Column(nullable = false)
    private String cidade;

    @NotBlank
    @Size(min = 3, max = 20)
    @Column(nullable = false)
    private String endereco;

    @NotBlank
    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "usuario")
    private List<Aluguel> alugueis;


}
