package NG.CodeSignal;

public class Docstring {
    public static void main(String[] args) {
        String docstring = "Function `some_function` has two arguments `short_arg very_long_argument` The `very_long_argument` has `CONSTANT_VALUE OK`";
        System.out.println(new Docstring().solution(docstring));
    }

    private String solution(String docstring) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < docstring.length();) {
            char c = docstring.charAt(i);
            if (c != '`') {
                res.append(c);
                i++;
                continue;
            }

            res.append("`");

            int j = i + 1;
            StringBuilder sb = new StringBuilder();
            while (j < docstring.length() && docstring.charAt(j) != '`') {
                sb.append(docstring.charAt(j++));
            }

            i = j + 1;

            String s = sb.toString();
            String[] words = s.split(" ");
            sb.setLength(0);
            for (String word : words) {
                //constant
                if (word.toUpperCase().equals(word)) {
                    res.append(word).append(" ");
                    continue;
                }

                // to camel
                String[] parts = word.split("_");
                sb.append(parts[0]);
                for (int k = 1; k < parts.length; k++) {
                    String curr = parts[k];
                    sb.append(curr.substring(0, 1).toUpperCase()).append(curr.substring(1));
                }

                res.append(sb).append(" ");
                sb.setLength(0);
            }

            res.setLength(res.length() - 1);
            res.append("`");
        }

        return res.toString();
    }
}
