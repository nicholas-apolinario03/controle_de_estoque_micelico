package  com.trab.controle_de_estoque_micelico; 

import org.springframework.stereotype.Service;

import com.trab.controle_de_estoque_micelico.repository.CogumeloRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {
    private final CogumeloRepository cogumeloRepository;

    public EstoqueService(CogumeloRepository cogumeloRepository) {
        this.cogumeloRepository = cogumeloRepository;
    }

    public void adicionarCogumelo(Cogumelo cogumelo) {
        cogumeloRepository.save(cogumelo);
    }

    public List<Cogumelo> exibirInventario() {
        return cogumeloRepository.findAll();
    }

    public Optional<Cogumelo> buscarCogumelo(Long id) {
        return cogumeloRepository.findById(id);
    }

    public void atualizarQuantidade(Long id, int novaQuantidade) {
        cogumeloRepository.findById(id).ifPresent(cogumelo -> {
            cogumelo.setQuantidade(novaQuantidade);
            cogumeloRepository.save(cogumelo);
        });
    }

    public void excluirCogumelo(Long id) {
        cogumeloRepository.deleteById(id);
    }
}