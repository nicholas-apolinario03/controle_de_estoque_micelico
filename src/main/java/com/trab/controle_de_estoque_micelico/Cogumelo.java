package com.trab.controle_de_estoque_micelico;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 


@Entity
public class Cogumelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Privado por questões de segurança

    private String nome;
    private int quantidade;
	private double preco;
    private LocalDate dataValidade;
    private String cep_final; //Será utilizado no controller na api do google maps
    private String cep_atual; //Será utilizado no controller na api do google maps

    public Cogumelo(String nome, int quantidade, double preco, LocalDate dataValidade, String cep_final, String cep_atual) {
        try {
            if (nome == null || nome.trim().isEmpty()) {
                throw new IllegalArgumentException("O nome do cogumelo não pode ser nulo ou vazio.");
            }

            if (quantidade < 0) {
                throw new IllegalArgumentException("A quantidade do cogumelo não pode ser negativa.");
            }

            if (preco < 0) {
                throw new IllegalArgumentException("O preço do cogumelo não pode ser negativo.");
            }

            if (dataValidade == null || dataValidade.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("A data de validade do cogumelo deve ser no futuro.");
            }

            this.nome = nome;
            this.quantidade = quantidade;
            this.preco = preco;
            this.dataValidade = dataValidade;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar um cogumelo: " + e.getMessage());
        }
    }

    public String getNome() {
        try {
            return nome;
        } catch (NullPointerException e) {
            System.err.println("Erro ao obter o nome do cogumelo: " + e.getMessage());
            return null;
        }
    }

	public void setNome(String nome) {
        try {
            if (nome == null || nome.trim().isEmpty()) {
                throw new IllegalArgumentException("O nome do cogumelo não pode ser nulo ou vazio.");
            }
            this.nome = nome;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao definir o nome do cogumelo: " + e.getMessage());
        }
    }

    public int getQuantidade() {
        try {
            return quantidade;
        } catch (Exception e) {
            System.err.println("Erro ao obter a quantidade do cogumelo: " + e.getMessage());
            return 0; // Valor padrão em caso de erro
        }
    }

    public void setQuantidade(int quantidade) {
        try {
            this.quantidade = quantidade;
        } catch (Exception e) {
            System.err.println("Erro ao definir a quantidade do cogumelo: " + e.getMessage());
        }
    }

	public double getPreco() {
        try {
            return preco;
        } catch (Exception e) {
            System.err.println("Erro ao obter o preço do cogumelo: " + e.getMessage());
            return 0.0; // Valor padrão em caso de erro
        }
    }

	public void setPreco(double preco) {
        try {
            this.preco = preco;
        } catch (Exception e) {
            System.err.println("Erro ao definir o preço do cogumelo: " + e.getMessage());
        }
    }

	public LocalDate getDataValidade() { //Possivel problema caso o computador esteja com o fuso horário alterado
        try {
            return dataValidade;
        } catch (Exception e) {
            System.err.println("Erro ao obter a data de validade do cogumelo: " + e.getMessage());
            return null; // Valor padrão em caso de erro
        }
    }

	public void setDataValidade(LocalDate dataValidade) {
        try {
            this.dataValidade = dataValidade;
        } catch (Exception e) {
            System.err.println("Erro ao definir a data de validade do cogumelo: " + e.getMessage());
        }
    }
}