class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int maxLength = 0 ;
        int i = 0 , j = 0;
        for(int it = 0 ; it < map.length; it++) map[it] = -1;
        while(j < s.length()){
            char c = s.charAt(j);
            while(map[c] >= i && map[c] <=j){
                i++;
            }
            map[c] = j;
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }
}
