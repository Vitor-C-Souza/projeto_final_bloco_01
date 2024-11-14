package controller;

import model.Produto;
import model.ProdutoDigital;
import model.ProdutoFisico;
import repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ProdutoController implements ProdutoRepository {
    Scanner read = new Scanner(System.in);

    private List<Produto> produtos = new ArrayList<>();

    double peso;

    @Override
    public void create(String nome, BigDecimal preco, int estoque, int tipo) {
        boolean exists = produtos.stream()
                .anyMatch(produto -> Objects.equals(produto.getNome(), nome));

        if (!exists) {
            if (tipo == 1) {
                try {
                    System.out.println("Digite o peso do produto: ");
                    peso = read.nextDouble();
                    read.skip("\\R?");
                    System.out.println("Digite a dimensão do produto: ");
                    String dimensoes = read.nextLine();

                    produtos.add(new ProdutoFisico(nome, preco, estoque, peso, dimensoes));
                } catch (InputMismatchException e) {
                    System.out.println("Formato invalido");
                    read.nextLine();
                }
            } else {
                try {
                    System.out.println("Digite o tamanho do arquivo: ");
                    double tamanho = read.nextDouble();
                    read.skip("\\R?");
                    System.out.println("Digite o formato do produto: ");
                    String formato = read.nextLine();

                    produtos.add(new ProdutoDigital(nome, preco, estoque, tamanho, formato));
                } catch (InputMismatchException e) {
                    System.out.println("Formato invalido");
                    read.nextLine();
                }
            }
        }
    }

    @Override
    public void findAll() {
        System.out.println("Lista de produtos: ");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    @Override
    public void findByNome(String nome) {
        boolean exists = produtos.stream()
                .anyMatch(produto -> Objects.equals(produto.getNome(), nome) && produto.getEstoque() > 0);

        if (exists) {
            produtos.stream().filter(produto -> Objects.equals(produto.getNome(), nome)).forEach(System.out::println);
        } else {
            System.out.println("Não existe produto com esse nome");
        }
    }

    @Override
    public void update(String nome, BigDecimal preco, int estoque, int tipo) {
        boolean exists = produtos.stream()
                .anyMatch(produto -> Objects.equals(produto.getNome(), nome) && produto.getEstoque() > 0);

        if (exists) {
            if (tipo == 1) {
                try {
                    System.out.println("Digite o peso do produto: ");
                    peso = read.nextDouble();
                    read.skip("\\R?");
                    System.out.println("Digite o peso do produto: ");
                    String dimensoes = read.nextLine();

                    produtos = produtos.stream().filter(produto -> !Objects.equals(produto.getNome(), nome)).collect(Collectors.toList());
                    ProdutoFisico produtoFisico = new ProdutoFisico(nome, preco, estoque, peso, dimensoes);
                    System.out.println(produtoFisico);
                    produtos.add(produtoFisico);
                } catch (InputMismatchException e) {
                    System.out.println("Formato invalido");
                    read.nextLine();
                }
            } else {
                try {
                    System.out.println("Digite o tamanho do arquivo: ");
                    double tamanho = read.nextDouble();
                    read.skip("\\R?");
                    System.out.println("Digite o formato do produto: ");
                    String formato = read.nextLine();

                    produtos = produtos.stream().filter(produto -> !Objects.equals(produto.getNome(), nome)).collect(Collectors.toList());
                    ProdutoDigital produtoDigital = new ProdutoDigital(nome, preco, estoque, tamanho, formato);
                    System.out.println(produtoDigital);
                    produtos.add(produtoDigital);
                } catch (InputMismatchException e) {
                    System.out.println("Formato invalido");
                    read.nextLine();
                }
            }
        } else
            System.out.println("Não existe produto com esse nome");

    }

    @Override
    public void delete(String nome) {
        produtos = produtos.stream().filter(produto -> !Objects.equals(produto.getNome(), nome)).collect(Collectors.toList());

        System.out.println("Produto: " + nome + " foi deletado!");
    }

    @Override
    public void buyItens(String nome) {
        boolean exists = produtos.stream()
                .anyMatch(produto -> Objects.equals(produto.getNome(), nome) && produto.getEstoque() > 0);

        if (exists) {
            produtos.stream().filter(produto -> Objects.equals(produto.getNome(), nome)).forEach(Produto::comprar);

            produtos.stream().filter(produto -> Objects.equals(produto.getNome(), nome)).forEach(produto -> System.out.println("Produto: " + produto.getNome() + " comprado com sucesso!"));
        } else
            System.out.println("Não existe produto com esse nome");
    }

    @Override
    public void refund(String nome) {
        boolean exists = produtos.stream()
                .anyMatch(produto -> Objects.equals(produto.getNome(), nome));

        if (exists) {
            produtos.stream().filter(produto -> Objects.equals(produto.getNome(), nome)).forEach(Produto::devolver);

            produtos.stream().filter(produto -> Objects.equals(produto.getNome(), nome)).forEach(produto -> System.out.println("Produto: " + produto.getNome() + " devolvido com sucesso!"));
        } else
            System.out.println("Não existe produto com esse nome");
    }
}
