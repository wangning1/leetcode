import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description:
 * @CreateDate: 2020/4/4 21:26
 * @Author: wangning
 */
public class Solution {

    public static void main(String[] args) {
        String str = "([])}";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (map.containsValue(charArr[i])) {
                stack.push(charArr[i]);
            }
            if (map.containsKey(charArr[i])) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character left = stack.pop();
                if (!left.equals(map.get(charArr[i]))) {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
