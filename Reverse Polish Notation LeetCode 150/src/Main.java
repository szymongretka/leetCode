import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int result = evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        System.out.println("Result: " + result);
    }

    static int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>(List.of(tokens));
        Deque<Integer> tempStack = new ArrayDeque<>(tokens.length);
        int result = 0;

        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        tempStack.add(Integer.valueOf(stack.pop()));

        while (!stack.isEmpty()) {
            if (isOperator(stack.peek())) {
                if (tempStack.size() == 1) {
                    result = calculate(result, tempStack.pop(), stack.pop());
                    tempStack.addFirst(result);
                } else {
                    result = calculate(tempStack.pop(), tempStack.pop(), stack.pop());
                    tempStack.addFirst(result);
                }
            } else {
                tempStack.addFirst(Integer.valueOf(stack.pop()));
            }
        }

        return result;
    }

    static private boolean isOperator(String c) {
        return "+-*/".contains(c);
    }

    static private int calculate(Integer num2, Integer num1, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> num1 / num2;
        };
    }

}