import java.util.ArrayList;
import java.util.List;

/**
 * @authour winner
 * @Date 2020/4/13 21:44
 */
public class Solution {
    public  List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, n, result, "");
        return result;
    }

    public  void generate(int leftUsed, int rightUsed, int n, List<String> result, String str) {
        if (leftUsed == n && rightUsed == n) {
            result.add(str);
        }
        if (leftUsed < n) {
            generate(leftUsed + 1, rightUsed, n, result, str + "(");
        }
        if (rightUsed < leftUsed && rightUsed < n) {
            generate(leftUsed, rightUsed + 1, n, result, str + ")");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}
