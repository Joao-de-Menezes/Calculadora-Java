package TentativasSolo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		// objeto da classe que contem os métodos para que possam ser acessados
		MetodosCalculadora metodos = new MetodosCalculadora();

		// try-with-resources
		// Fecha o Scanner assim que finalizar o bloco try
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("CALCULADORA");

			// Solicita o primeiro número utilizando o método obterNumero
			double primeiroNumero = obterNumero("Digite o primeiro número: ", scanner);

			// Solicita opção de operação
			int opcao = obterOpcao(scanner);

			// Solicita o segundo número
			double segundoNumero = obterNumero("Digite o segundo número: ", scanner);

			// Calcula o resultando utilizando do método
			double resultado = calcularResultado(primeiroNumero, segundoNumero, opcao, metodos);

			System.out.println("Resultado: " + resultado);
		} catch (Exception e) {
			// Captura exceções gerais e imprime a mensagem de erro
			System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
		}
	}

	/**
	 * Utilizado sempre que for feita a solicitação de um número (doble) ao usuário
	 * 
	 * @param mensagem
	 * @param scanner
	 * @return
	 */
	private static double obterNumero(String mensagem, Scanner scanner) {
		// Loop infinito
		// Para quando um return for executado
		while (true) {
			try {
				System.out.print(mensagem);
				// Assim que a leitura for bem sucedida, tem-se o valor do return
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				// InputMismatchException é lançada caso o valor não corresponda a um número
				System.out.println("Entrada inválida. Por favor, digite um número.");
				scanner.nextLine(); // Limpar entrada
			}
		}
	}

	/**
	 * 
	 * @param scanner
	 * @return
	 */
	private static int obterOpcao(Scanner scanner) {
		while (true) {
			try {
				System.out.println("O que deseja fazer?\n");
				System.out.println("1. Somar\n2. Subtrair\n3. Multiplicar\n4. Dividir\n5. Resto da divisão");
				System.out.print("Escolha uma opção: ");

				// Condição para que o valor seja um numero de 1 a 5
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