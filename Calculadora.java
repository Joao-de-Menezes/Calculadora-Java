package TentativasSolo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        MetodosCalculadora metodos = new MetodosCalculadora();// objeto da classe que contem os métodos

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("CALCULADORA");
            
            double primeiroNumero = obterNumero("Digite o primeiro número: ", scanner);
            int opcao = obterOpcao(scanner);

            double segundoNumero = obterNumero("Digite o segundo número: ", scanner);

            double resultado = calcularResultado(primeiroNumero, segundoNumero, opcao, metodos);
            
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    private static double obterNumero(String mensagem, Scanner scanner) {
        while (true) {
            try {
                System.out.print(mensagem);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpar entrada
            }
        }
    }

    private static int obterOpcao(Scanner scanner) {
        while (true) {
            try {
                System.out.println("O que deseja fazer?\n");
                System.out.println("1. Somar\n2. Subtrair\n3. Multiplicar\n4. Dividir\n5. Resto da divisão");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                if (opcao >= 1 && opcao <= 5) {
                    return opcao;
                }
                System.out.println("Opção inválida. Escolha um número entre 1 e 5.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, escolha uma opção numérica.");
                scanner.nextLine(); // Limpar entrada
            }
        }
    }

    private static double calcularResultado(double num1, double num2, int opcao, MetodosCalculadora metodos) {
        switch (opcao) {
            case 1: // soma
                return metodos.soma(num1, num2);
            case 2: // subtração
                return metodos.subtracao(num1, num2);
            case 3: // multiplicação
                return metodos.multiplicacao(num1, num2);
            case 4: // divisão
                if (num2 == 0) {
                    throw new ArithmeticException("Divisão por zero não é permitida.");
                }
                return metodos.divisao(num1, num2);
            case 5: // resto da divisão
                return metodos.resto(num1, num2);
            default:
                throw new IllegalArgumentException("Opção inválida.");
        }
    }
}