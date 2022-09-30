package NG.Cisco;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class decodeString {
    public static void main(String[] args) {
        decodeString test = new decodeString();
        String input = "(ab(d){3}){2}";
        System.out.println(test.solution(input));
    }
    public String solution(String s) {
        Stack<Character> stack = new Stack<>();
        //
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '}') {
                stack.add(s.charAt(i));
            }
            else {
                List<Character> decodeString = new LinkedList<>();
                //get K time;
                int base = 1;
                int k = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }
                //pop the ')' and '{'
                stack.pop();
                stack.pop();
                while (stack.peek() != '(') {
                    decodeString.add(stack.pop());
                }
                //pop the '('
                stack.pop();
                //decode
                while (k != 0) {
                    for (int j = decodeString.size() - 1; j >= 0; j--) {
                        stack.push(decodeString.get(j));
                    }
                    k--;
                }
            }
        }
        char[] res = new char[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return new String(res);


    }
}

