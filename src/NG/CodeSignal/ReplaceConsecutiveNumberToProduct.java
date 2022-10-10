package NG.CodeSignal;

/**
 * 2 * @Author: Eugene Feng
 * 3 * @Date: 10/9/22 11:16 PM
 * 4
 */
public class ReplaceConsecutiveNumberToProduct {
    public static void main(String[] args) {
        System.out.println(Solution("33998662"));

    }

    //99988666 -> 271618
    //22433378 -> 44978 -> 8978
    //1
    //33998662 -> 6188122 -> 611614 -> 62614
    public static String Solution(String num) {
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        int amount = 1;
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(i) != num.charAt(i + 1)) {
                int cur = (num.charAt(i) - '0') * amount;
                sb.append(cur);
                amount = 1;
            }
            else {
                amount++;
                flag = false;
            }
        }
        int last = (num.charAt(num.length() - 1) - '0') * amount;
        sb.append(last);

        return flag == true? num : Solution(sb.toString());

    }
}
