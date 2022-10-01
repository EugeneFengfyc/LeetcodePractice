package NG.CodeSignal;

/**
 * 2 * @Author: Eugene Feng
 * 3 * @Date: 10/1/22 3:21 PM
 * 4
 */
public class camelCase {
    public static void main(String[] args) {
        camelCase test = new camelCase();
        System.out.println( test.solution("fasdf fasdf `fsda_sdfg` afsdf `some_function`"));

    }

    public String solution(String docstring) {
        String[] array = docstring.split(" ");
        for (int i = 0; i < array.length; i++) {
            String cur = array[i];
            if (cur.startsWith("`") && !Character.isUpperCase(cur.charAt(1))) {
                String str = cur.substring(1, cur.length() - 1);
                String res = '`' + snakeToCamel(str) + '`';
                array[i] = res;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : array) sb.append(s + " ");
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String snakeToCamel(String str)
    {

        // Capitalize first letter of string
        //str = str.substring(0, 1).toUpperCase() + str.substring(1);
        StringBuilder builder = new StringBuilder(str);

        for (int i = 0; i < builder.length(); i++) {

            // Check char is underscore
            if (builder.charAt(i) == '_') {

                builder.deleteCharAt(i);
                builder.replace(i, i + 1, String.valueOf(Character.toUpperCase(
                                        builder.charAt(i))));
            }
        }
        return builder.toString();
    }
}
