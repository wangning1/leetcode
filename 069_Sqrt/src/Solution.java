/**
 * @authour winner
 * @Date 2020/4/15 22:31
 */
public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        double left = 0;
        double right = x;
        double middle = (left + right) / 2;
        while (left <= right) {
            if (middle == x / middle) {
                return (int)middle;
            } else if (middle > x / middle) {
                right = middle;
            } else {
                left = middle;
            }
            if(right - left < 0.01){
                return (int)middle;
            }
            middle = (left + right) / 2;
        }
        return (int)middle;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(9));
    }
}
