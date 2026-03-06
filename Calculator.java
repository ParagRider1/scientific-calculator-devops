public class Calculator {

    public double squareRoot(double x) {
        return Math.sqrt(x);
    }

    public int factorial(int n) {
        int result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public double naturalLog(double x) {
        return Math.log(x);
    }

    public double power(double x, double y) {
        return Math.pow(x, y);
    }
}
