package company.TikTok;

/*
This is LeetCode 1048

You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter
 anywhere in wordA without changing the order of the other characters to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1,
where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on.
A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.
 */

import java.util.*;

public class LongestStringChain {
    public static void main(String[] args) {
        LongestStringChain test = new LongestStringChain();
        String[] words = new String[]{"a","b","ba","bca","bda","bdca"};
        System.out.println(test.longestStrChain(words));
    }

    public int longestStrChain(String[] words) {
        Map<String,Integer> memo = new HashMap<>();
        Set<String> example = new HashSet<>();
        //Add all elements in string array to the set
        Collections.addAll(example, words);
        int temp = 0;
        for(String s : example) {
            temp = Math.max(temp, dfs(example, memo, s));
        }
        return temp;

    }

    private int dfs (Set<String> words, Map<String, Integer> memo,
                    String currentWord) {
        //If currentWord has occurred before,
        //return will return its value.
        if (memo.containsKey(currentWord)) {
            return memo.get(currentWord);
        }

        //Initialize the maxLength
        //Create a StringBuilder to complete delete operation
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(currentWord);

        //Creating all possible strings taking out one character at
        //a time from currentWord
        for (int i = 0; i < currentWord.length(); i++) {
            String newWord = sb.deleteCharAt(i).toString();
            //If the new word is presented in the map,
            //we do dfs with this new word
            if (words.contains(newWord)) {
                int currentLength = 1 + dfs(words, memo, newWord);
                maxLength = Math.max(currentLength, maxLength);
            }
            //Here we recover the deleted char and
            //delete next char
            sb.insert(i, currentWord.charAt(i));
        }
        memo.put(currentWord, maxLength);

        return maxLength;
    }
}
