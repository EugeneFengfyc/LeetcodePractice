package Leetcode.BackTracking;

import java.util.LinkedList;
import java.util.List;

public class LC_17 {
    List<String> res = new LinkedList<>();
    public static void main(String[] args) {
        LC_17 test = new LC_17();
        String digits = "23";
        System.out.println(test.letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }

        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        //迭代处理
        backTracking(digits, numString, 0);

        return res;
    }

    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
    StringBuilder temp = new StringBuilder();

    //比如digits如果为"23",num 为0，则str表示2对应的 abc
    public void backTracking(String digits, String[] numString, int num) {

        //遍历全部一次记录一次得到的字符串
        if (num == digits.length()) {
            res.add(temp.toString());
            return;
        }

        //str 表示当前num对应的字符串
        String str = numString[digits.charAt(num) - '0'];

        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            //c
            backTracking(digits, numString, num + 1);
            //剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }

}

