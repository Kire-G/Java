import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        printIntroduction();
        Scanner sc = new Scanner(System.in);
        double getbmi = getBMI(sc);
        System.out.println("Get bmi = " + getbmi);
        double bmifor = bmiFor(176.4, 70.8661);
        System.out.println("Bmi for = " + bmifor);
        String status = getStatus(bmifor);
        System.out.println("Status - " + status);
        reportResults(4, getbmi, "Ok");
    }

    public static double getBMI(Scanner sc){
        //Scanner sc = new Scanner(System.in);

        System.out.print("Enter weight in lbs:");
        double weight = sc.nextDouble();
        System.out.print("Enter height is inches:");
        double height = sc.nextDouble();

        weight /= 2.2046;
        height /= 0.3937;

        return weight*703/(height*height);
    }

    public static double bmiFor(double weight, double height){
        return weight*703/(height*height);
    }
    public static String getStatus (double num){

        if(num < 18.5){
            return "underweight";
        }

        else if(num >=18.5 && num < 25){
            return "normal";
        }

        else if(num >=25 && num < 30){
            return "overweight";
        }

        else if(num > 30) {
            return "obese";
        }
        else
            return "ERROR";
    }
    public static void reportResults(int resultnum, double bmi, String status){
        System.out.printf("The person with ID: %d , has BMI = %.2f (status: %s)\n", resultnum, bmi, status);
    }
    public static void printIntroduction(){
        System.out.println("Welcome to BMI Calculator!");
    }

}