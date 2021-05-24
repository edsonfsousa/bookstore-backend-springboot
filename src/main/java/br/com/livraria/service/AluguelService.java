package br.com.livraria.service;


import br.com.livraria.model.Aluguel;
import br.com.livraria.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AluguelService {

    @Autowired
    public AluguelRepository aluguelRepository;

    public Aluguel salvar (Aluguel aluguel){
        return aluguelRepository.save(aluguel);
    }

    public Aluguel alterar(Aluguel aluguel) {
        return null;
    }

    public void excluir(Long id) {
        aluguelRepository.deleteById(id);
    }
}
