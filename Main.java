package converter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int rad = 0;
        String str;
        int newRad = 0;
        if (scanner.hasNextInt()) {
            rad = scanner.nextInt();
        }
        str = scanner.next();
        if (scanner.hasNextInt()) {
            newRad = scanner.nextInt();
        }
        if (rad > 36 || rad < 1 || newRad > 36 || newRad <1) {
            System.out.println("error");
        } else {
            System.out.println(new CoderAlg().method(rad, str, newRad));
        }
        scanner.close();
    }
}