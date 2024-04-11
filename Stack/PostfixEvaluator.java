package Stack;

import java.util.Stack;

public class PostfixEvaluator {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split("\\s+"); // Split the expression by whitespace

        for (String token : tokens) {
            if (isInteger(token)) {
                stack.push(Integer.parseInt(token)); // Push operands onto the stack
            } else {
                // Token is an operator
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(token, operand1, operand2);
                stack.push(result); // Push the result back onto the stack
            }
        }

        return stack.pop(); // The final result is the only item left on the stack
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int performOperation(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String postfixExpr = "2 3 1 * + 9 -"; // Example postfix expression
        int result = evaluatePostfix(postfixExpr);
        System.out.println("Result of postfix expression '" + postfixExpr + "' is: " + result);
    }
}

