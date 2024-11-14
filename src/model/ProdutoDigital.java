package model;

import java.math.BigDecimal;

public class ProdutoDigital extends Produto {
    private double tamanhoArquivo;
    private String formato;

    public ProdutoDigital(String nome, BigDecimal preco, int estoque, double tamanhoArquivo, String formato) {
        super(nome, preco, estoque);
        this.tamanhoArquivo = tamanhoArquivo;
        this.formato = formato;
    }

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public BigDecimal calcularDesconto(double percentual, boolean isPrimeMember) {
        BigDecimal descontoBase = super.calcularDesconto(percentual);

        if (isPrimeMember) {
            BigDecimal descontoPrime = descontoBase.multiply(BigDecimal.valueOf(0.05)); // 5% adicional
            return descontoBase.subtract(descontoPrime);
        }
        return descontoBase;
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                Detalhes:
                    Tamanho : %.2f
                    Formato: %s
                """, super.toString(), this.tamanhoArquivo, this.formato);
    }
}
