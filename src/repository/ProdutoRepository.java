package repository;

import java.math.BigDecimal;

public interface ProdutoRepository {
    void create(String nome, BigDecimal preco, int estoque, int tipo);

    void findAll();

    void findByNome(String nome);

    void update(String nome, BigDecimal preco, int estoque, int tipo);

    void delete(String nome);

    void buyItens(String nome);

    void refund(String nome);
}
