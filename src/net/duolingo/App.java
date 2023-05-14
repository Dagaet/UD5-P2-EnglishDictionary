import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import dictionary.Dictionary;

public class App {
    private static final Scanner KEYBOARD = new Scanner(System.in); 

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
        Integer option = -1;
        while (option != 6) {
            System.out.println(showMenu());
            option = KEYBOARD.nextInt();
            KEYBOARD.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Write a word to add it to the dictionary: ");
                    String addedWord = KEYBOARD.nextLine().trim();
                    dictionary.insertWord(addedWord);
                    break;
                case 2:
                    System.out.println("Write a word to erase it: ");
                    String erasedWord = KEYBOARD.nextLine().trim();
                    dictionary.eraseWord(erasedWord);
                    break;
                case 3:
                    System.out.println("Write a word to find it: ");
                    String searchWord = KEYBOARD.nextLine().trim();
                    dictionary.existWord(searchWord);
                    break;
                case 4:
                    dictionary.wordsAvailable();
                    break;
                case 5:
                    System.out.println("Write a word inicial to see the words on it's index: ");
                    String searchLetter = KEYBOARD.nextLine().trim();
                    dictionary.searchByLetter(searchLetter);
                    break;
                case 6:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Select one please.");
                    break;
            }
        }
        KEYBOARD.close();
    }
}
