package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary {

    private Map<String, Set<String>> dictionary = new HashMap<>();

    public void insertWord(String addedWord) {
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

    public void eraseWord(String erasedWord) {
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

    public void existWord(String searchWord) {
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

    public void searchByLetter(String searchLetter) {
        if (dictionary.containsKey(searchLetter) && searchLetter.length() == 1) {
            Set<String> tempSet = dictionary.get(searchLetter);
            System.out.println("The list of words is the following \n" + tempSet);
        } else {
            System.out.println("Either the word doesn't exist in this dictionary or you didn't write an initial.");
        }
    }
}