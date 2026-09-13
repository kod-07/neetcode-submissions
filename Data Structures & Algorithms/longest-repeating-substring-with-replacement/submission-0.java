class Solution {

    public int findMaxValue(int[] map) {
        int max = 0;

        for (int i : map) {
            max = Math.max(max, i);
        }

        return max;
    }

    public int characterReplacement(String s, int k) {

        int r = 0, l = 0;
        int[] map = new int[26];
        int maxLength = 0;

        for (r = 0; r < s.length(); r++) {

            char c = s.charAt(r);
            map[c - 'A']++;

            while ((r - l + 1) - findMaxValue(map) > k) {

                map[s.charAt(l) - 'A']--;
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
}