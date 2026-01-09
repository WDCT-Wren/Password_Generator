import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        String password = passwordBuilder(digit, hasLowerCase, hasNumbers, hasSpecialChars, hasUpperCase);

        System.out.println("Password generated: " + password);
        scanner.close();
    }

    public static String passwordBuilder(int digit, boolean hasLowerCase, boolean hasNumbers, boolean hasSpecialChars, boolean hasUpperCase) {
        String lowerCases = "abcdefghijklmnopqrstuvwxyz"; //String containing all possible lowercase characters
        String upperCases = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //String containing all possible uppercase characters
        String numericalChars = "0123456789"; //String containing all possible numerical values
        String specialChars = "!@#$%^&*:';_-"; //String containing commonly used special characters
        
        String password = "";
        boolean validPassword = false;
        while (!validPassword) {
            for (int i = 0; i < digit; i++) {
                int rand = (int)(4 * Math.random());

                switch (rand) {
                    case 0 -> { //number generation
                        if (hasNumbers){
                            rand = (int)(numericalChars.length()* Math.random());
                            password += String.valueOf(numericalChars.charAt(rand));
                        }
                        else {
                            digit++;
                        }
                    }
                    case 1 -> { //lowercase character generation
                        if (hasLowerCase) {
                            rand = (int)(lowerCases.length()* Math.random());
                            password += String.valueOf(lowerCases.charAt(rand));
                        }
                        else {
                            digit++;
                        }
                    }
                    case 2 -> { //uppercase character generation
                        if (hasUpperCase) {
                            rand = (int)(upperCases.length()* Math.random());
                            password += String.valueOf(upperCases.charAt(rand));
                        }
                        else {
                            digit++;
                        }
                    }
                    case 3 -> { //special character generation
                        if (hasSpecialChars) {
                            rand = (int)(specialChars.length()* Math.random());
                            password += String.valueOf(specialChars.charAt(rand));
                        }
                        else {
                            digit++;
                        }
                    }
                }
            }
            if (passwordValidator(password, hasLowerCase, hasNumbers, hasSpecialChars, hasUpperCase)) {
                return password;
            }
            else {
                password = "";
            }
        }
        return password;
    }

    public static boolean passwordValidator (String password, boolean hasLowerCase, boolean hasNumbers, boolean hasSpecialChars, boolean hasUpperCase) {
        while (true) {
            boolean hasNumber = password.matches(".*[0-9].*"); //Regex check if password contains a number
            boolean hasLower = password.matches(".*[a-z].*"); //Regex check if password contains a lowercase letter
            boolean hasCapital = password.matches(".*[A-Z].*"); //Regex check if password contains a capital letter
            boolean hasSpecialChar = password.matches(".*[!@#$%^&*:';_-].*"); //Regex check if password contains a special character

            if (hasLowerCase) {
                if (!hasLower) {return false;}
            }
            if (hasNumbers) {
                if (!hasNumber) {return false;}
            }
            if (hasUpperCase) {
                if (!hasCapital) {return false;}
            }
            if (hasSpecialChars) {
                if (!hasSpecialChar) {return false;}
            }
            return true;
        }
    } 
}