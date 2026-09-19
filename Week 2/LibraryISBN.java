import java.util.Scanner;

public class Main {

    static String normalizeCode(String raw) {
        return raw.trim().toUpperCase();
    }

    static void validateAndFormat(String code) {

        if (code.length() != 10) {
            System.out.println("Invalid code");
            return;
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                System.out.println("Invalid code");
                return;
            }
        }

        // Check remaining characters are digits
        for (int i = 3; i < 10; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                System.out.println("Invalid code");
                return;
            }
        }

        String prefix = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        StringBuilder result = new StringBuilder();

        result.append("[")
              .append(prefix)
              .append("] YEAR: ")
              .append(year)
              .append(" | CATALOG: ")
              .append(catalog);

        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String raw = sc.nextLine();

        String code = normalizeCode(raw);

        validateAndFormat(code);
    }
}
