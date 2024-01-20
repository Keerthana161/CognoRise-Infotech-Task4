package cogrise;

import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        String[] words = {"java", "hangman", "programming", "computer", "developer", "algorithm"};

        Random random = new Random();
        String selectedWord = words[random.nextInt(words.length)].toLowerCase();
        char[] guessedWord = new char[selectedWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int maxAttempts = 6;
        int incorrectGuesses = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word.");

        while (incorrectGuesses < maxAttempts) {
           
            System.out.println("Current word: " + new String(guessedWord));

           
            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            
            boolean letterGuessed = false;
            for (int i = 0; i < selectedWord.length(); i++) {
                if (selectedWord.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    letterGuessed = true;
                }
            }
 
            if (!letterGuessed) {
                incorrectGuesses++;
                displayHangman(incorrectGuesses);
            }

             
            if (new String(guessedWord).equals(selectedWord)) {
                System.out.println("Congratulations! You guessed the word: " + selectedWord);
                break;
            }
        }

         
        if (incorrectGuesses == maxAttempts) {
            System.out.println("Sorry, you ran out of attempts. The correct word was: " + selectedWord);
        }

       
        scanner.close();
    }

    private static void displayHangman(int incorrectGuesses) {
        switch (incorrectGuesses) {
            case 1:
                System.out.println("   ____\n  |    |\n  |    O\n  |\n  |\n__|__");
                break;
            case 2:
                System.out.println("   ____\n  |    |\n  |    O\n  |    |\n  |\n__|__");
                break;
            case 3:
                System.out.println("   ____\n  |    |\n  |    O\n  |   /|\n  |\n__|__");
                break;
            case 4:
                System.out.println("   ____\n  |    |\n  |    O\n  |   /|\\\n  |\n__|__");
                break;
            case 5:
                System.out.println("   ____\n  |    |\n  |    O\n  |   /|\\\n  |   /\n__|__");
                break;
            case 6:
                System.out.println("   ____\n  |    |\n  |    O\n  |   /|\\\n  |   / \\\n__|__");
                break;
        }
    }
}

