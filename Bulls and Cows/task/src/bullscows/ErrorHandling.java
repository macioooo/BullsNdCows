package bullscows;

//This class is responsible for looking for an Errors in the program
public class ErrorHandling {
    public static void ErrorCom() {
        if (SecretCode.possibleSymbolsStr != null) {
            if (SecretCode.howLong > Integer.parseInt(SecretCode.possibleSymbolsStr)) {
                System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", SecretCode.howLong, SecretCode.possibleSymbols);
                Runtime.getRuntime().halt(0);
            } else if (SecretCode.possibleSymbols > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                Runtime.getRuntime().halt(0);
            } else if (SecretCode.howLong <= 0) {
                System.out.println("Error: length cannot be shorter than 1");
                Runtime.getRuntime().halt(0);
            } else if (Integer.parseInt(SecretCode.possibleSymbolsStr) <= 1) {
                System.out.println("Error: you can't generate less than 2 symbols");
                Runtime.getRuntime().halt(0);
            } else if (CowsNdBullsCounter.input != null && CowsNdBullsCounter.input.length() != SecretCode.howLong) {
                System.out.printf("Your secret code length is %d\n", SecretCode.howLong);
                CowsNdBullsCounter.wrongLength = true;
            }
            try {
                Integer.parseInt(SecretCode.possibleSymbolsStr);
            } catch (NumberFormatException e) {
                System.out.printf("Error: \"%s\" isn't a valid number", SecretCode.possibleSymbolsStr);
                Runtime.getRuntime().halt(0);
            }
        }
        try {
            Integer.parseInt(SecretCode.lengthStr);
        } catch (NumberFormatException e) {
            System.out.printf("Error: \"%s\" isn't a valid number", SecretCode.lengthStr);
            Runtime.getRuntime().halt(0);
        }
    }
}