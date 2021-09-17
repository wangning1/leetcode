        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int[] frontNums = new int[nums.length];
        Arrays.fill(frontNums, 1);
        int[] backNums = new int[nums.length];
        Arrays.fill(backNums, 1);
        frontNums[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            frontNums[i] = nums[i] * frontNums[i - 1];
        }
        backNums[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            backNums[i] = nums[i] * backNums[i + 1];
        }

        int[] res = new int[nums.length];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = frontNums[i - 1] * backNums[i + 1];
        }
        res[0] = backNums[1];
        res[nums.length - 1] = frontNums[nums.length - 2];
        return res;
