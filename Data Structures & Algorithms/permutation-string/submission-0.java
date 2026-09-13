class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1_L = s1.length();
        int s2_L = s2.length();
        if(s1_L > s2_L) return false;
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for(int i = 0 ; i < s1_L;i++){
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(map1,map2)) return true;
        int l = 0 , r = 0 ;
        for(r = s1_L ; r < s2_L ; r++){
            map2[s2.charAt(r) - 'a']++;
            map2[s2.charAt(l) - 'a']--;
            if(Arrays.equals(map1,map2)) return true;
            l++;
        }
        return false;
    }
}
