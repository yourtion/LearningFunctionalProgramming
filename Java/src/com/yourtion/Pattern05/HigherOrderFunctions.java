package com.yourtion.Pattern05;

import java.util.*;

/**
 * Created by Yourtion on 11/10/2016.
 */
public class HigherOrderFunctions {

    public static Integer sumSequence(List<Integer> sequence) {
        Integer sum = 0;
        for (Integer num : sequence) {
            sum += num;
        }
        return sum;
    }


    public static List<String> prependHello(List<String> names) {
        List<String> prepended = new ArrayList<String>();
        for (String name : names) {
            prepended.add("Hello " + name);
        }
        return prepended;
    }


    public static Set<Character> vowelsInWord(String word) {

        Set<Character> vowelsInWord = new HashSet<Character>();

        for (Character character : word.toLowerCase().toCharArray()) {
            if (isVowel(character)) {
                vowelsInWord.add(character);
            }
        }

        return vowelsInWord;
    }

    private static Boolean isVowel(Character c){
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels.contains(c);
    }

    public void run() {
        System.out.println("vowelsInWord: " + vowelsInWord("Yourtion"));
        System.out.println();

        List<String> nameList =  Arrays.asList("Yourtion", "Sophia");
        System.out.println("person: " + nameList);
        System.out.println("prependHello: " + prependHello(nameList));
        System.out.println();

        List<Integer> sequence = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("sumSequence: " + sumSequence(sequence));
    }

}
