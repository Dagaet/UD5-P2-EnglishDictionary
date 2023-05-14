package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Dictionary {
    private final Scanner keyboard = new Scanner(System.in);

    private Map<String, Set<String>> dictionary = new HashMap<>();

    public void insertWord() {
        System.out.println("Write a word to add it to the dictionary: ");
        String addedWord = keyboard.nextLine().trim();
        String formatedWord = addedWord.substring(0, 1).toUpperCase() + addedWord.substring(1);
        String indexWord = addedWord.substring(0, 1).toLowerCase();

        if (dictionary.containsKey(indexWord)) {
            Set<String> tempSet = dictionary.get(indexWord);
            tempSet.add(formatedWord);
            dictionary.put(indexWord, tempSet);
        } else {
            Set<String> tempSet = new HashSet<>();
            tempSet.add(formatedWord);
            dictionary.put(indexWord, tempSet);
        }
        System.out.println("The word " + formatedWord + " has been added to the dictionary.");
    }

    public void eraseWord() {
        System.out.println("Write a word to erase it: ");
        String erasedWord = keyboard.nextLine().trim();
        String formatedErasedWord = erasedWord.substring(0, 1).toUpperCase() + erasedWord.substring(1);
        String indexWord = erasedWord.substring(0, 1).toLowerCase();

        if (dictionary.containsKey(indexWord)) {
            Set<String> tempSet = dictionary.get(indexWord);
            tempSet.remove(formatedErasedWord);
            dictionary.put(indexWord, tempSet);
            System.out.println("The word " + formatedErasedWord + " has been erased from the dictionary.");
        } else {
            System.out.println("The word doesn't exist in this dictionary.");
        }
    }

    public void existWord() {
        System.out.println("Write a word to find it: ");
        String searchWord = keyboard.nextLine().trim();
        String formatedSearchWord = searchWord.substring(0, 1).toUpperCase() + searchWord.substring(1);
        String indexWord = searchWord.substring(0, 1).toLowerCase();

        if (dictionary.containsKey(indexWord)) {
            Set<String> tempSet = dictionary.get(indexWord);
            tempSet.contains(formatedSearchWord);
            System.out.println("The word " + formatedSearchWord + " exists in this dictionary.");
        } else {
            System.out.println("The word doesn't exist in this dictionary.");
        }
    }

    public void wordsAvailable() {
        System.out.println("This are the available words: ");
        // dictionary.forEach((key, value) -> System.out.print("|" + key + "|"));
        System.out.println(dictionary.keySet());
    }

    public void searchByWord() {
        System.out.println("Write a word inicial to see the words on it's index: ");
        String searchWord = keyboard.nextLine().trim();

        if (dictionary.containsKey(searchWord) && searchWord.length() == 1) {
            Set<String> tempSet = dictionary.get(searchWord);
            System.out.println("The list of words is the following \n" + tempSet);
        } else {
            System.out.println("Either the word doesn't exist in this dictionary or you didn't write an initial.");
        }
    }
}