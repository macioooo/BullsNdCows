package bullscows;

import java.util.Scanner;
import java.util.Random;

public class SecretCode {
    public static int howLong;  //all variables needed in other classes or methods
    public static int possibleSymbols;

    public static String possibleSymbolsStr;
    public static String lengthStr;

    private static void setTheGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        lengthStr = scanner.nextLine(); // setting a length of the code
        ErrorHandling.ErrorCom(); //checking for errors
        howLong = Integer.parseInt(lengthStr); //conversion to int
        System.out.println("Input the number of possible symbols in the code:");
        possibleSymbolsStr = scanner.nextLine(); //just like in lengthStr
        ErrorHandling.ErrorCom();
        possibleSymbols = Integer.parseInt(possibleSymbolsStr);
        ErrorHandling.ErrorCom();
        secretPrep();
        System.out.println("Okay, let's start a game!");
    }

    public static String codeGenerator() {
        Random random = new Random();
        String secretCode = "";
        boolean stop = false;
        setTheGame();
        while (!stop) {
            for (int i = 0; i < howLong; i++) {
                if (possibleSymbols > 10) {         //creating a secret Code
                    int roulette = random.nextInt(2);
                    if (roulette == 0) {        //making roulette if the next character should be a letter or number
                        Character containerOfCharacter = (char) (random.nextInt(possibleSymbols - 11) + 'a');
                        if (!secretCode.contains(containerOfCharacter.toString())) {    //checking if the random char was already in code
                            secretCode += containerOfCharacter;
                        } else {    //else if player wants only numbers in the game
                            i--;
                        }
                    }
                }
                Integer container = random.nextInt(9);
                if (!secretCode.contains(container.toString())) {
                    secretCode += container;
                    break;
                } else {
                    i--;
                }
            }
            if (secretCode.length() == howLong) {       //code is prepared
                stop = true;
            }
        }
        return secretCode;
    }

    private static void secretPrep() { //preparing the length of a secret code and character range
        String stars = "";
        for (int i = 0; i < howLong; i++) {
            stars = stars + '*';
        }
        if (possibleSymbols > 10) {
            char symbol = (char) ((possibleSymbols - 11) + 'a');
            System.out.printf("The secret is prepared: %s (0-9, a-%c)\n", stars, symbol);
        } else {
            System.out.printf("The secret is prepared: %s (0-%d)\n", stars, possibleSymbols - 1);
        }
    }
}
