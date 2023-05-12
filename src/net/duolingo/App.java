import java.util.Scanner;

import Dictionary.Dictionary;

public class App {

    public static String showMenu() {
        String msg = "=====================\n";
        msg += "Welcome to the Dictionary! \n";
        msg += "Select one of the options below:\n";
        msg += "1. Add a word\n";
        msg += "2. Delete a word\n";
        msg += "3. Check if a word exists\n";
        msg += "4. Check the initials available on the dictionary\n";
        msg += "5. See words by their initial.\n";
        msg += "6. Close the program.\n";
        msg += "=====================";
        return msg;
    }

    public static void main(String[] args) throws Exception {
        Dictionary dictionary = new Dictionary();
        Scanner keyboard = new Scanner(System.in);
        Integer option = -1;
        while (option != 6) {
            System.out.println(showMenu());
            option = keyboard.nextInt();
            switch (option) {
                case 1:
                    dictionary.insertWord();
                    break;
                case 2:
                    dictionary.eraseWord();
                    break;
                case 3:
                    dictionary.existWord();
                    break;
                case 4:
                    dictionary.wordsAvailable();
                    break;
                case 5:
                    dictionary.searchByWord();
                    break;
                case 6:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Select one please.");
                    break;
            }
        }
        keyboard.close();
    }
}
