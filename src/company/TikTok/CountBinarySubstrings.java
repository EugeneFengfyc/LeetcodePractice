package company.TikTok;

/*
This is LeetCode 696
 */

public class CountBinarySubstrings {
    public static void main(String[] args) {
        CountBinarySubstrings test = new CountBinarySubstrings();
        String s = "00110011";
        /*
        the string s could be grouped into groups
        {2, 2, 2, 2}
         */
        System.out.println(test.countBinarySubstrings(s));
    }

    public int countBinarySubstrings(String s) {
        //Convert consecutive elements into group
        int[] groups = new int[s.length()];

        //The number of groups
        int t = 0;

        //Preset the first group has at least 1 element
        groups[0] = 1;

        //Traverse all the elements and group them
        for (int i = 1; i < s.length(); i++) {
            /*
            If the current element does not match
            the previous one, it starts a new group
            of size 1. Or, the current group size plus
            one.
             */
            if(s.charAt(i-1) != s.charAt(i)) {
                groups[++t] = 1;
            }
            else {
                groups[t]++;
            }
        }

        int result = 0;

        for(int i = 1; i <= t; i++) {
            result += Math.min(groups[i-1], groups[i]);
        }
        return result;
    }
}
