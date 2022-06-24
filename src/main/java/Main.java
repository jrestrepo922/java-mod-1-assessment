import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // your code here
        notSoFunGame(0, 10);
    }

    private static void notSoFunGame(int lowerBound, int upperBound) {
        if (upperBound <= lowerBound) {
            System.out.println("Please provide a upperBound value greater than a lowerBound");
            return;
        }
        System.out.println("WELCOME TO A NOT SO FUN GAME WHERE YOU WILL BE COMPETING WITH A RANDOM NUMBER GENERATOR");
        System.out
                .println("===========================================================================================");
        try (Scanner scanner = new Scanner(System.in)) {

            // let user choose a level
            String[] difficultyStrings = {
                    "Easy: guess a number - program will tell you if it was higher or equal (you win) or lower (computer wins) than the program's number.",
                    "Medium: guess a number - program will tell you if it was strictly higher (you win) or lower or equal (computer wins) than the program's number.",
                    "Hard: guess a number - program will tell you if it was equal (you win) or not (you lose) to the program's number."
            };

            System.out.println("CHOOSE YOUR DIFFICULTY");
            System.out.println("=========================");
            System.out.println("Easy --> type 0");
            System.out.println("Medium --> type 1");
            System.out.println("Hard --> type 2");
            int usersInputDifficulty = scanner.nextInt();

            if (usersInputDifficulty == 0) {
                System.out.println(difficultyStrings[usersInputDifficulty]);
            } else if (usersInputDifficulty == 1) {
                System.out.println(difficultyStrings[usersInputDifficulty]);
            } else if (usersInputDifficulty == 2) {
                System.out.println(difficultyStrings[usersInputDifficulty]);
            } else {
                System.out.println("Please provide a number between 0 and 2");
                return;
            }
            System.out.println("=============================================================");

            // create random number and collect users input
            int randomInt = (int) Math.floor(Math.random() * (upperBound - lowerBound + 1) + lowerBound);
            System.out.println("Please provide a number from " + lowerBound + " to " + upperBound);
            int usersInputNum = scanner.nextInt();

            // checking users input for errors
            if (usersInputNum > upperBound || usersInputNum < lowerBound) {
                System.out.println("Please provide a number from " + lowerBound + " to " + upperBound);
                return;
            }

            // check to see who won(this depends on the difficulty level as well)
            System.out.println("User's Number: " + usersInputNum);
            System.out.println("Computer's Number: " + randomInt);
            if (usersInputDifficulty == 0) {
                if (usersInputNum >= randomInt) {
                    System.out.println("*****USER WON!!!*****");
                } else {
                    System.out.println("*****COPUTER WON!!*****");
                }
            } else if (usersInputDifficulty == 1) {
                if (usersInputNum > randomInt) {
                    System.out.println("*****USER WON!!!*****");
                } else {
                    System.out.println("*****COPUTER WON!!*****");
                }
            } else if (usersInputDifficulty == 2) {
                if (usersInputNum == randomInt) {
                    System.out.println("*****USER WON!!!*****");
                } else {
                    System.out.println("*****COPUTER WON!!*****");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Input must be a number");
        }
    }
}
