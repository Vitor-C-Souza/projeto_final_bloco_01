package model;

import java.math.BigDecimal;

public abstract class Produto {
    private String nome;
    private BigDecimal preco;
    private int estoque;

    public Produto(String nome, BigDecimal preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public BigDecimal calcularDesconto(double percentual) {
        return preco.subtract(preco.multiply(BigDecimal.valueOf(percentual / 100)));
    }

    public void comprar() {
        this.estoque--;
    }

    public void devolver() {
        this.estoque++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
               "nome='" + nome + '\'' +
               ", preco=" + preco +
               ", estoque=" + estoque +
               '}';
    }
}
