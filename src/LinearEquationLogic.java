import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner scan;
    private LinearEquation obj;
    int x1;
    int x2;

    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        String again = "y";
        while (again.equals("y")) {
            userInput();
            getData();
            System.out.print("Would you like to enter another pair of coordinates? (y/n) ");
            again = scan.nextLine();
            System.out.println();
        }
        System.out.println("Thank you for using the slope calculator, goodbye!");
    }


    private int extractX(String p) {
        p = p.substring(1, p.indexOf(","));
        return Integer.parseInt(p);
    }
    private int extractY(String p) {
        p = p.substring(p.indexOf(",")+2, p.length()-1);
        return Integer.parseInt(p);
    }

    private void userInput() {
        System.out.print("Enter coordinate one: ");
        String c1 = scan.nextLine();
        System.out.print("Enter coordinate two: ");
        String c2 = scan.nextLine();
        x1 = extractX(c1);
        x2 = extractX(c2);
        obj = new LinearEquation(x1, extractY(c1), x2, extractY(c2));
        System.out.println();
    }

    private void getData() {
        if (x1 == x2) {
            System.out.println("These points are on the vertical line x = " + x1);
        } else {
            System.out.println(obj.lineInfo());
            System.out.print("\nEnter a value for x: ");
            double fx = scan.nextDouble();
            scan.nextLine();
            System.out.println("The point on the line is " + obj.coordinateForX(fx));

        }
        System.out.println();
    }
}
