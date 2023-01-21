import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Company company = new Company("Ivan", "14.02.2023", "1234567891");
        company.setID("opa");
        System.out.println("examp  " + company.getID());
        Firm_ET firm = new Firm_ET("Kiro", "12.10.2022", "45445");
        firm.setOwner("Kiro");
        firm.setID("mah");
        System.out.println("ppp  " + firm.getID());
        firm.setActual_capital(145.25);
        firm.setFirst_capital(100.05);
        double x = firm.calculation();
        System.out.println("Owner = " + firm.getOwner());
        System.out.println("Actual cap = " + firm.getActual_capital());
        System.out.println("Result = " + x);



    }
}


