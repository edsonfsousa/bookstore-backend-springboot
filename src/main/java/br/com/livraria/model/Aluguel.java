package br.com.livraria.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
/*import java.util.Date;*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alugueis")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_livro_fk")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "id_usuario_fk")
    private Usuario usuario;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataAluguel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataPrevisao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDevolucao;

}
