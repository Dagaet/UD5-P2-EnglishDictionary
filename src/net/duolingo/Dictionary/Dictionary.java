package Dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Dictionary {
    private final Scanner keyboard = new Scanner(System.in);

    private Map<String, Set<String>> Dictionary = new HashMap<>();

    public Dictionary() {}

    public Map<String, Set<String>> getDictionary() {
        return Dictionary;
    }

    public void setDictionary(Map<String, Set<String>> dictionary) {
        Dictionary = dictionary;
    }

    public void insertWord(){
        System.out.println("Write a word to add it to the dictionary: ");
        String addedWord = keyboard.nextLine();
        String formatedWord = addedWord.substring(0, 1).toUpperCase() + addedWord.substring(1);
        String indexWord = addedWord.substring(0, 1).toLowerCase();

        if (Dictionary.containsKey(indexWord)) {
            Set<String> tempSet = Dictionary.get(indexWord); 
            tempSet.add(formatedWord);
            Dictionary.put(indexWord, tempSet);
        } else {
            Set<String> tempSet = new HashSet<>(); 
            tempSet.add(formatedWord);
            Dictionary.put(indexWord, tempSet);
        }
        System.out.println("The word " + addedWord + " has been added to the dictionary.");
    }


}