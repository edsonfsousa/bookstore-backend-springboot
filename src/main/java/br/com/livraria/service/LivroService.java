package br.com.livraria.service;


import br.com.livraria.model.Livro;
import br.com.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    public LivroRepository livroRepository;

    public Livro salvar (Livro livro){
        return livroRepository.save(livro);
    }

    public Livro alterar(Livro livro) {
        return null;
    }

    public void excluir(Long id) {
        livroRepository.deleteById(id);
    }


}
