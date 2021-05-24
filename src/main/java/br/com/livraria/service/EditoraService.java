package br.com.livraria.service;


import br.com.livraria.model.Editora;
import br.com.livraria.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
/*import org.springframework.web.bind.annotation.PathVariable;*/

import java.util.List;

@Service
public class EditoraService {

    @Autowired
    public EditoraRepository editoraRepository;

    public Editora salvar (Editora editora){
        return editoraRepository.save(editora);
    }

    public Editora alterar(Editora editora) {
        return null;
    }

    public void excluir(@PathVariable("id") Long codEditora) {
        editoraRepository.deleteById(codEditora);
    }
    public List<Editora> buscarTodos() {
        return editoraRepository.findAll();
    }


}
