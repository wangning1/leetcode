class Solution{
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String word = s.substring(j, i);
                if (wordDict.contains(word) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
