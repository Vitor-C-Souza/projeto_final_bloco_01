package repository;

import model.ProdutoDigital;
import model.ProdutoFisico;

public interface ProdutoRepository {
    void createFisico(ProdutoFisico produto);

    void createDigital(ProdutoDigital produto);

    void readProdutos();

    void searchProdutoId(Long id);

    void updateProduto(Long id, ProdutoFisico produtoFisico, ProdutoDigital produtoDigital);

    void deleteProduto(Long id);
}
