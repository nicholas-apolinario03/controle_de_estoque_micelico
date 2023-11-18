package  com.trab.controle_de_estoque_micelico; 

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/buscarCogumelo/{nome}")
    public Cogumelo buscarCogumelo(@PathVariable String nome) {
        try {
            return estoqueService.buscarCogumelo(nome);
        } catch (Exception e) {
            System.err.println("Erro ao buscar cogumelo: " + e.getMessage());
            return null;
        }
    }

    @PutMapping("/atualizarQuantidade/{nome}/{novaQuantidade}")
    public void atualizarQuantidade(@PathVariable String nome, @PathVariable int novaQuantidade) {
        try {
            estoqueService.atualizarQuantidade(nome, novaQuantidade);
        } catch (Exception e) {
            System.err.println("Erro ao atualizar quantidade: " + e.getMessage());
        }
    }

    @DeleteMapping("/excluirCogumelo/{nome}")
    public void excluirCogumelo(@PathVariable String nome) {
        try {
            estoqueService.excluirCogumelo(nome);
        } catch (Exception e) {
            System.err.println("Erro ao excluir cogumelo: " + e.getMessage());
        }
    }
}