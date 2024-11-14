import controller.ProdutoController;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static Scanner read = new Scanner(System.in);
    static ProdutoController produtoController = new ProdutoController();

    public static void main(String[] args) {
        int opcao = -1;
        do {
            System.out.println("""
                    *************************************************************************
                                    Loja Vítor tem tudo
                    
                               1 - Criar produto
                               2 - Encontrar um produto
                               3 - Listar produtos
                               4 - Atualizar produto
                               5 - Deletar produto
                               6 - Comprar produto
                               7 - Devolver produto
                               8 - Sair
                    
                    *************************************************************************
                    Digite a opção desejada:
                    """);
            try {
                opcao = read.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Formato invalido");
                read.nextLine();
            }

            read.skip("\\R?");

            switch (opcao) {
                case 1 -> {
                    System.out.println("Sessão de criar produto!");

                    createOrUpdate(true);
                    keyPress();
                }
                case 2 -> {
                    System.out.println("Sessão para encontrar um produto!");

                    System.out.println("Digite o nome do produto: ");
                    String nome = read.nextLine();

                    produtoController.findByNome(nome);
                    keyPress();
                }
                case 3 -> {
                    System.out.println("Sessão para listar produtos!");

                    produtoController.findAll();
                    keyPress();
                }
                case 4 -> {
                    System.out.println("Sessão para atualizar produto!");

                    createOrUpdate(false);
                    keyPress();
                }
                case 5 -> {
                    System.out.println("Sessão para deletar produto!");

                    System.out.println("Digite o nome do produto para deletar: ");
                    String nome = read.nextLine();

                    produtoController.delete(nome);
                    keyPress();
                }
                case 6 -> {
                    System.out.println("Sessão para buyItens um produto!");

                    System.out.println("Digite o nome do produto: ");
                    String nome = read.nextLine();

                    produtoController.buyItens(nome);
                    keyPress();
                }
                case 7 -> {
                    System.out.println("Sessão para refund produtos!");

                    System.out.println("Digite o nome do produto: ");
                    String nome = read.nextLine();

                    produtoController.refund(nome);
                    keyPress();
                }
                case 8 -> {
                    System.out.println("Você saiu, obrigado!");
                    System.out.println("Sistema criado por Vítor Cavalcante Souza");
                    System.exit(0);
                }
                default -> System.out.println("Opção invalida");

            }
        } while (true);
    }

    private static void createOrUpdate(boolean create) {
        int tipo, estoque;
        String nome;
        BigDecimal preco;

        System.out.println("Digite o nome do produto: ");
        nome = read.nextLine().toLowerCase();

        try {
            System.out.println("Digite o preco: ");
            preco = new BigDecimal(read.nextLine());
            System.out.println("Digite o estoque (Tem que ser maior que zero a quantidade de itens em estoque): ");
            estoque = read.nextInt();

            do {
                System.out.println("""
                        Digite o tipo do produto:
                            1 - Fisico
                            2 - Digital
                        """);
                tipo = read.nextInt();
            } while (tipo > 2 || tipo < 1);


            if (create) {
                produtoController.create(nome, preco, estoque, tipo);
            } else {
                produtoController.update(nome, preco, estoque, tipo);
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Formato invalido");
            read.nextLine();
        }


    }

    private static void keyPress() {
        try {
            System.out.println("\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}
