import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @CreateDate: 2020/4/14 11:59
 * @Author: wangning
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<Set<Integer>> result = new ArrayList<>();
        Set<Integer> cols = new LinkedHashSet<>();
        Set<Integer> pies = new LinkedHashSet<>();
        Set<Integer> nas = new LinkedHashSet<>();
        dfs(0, n, cols, pies, nas, result);
        return generateRes(result, n);
    }

    private void dfs(int row, int n, Set<Integer> cols, Set<Integer> pies, Set<Integer> nas, List<Set<Integer>> result) {
        if (row >= n) {
            result.add(new LinkedHashSet<>(cols));
        }

        for (int i = 0; i < n; i++) {
            if (cols.contains(i) || pies.contains(i + row) || nas.contains(i - row)) {
                continue;
            }

            cols.add(i);
            pies.add(i + row);
            nas.add(i - row);

            dfs(row + 1, n, cols, pies, nas, result);

            cols.remove(i);
            pies.remove(i + row);
            nas.remove(i - row);
        }
    }

    private List<List<String>> generateRes(List<Set<Integer>> result, int n) {
        List<List<String>> resultList = new ArrayList<>();
        for (Set<Integer> integerSet : result) {
            List<String> queueStr = new ArrayList<>();
            Iterator<Integer> setIterator = integerSet.iterator();
            while (setIterator.hasNext()) {
                String str = "";
                int num = setIterator.next();
                for (int i = 0; i < n; i++) {
                    if (num == i) {
                        str += "Q";
                    } else {
                        str += ".";
                    }
                }
                queueStr.add(str);
            }
            resultList.add(queueStr);
        }
        System.out.println(resultList);
        return resultList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(4);
    }
}
