import java.util.Arrays;
import java.util.Random;

public class Solution {
    int[] numArr;

    public Solution(int[] nums) {
        numArr = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return numArr;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] cloneNums = numArr.clone();
        for (int i = cloneNums.length - 1; i >= 0; i--) {
            int randId = new Random().nextInt(i + 1);
            int tmp = cloneNums[i];
            cloneNums[i] = cloneNums[randId];
            cloneNums[randId] = tmp;
        }
        return cloneNums;
    }
}
