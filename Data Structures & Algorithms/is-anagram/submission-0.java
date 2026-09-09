class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] s1 = new int[128];
        int[] t1 = new int[128];
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            s1[a] ++;
            t1[b] ++;
        }
        return Arrays.equals(s1,t1);
    }
}
