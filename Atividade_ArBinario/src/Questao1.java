import java.util.Stack;

public class Questao1 {

    // Função para verificar se um caractere é um operador
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Função para verificar a precedência dos operadores
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    // Função para converter uma expressão infix em posfix
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Remova o '(' da pilha
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    // Função para avaliar uma expressão posfix
    public static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                // Se for um operando, empilhe seu valor
                double value = obterValorDaVariavel(c); // Substitua por sua lógica de obtenção de valores
                stack.push(value);
            } else if (isOperator(c)) {
                // Se for um operador, desempilhe os operandos, aplique a operação e empilhe o resultado
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = applyOperator(c, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop(); // O resultado final deve estar no topo da pilha
    }

    // Função auxiliar para obter o valor de uma variável (substitua por sua lógica)
    private static double obterValorDaVariavel(char variable) {
        // Implemente sua lógica aqui (por exemplo, usando um mapa de variáveis)
        return 0.0; // Valor padrão
    }

    // Função auxiliar para aplicar uma operação
    private static double applyOperator(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("Divisão por zero!");
                }
            default:
                throw new IllegalArgumentException("Operador inválido: " + operator);
        }
    }

    public static void main(String[] args) {
        String infixExpression = "A / B + D * E - A";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Expressão Infix: " + infixExpression);
        System.out.println("Expressão Posfix: " + postfixExpression);

        double result = evaluatePostfix(postfixExpression);
        System.out.println("Resultado: " + result);
    }
}
