package company.GoldmanSachs;

/*
wwwbb
 */
public class findWinner {
    public static void main(String[] args) {
        findWinner test = new findWinner();
        System.out.println(test.helper("wwwbbbbwww"));
        System.out.println(test.helper("wbbb"));
        System.out.println(test.helper("wwwwww"));
        System.out.println(test.helper("wwwbbb"));

    }

    public String helper(String s) {
        int wendy_moves = 0, bob_moves = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            int j = i, c = 0;
            while (j < n && s.charAt(i) == s.charAt(j)) {
                c++;
                j++;
            }
            if (c > 2) {
                if (s.charAt(i) == 'w') wendy_moves += c - 2;
                else bob_moves += c - 2;
            }
            i = j;
        }
        if (bob_moves >= wendy_moves) return "bob";
        else return "wendy";
    }
}

