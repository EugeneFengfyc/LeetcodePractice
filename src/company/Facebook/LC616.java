package company.Facebook;
/*
You are given a string s and an array of strings words.
You should add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in words.
If two such substrings overlap, you should wrap them together with only one pair of closed bold-tag.
If two substrings wrapped by bold tags are consecutive, you should combine them.
Return s after adding the bold tags.

Input: s = "abcxyz123", words = ["abc","123"]
Output: "<b>abc</b>xyz<b>123</b>"

Input: s = "aaabbcc", words = ["aaa","aab","bc"]
Output: "<b>aaabbc</b>c"

Constraints:

1 <= s.length <= 1000
0 <= words.length <= 100
1 <= words[i].length <= 1000
s and words[i] consist of English letters and digits.
All the values of words are unique.
 */
public class LC616 {
    public static void main(String[] args) {
        LC616 test = new LC616();
        String s = "aaa123bbcc";
        String[] words = new String[] {"aaa", "aab", "bc", "123"};
        System.out.println(test.solution(s, words));
    }
    public String solution(String s, String[] words) {
        int boldUntil = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            for (String str : words) {
                if (s.startsWith(str, i)) {
                    if (i > boldUntil) {
                        sb.append("<b>");
                    }
                    boldUntil = Math.max(boldUntil, i + str.length());
                }
            }
            if (i == boldUntil) {
                sb.append("</b>");
            }
            sb.append(s.charAt(i));
            if (s.length() == boldUntil) {
                sb.append("</b>");
            }
        }
        return sb.toString();

    }
}
