package calculator;

public class Calculator {

    private int a = 12; // Do not use public modifier, use getters and setters as below
    private int b = 2; // Do not use public modifier, use getters and setters as below
    private int c = 2; // Do not use public modifier, use getters and setters as below

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public static int add(int x, int y) {
        int sum = x + y;
        return sum;
    }

    public int subtract(int x, int y) {
        int odds = x - y;
        return odds;
    }

    public int multiply(int x, int y) {
        int product = x * y;
        return product;
    }

    public int divide(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        } else {
            int quotient = x / y;
            return quotient;
        }
    }
}
