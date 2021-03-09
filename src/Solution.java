import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] str = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //1.先算出一共有几种
        int len = 1;
        for (int i = 0; i < digits.length(); i++) {
            int c = digits.charAt(i) - '0';
            len *= str[c].length();
        }

        //再用求余方法拿到每一种
        for (int i = 0; i < len; i++) {
            int last = i;
            StringBuilder sb = new StringBuilder();
            for (int j = digits.length() - 1; j >= 0; j--) {
                int c = digits.charAt(j) - '0';
                int pos = last % str[c].length();
                sb.append(str[c].charAt(pos));
                last = last / str[c].length();
            }
            result.add(sb.reverse().toString());
        }

        return result;
    }
}