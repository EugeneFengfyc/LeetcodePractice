package company.Google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of words where each word consists of lowercase English letters.
 *
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA
 * without changing the order of the other characters to make it equal to wordB.
 *
 * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1,
 * where word1 is a predecessor of word2, word2 is a predecessor of word3,
 * and so on. A single word is trivially a word chain with k == 1.
 *
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 *
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
 */
public class LC_1048 {
    public static void main(String[] args) {
        LC_1048 test = new LC_1048();
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println(test.longestStrChain(words));
    }

    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        // Sorting the list in terms of the word length.
        //O(NlogN)
        Arrays.sort(words, (a, b)-> a.length() - b.length());
        int maxSequence = 1;

        //Outer Loop: O(N)
        for (String word : words) {

            int curSequence = 1;

            //Inner Loop: O(L^2) because of deleteCharAt()
            for (int i = 0; i < word.length(); i++) {

                //// Find all possible predecessors for the current word by removing one letter at a time.
                StringBuilder temp = new StringBuilder(word);
                temp.deleteCharAt(i);
                String pre = temp.toString();
                int prevSequence = map.getOrDefault(pre, 0);
                curSequence = Math.max(curSequence, prevSequence + 1);

            }
            map.put(word, curSequence);
            maxSequence = Math.max(maxSequence, curSequence);
        }
        return maxSequence;
    }
}
