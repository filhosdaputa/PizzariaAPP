package br.edu.ifms.pizzaria.model;

public class Bebida {
    private String Nome;
    private String Preco;

    public Bebida(String nome, String preco) {
        Nome = nome;
        Preco = preco;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getPreco() {
        return Preco;
    }

    public void setPreco(String preco) {
        Preco = preco;
    }
}
