package com.java.test;

// list of letters
// set of words

import java.util.*;

// 'a', 'b', 't'
// ab, bt, at, ac
public class Hello {


    public static void main(String[] args) {
        List<Character> characterList = new LinkedList<>();
        characterList.add('a');
        characterList.add('b');
        characterList.add('c');


        List<String> words = Arrays.asList("ab", "bt", "at", "ac");

        checkPresence(words, characterList);
    }

    public static boolean checkPresence(List<String> words, List<Character> characterList) {

        Map<Character, Integer> charCountMapInputChars = new HashMap<>();

        //  for list
        for (Character ch : characterList) {

            if (!charCountMapInputChars.containsKey(ch)) {
                charCountMapInputChars.put(ch, 1);
            } else { // existing entry
                charCountMapInputChars.put(ch, charCountMapInputChars.get(ch) + 1);
            }
        }

        // for map
        for (String word : words) {
            Map<Character, Integer> charCountMap = new HashMap<>();

            for (int ch = 0; ch < word.length(); ch++) {
                if (!charCountMap.containsKey(ch)) {
                    charCountMap.put(word.charAt(ch), 1);
                } else { // existing entry
                    charCountMap.put(word.charAt(ch), charCountMap.get(ch) + 1);
                }
            }

            for (int ch = 0; ch < word.length(); ch++) {
                if (charCountMap.get(word.charAt(ch)) <= (charCountMapInputChars.get(word.charAt(ch)))) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
