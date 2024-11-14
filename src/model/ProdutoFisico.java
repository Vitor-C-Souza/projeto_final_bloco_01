package model;

import java.math.BigDecimal;

public class ProdutoFisico extends Produto {
    private double peso;
    private String dimensoes;


    public ProdutoFisico(String nome, BigDecimal preco, int estoque, double peso, String dimensoes) {
        super(nome, preco, estoque);
        this.peso = peso;
        this.dimensoes = dimensoes;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public BigDecimal calcularDesconto(double percentual, double descontoAdicional) {
        BigDecimal descontoBase = super.calcularDesconto(percentual);
        BigDecimal adicional = descontoBase.multiply(BigDecimal.valueOf(descontoAdicional / 100));
        return descontoBase.subtract(adicional);
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                Detalhes:
                    Peso : %.2f
                    Dimensoes: %s
                """, super.toString(), this.peso, this.dimensoes);
    }
}
