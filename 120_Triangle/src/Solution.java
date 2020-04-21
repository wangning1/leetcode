import java.util.ArrayList;
import java.util.List;

/**
 * @authour winner
 * @Date 2020/4/21 22:16
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        if (row == 1) {
            return triangle.get(0).get(0);
        }
        int col = triangle.get(row - 1).size();
        int[][] dp = new int[row][col];
        List<Integer> lastRowList = triangle.get(row - 1);
        int colIdex = 0;
        //初始化dp最后一列
        for (Integer rowNum : lastRowList) {
            dp[row - 1][colIdex] = rowNum;
            colIdex++;
        }

        for (int i = row - 2; i >= 0; i--) {
            int j = 0;
            List<Integer> rowList = triangle.get(i);
            for (Integer rowNum : rowList) {
                dp[i][j] = (dp[i + 1][j] < dp[i + 1][j + 1] ? dp[i + 1][j] : dp[i + 1][j + 1]) + rowNum;
                j++;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        triangle.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        triangle.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        triangle.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list4);

        Solution solution = new Solution();
        System.out.println(solution.minimumTotal(triangle));
    }
}
