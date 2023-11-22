package com.trab.controle_de_estoque_micelico;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueService {
    private final List<Cogumelo> inventario = new ArrayList<>();

    public void adicionarCogumelo(Cogumelo cogumelo) {
        try {
            inventario.add(cogumelo);
        } catch (Exception e) {
            System.err.println("Erro ao adicionar cogumelo: " + e.getMessage());
        }
    }

    public List<Cogumelo> exibirInventario() {
        try {
            return inventario;
        } catch (Exception e) {
            System.err.println("Erro ao exibir inventário: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public Cogumelo buscarCogumelo(String nome) {
        try {
            for (Cogumelo cogumelo : inventario) {
                if (cogumelo.getNome().equals(nome)) {
                    return cogumelo;
                }
            }
            return null;
        } catch (Exception e) {
            System.err.println("Erro ao buscar cogumelo: " + e.getMessage());
            return null;
        }
    }

    public void atualizarQuantidade(String nome, int novaQuantidade, double novalatitude , double novalongitude) {
        try {
            Cogumelo cogumelo = buscarCogumelo(nome);
            if (cogumelo != null) {
                cogumelo.setQuantidade(novaQuantidade); 
                cogumelo.setLatitude(novalatitude);
                 cogumelo.setLongitude(novalongitude);
            }
        } catch (Exception e) {
            System.err.println("Erro ao atualizar quantidade: " + e.getMessage());
        }
    }

    public void excluirCogumelo(String nome) {
        try {
            Cogumelo cogumelo = buscarCogumelo(nome);
            if (cogumelo != null) {
                inventario.remove(cogumelo);
            }
        } catch (Exception e) {
            System.err.println("Erro ao excluir cogumelo: " + e.getMessage());
        }
    }
}