package company.Google;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string],
 * where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there won't be input like 3a or 2[4].
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 */
public class LC_394 {
    public static void main(String[] args) {
        LC_394 test = new LC_394();
        String s = "3[a]2[bc]";
        System.out.println(test.decodeString(s));
        String a = "2[abc]3[cd]ef";
        System.out.println(test.decodeString(a));
        String b = "2[c]3[a2[d3[g]]]";
        System.out.println(test.decodeString(b));
    }
    public String decodeString(String s) {
        //create a stack to store all char
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            //push char into stack until
            //char is a ']'
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            }
            else {

                //when we meet a ']'
                //we start to decode the string
                List<Character> decodeString = new LinkedList<>();
                //get the encoded string
                while (stack.peek() != '[') {
                    decodeString.add(stack.pop());
                }

                //pop the '['
                stack.pop();

                //start to decode the k
                int base = 1;
                int k = 0;

                //note the corner case
                //the stack cannot be empty when process the last k in the stack
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }

                //push decodeString k times into stack
                //note the sequence is from the rear to head
                // 1[a2[bc]]
                // stack: | 1 [ a
                // decodeString: cbcb
                // push into stack: | 1 [ a b c b c
                while (k > 0) {
                    for (int j = decodeString.size() - 1; j >= 0; j--) {
                        stack.push(decodeString.get(j));
                    }
                    k--;
                }
            }
        }

        //pop the result
        char[] res = new char[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return new String(res);
    }
}

