package company.TikTok;

public class MinStepsAnagram {
    public static void main(String[] args) {
        MinStepsAnagram test = new MinStepsAnagram();
        System.out.println(test.minSteps("bab","aba"));
    }
    public int minSteps(String s, String t) {
        int[] alpha = new int[26];
        //Traverse every char in string s
        //and calculate the occurrence number
        for(char c : s.toCharArray()) {
            alpha[c - 'a']++;
        }

        int res = 0;

        for(char c : t.toCharArray()) {
            if (alpha[c - 'a'] > 0) {
                //If char in string t find the same char,
                //it will offset its occurrence number
                alpha[c - 'a']--;
            }
            //If char in string t cannot find the same char,
            //the result plus one
            else if (alpha[c - 'a'] == 0) {
                res++;
            }
        }
        return res;
    }
}
