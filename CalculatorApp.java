import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {

        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\nScientific Calculator");
            System.out.println("1 Square Root");
            System.out.println("2 Factorial");
            System.out.println("3 Natural Log");
            System.out.println("4 Power");
            System.out.println("5 Exit");

            int choice = sc.nextInt();

            if(choice == 1){
                System.out.print("Enter number: ");
                double x = sc.nextDouble();
                System.out.println(calc.squareRoot(x));
            }

            else if(choice == 2){
                System.out.print("Enter number: ");
                int x = sc.nextInt();
                System.out.println(calc.factorial(x));
            }

            else if(choice == 3){
                System.out.print("Enter number: ");
                double x = sc.nextDouble();
                System.out.println(calc.naturalLog(x));
            }

            else if(choice == 4){
                System.out.print("Enter base: ");
                double x = sc.nextDouble();
                System.out.print("Enter exponent: ");
                double y = sc.nextDouble();
                System.out.println(calc.power(x,y));
            }

            else if(choice == 5){
                break;
            }
        }
    }
}
