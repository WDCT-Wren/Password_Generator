import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordBuilder passwordBuilder = new PasswordBuilder();
        System.out.print("Enter your desired password length>> ");
        int digit = scanner.nextInt();

        System.out.print("Will your desired password include lowercase characters?>> ");
        boolean hasLowerCase = scanner.nextBoolean();

        System.out.print("Will your desired password include uppercase characters?>> ");
        boolean hasUpperCase = scanner.nextBoolean();

        System.out.print("Will your desired password include numerical characters?>> ");
        boolean hasNumbers = scanner.nextBoolean();

        System.out.print("Will your desired password include special characters?>> ");
        boolean hasSpecialChars = scanner.nextBoolean();

        String password = passwordBuilder.passwordGenerator(digit, hasLowerCase, hasNumbers, hasSpecialChars, hasUpperCase);

        System.out.println("Password generated: " + password);
        scanner.close();
    }
}