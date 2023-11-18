package  com.trab.controle_de_estoque_micelico; 

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estoque") //Caminho padrão

public class EstoqueController {
    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @PostMapping("/adicionarCogumelo")
    public void adicionarCogumelo(@RequestBody Cogumelo cogumelo) {
        try {
            estoqueService.adicionarCogumelo(cogumelo);
        } catch (Exception e) {
            System.err.println("Erro ao adicionar cogumelo: " + e.getMessage());
        }
    }

    @GetMapping("/exibirInventario")
    public List<Cogumelo> exibirInventario() {
        try {
            return estoqueService.exibirInventario();
        } catch (Exception e) {
            System.err.println("Erro ao exibir inventário: " + e.getMessage());
            return null;
        }
    }

    @GetMapping("/buscarCogumelo/{id}")
    public Cogumelo buscarCogumelo(@PathVariable Long id) {
        try {
            Optional<Cogumelo> optionalCogumelo = estoqueService.buscarCogumelo(id);
            return optionalCogumelo.orElse(null);
        } catch (Exception e) {
            System.err.println("Erro ao buscar cogumelo: " + e.getMessage());
            return null;
        }
    }

    @PutMapping("/atualizarQuantidade/{id}/{novaQuantidade}")
    public void atualizarQuantidade(@PathVariable Long id, @PathVariable int novaQuantidade) {
        try {
            estoqueService.atualizarQuantidade(id, novaQuantidade);
        } catch (Exception e) {
            System.err.println("Erro ao atualizar quantidade: " + e.getMessage());
        }
    }

    @DeleteMapping("/excluirCogumelo/{id}")
    public void excluirCogumelo(@PathVariable Long id) {
        try {
            estoqueService.excluirCogumelo(id);
        } catch (Exception e) {
            System.err.println("Erro ao excluir cogumelo: " + e.getMessage());
        }
    }
}