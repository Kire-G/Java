import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentInfoScanner {
private static final Pattern pattern1 = Pattern.compile("[А-Яа-я+]");
private static final Pattern pattern2 = Pattern.compile("[0-9]{9}");

    static String scanStudentInfo(Scanner sc) {
        String name;
        String fac_num;
        String result;

        Matcher matcher1;
        Matcher matcher2;
        do {
            System.out.println("Enter name: ");
            name = sc.next();
            System.out.println("Enter fac number");
            fac_num = sc.next();
            matcher1 = pattern1.matcher(name);
            matcher2 = pattern2.matcher(fac_num);
            result = "Hello, my name is: " + name + ". My faculty number is:" + fac_num+ ".";

        } while (matcher1.matches() == false && matcher2.matches() == false);
        return result;
    }
}
