import model.ProdutoDigital;
import model.ProdutoFisico;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        //Testes
        ProdutoFisico fisico = new ProdutoFisico(1L, "sapato", new BigDecimal("150"), 10, 480, "40x40");
        System.out.println(fisico);
        System.out.println("Com desconto: " + fisico.calcularDesconto(15, 5));
        ProdutoDigital digital = new ProdutoDigital(1L, "God of War", new BigDecimal("300"), 15, 120, "exe");
        System.out.println(digital);
        System.out.println("Com desconto: " + digital.calcularDesconto(30, true));

        Scanner read = new Scanner(System.in);

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
            int opcao = read.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Sessão de criar produto!");

                    keyPress();
                }
                case 2 -> {
                    System.out.println("Sessão para encontrar um produto!");

                    keyPress();
                }
                case 3 -> {
                    System.out.println("Sessão para listar produtos!");

                    keyPress();
                }
                case 4 -> {
                    System.out.println("Sessão para atualizar produto!");

                    keyPress();
                }
                case 5 -> {
                    System.out.println("Sessão para deletar produto!");

                    keyPress();
                }
                case 6 -> {
                    System.out.println("Sessão para comprar um produto!");

                    keyPress();
                }
                case 7 -> {
                    System.out.println("Sessão para devolver produtos!");

                    keyPress();
                }
                case 8 -> {
                    System.out.println("Você saiu, obrigado!");
                    System.exit(0);
                }
                default -> System.out.println("Opção invalida");

            }
        } while (true);
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
