package bullscows;

import java.util.Scanner;

public class CowsNdBullsCounter {
    //variables needed in other classes as well
    public static String input;
    public static boolean wrongLength = false;

    public static void checkingCowsAndBulls(String secretCode) {
        Scanner scanner = new Scanner(System.in);
        int turn = 1;
        boolean guessed = false;
        while (!guessed) {                  //two whiles needed if someone made illegal move
            wrongLength = false;
            while (!wrongLength) {
                int bulls = 0;
                int cows = 0;
                System.out.printf("Turn %d:\n", turn);
                turn++;
                input = scanner.nextLine();
                ErrorHandling.ErrorCom();   //checking if input == length of the secret code
                if (wrongLength) break;
                for (int i = 0; i < secretCode.length(); i++) {         //checking if in the input there are any bulls or cows
                    if (secretCode.charAt(i) == input.charAt(i)) {
                        bulls++;
                    } else if (input.contains(String.valueOf(secretCode.charAt(i)))) {
                        cows++;
                    }
                }                                           //output of this
                if (cows == 0 && bulls == 0) {
                    System.out.println("Grade: None.");
                } else if (cows > 0 && bulls == 0) {
                    System.out.printf("Grade: %d cow(s)\n", cows);
                } else if (cows == 0 && bulls > 0) {
                    System.out.printf("Grade: %d bull(s)\n", bulls);
                } else {
                    System.out.printf("Grade %d bull(s) and %d cow(s)\n", bulls, cows);
                }
                if (bulls == secretCode.length()) {
                    System.out.println("Congratulations! You guessed the secret code.\n");
                    guessed = true;
                    wrongLength = true;
                }
            }
        }
    }
}
