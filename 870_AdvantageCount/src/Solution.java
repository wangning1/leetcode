class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> {
                    return pair2[1] - pair1[1];
                }
        );
        for (int i = 0; i < nums2.length; i++){
            maxpq.offer(new int[]{i, nums2[i]});
        }

        Arrays.sort(nums1);
        int[] res = new int[nums2.length];

        int left = 0;
        int right = nums1.length - 1;
        while (!maxpq.isEmpty()){
            int[] pair = maxpq.poll();
            int nums2Index = pair[0];
            int nums2Val = pair[1];
            if(nums2Val < nums1[right]){
                res[nums2Index] = nums1[right];
                right--;
            }else {
                res[nums2Index] = nums1[left];
                left++;
            }
        }
        return res;

    }

}
