package TentativasSolo;

public class MetodosCalculadora {

	/**
	 * Calcula a soma de dois números
	 * 
	 * @param num1 Primeiro número
	 * @param num2 Segundo número
	 * @return resultado da soma
	 */
    public double soma(double num1, double num2) {
        return num1 + num2;
    }

    /**
	 * Calcula a subtração de dois números
	 * 
	 * @param num1 Primeiro número
	 * @param num2 Segundo número
	 * @return resultado da subtração
	 */
    public double subtracao(double num1, double num2) {
        return num1 - num2;
    }

    /**
	 * Calcula a multiplicação de dois números
	 * 
	 * @param num1 Primeiro número
	 * @param num2 Segundo número
	 * @return resultado da soma
	 */
    public double multiplicacao(double num1, double num2) {
        return num1 * num2;
    }

    /**
     * Realiza a divisão de dois números.
     *
     * <p>Este método realiza a divisão do número fornecido pelo divisor.
     * Caso o divisor seja zero, lança uma exceção {@link ArithmeticException}.
     *
     * @param num1 o número que será dividido
     * @param num2 o divisor
     * @return o resultado da divisão
     * @throws ArithmeticException se o divisor for zero
     */
    public double divisao(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Você não pode dividir por zero!");
        }
        return num1 / num2;
    }

    /**
     * Acha o resto da divisão de dois números.
     *
     * <p>Este método calcula adivisão de dois números e guarda o resto como valor.
     * Caso o divisor seja zero, lança uma exceção {@link ArithmeticException}.
     *
     * @param num1 o número que será dividido
     * @param num2 o divisor
     * @return o resultado da divisão
     * @throws ArithmeticException se o divisor for zero
     */
    public  double resto(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Você não pode calcular o resto com divisor zero!");
        }
        return num1 % num2;
    }
}
