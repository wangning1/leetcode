class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            Character c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()){
            Character d = s.charAt(right);
            right++;

            if(need.containsKey(d)){
                window.put(d, window.getOrDefault(d, 0 ) + 1);
                if(need.get(d).equals(window.get(d))){
                    valid++;
                }
            }


            while (valid == need.size()){
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                Character e = s.charAt(left);
                left++;

                if(need.containsKey(e)){
                    if(need.get(e).equals(window.get(e))){
                        valid--;
                    }
                    window.put(e, window.get(e) - 1);
                }
            }

        }

        System.out.println("start:" + start +",len:" + len);
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t));

    }
}
