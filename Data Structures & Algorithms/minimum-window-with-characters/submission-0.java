class Solution {

    static boolean isValid(int[] tMap, int[] windowMap) {
        for (int i = 0; i < tMap.length; i++) {
            if (tMap[i] > 0) {
                if (windowMap[i] < tMap[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        int[] tMap = new int[128];
        int[] windowMap = new int[128];

        for (int i = 0; i < t.length(); i++) {
            tMap[t.charAt(i)]++;
        }

        int l = 0;
        int min = Integer.MAX_VALUE;
        String ans = "";

        for (int r = 0; r < s.length(); r++) {

            // Expand window
            windowMap[s.charAt(r)]++;

            // Shrink window while valid
            while (isValid(tMap, windowMap)) {

                if (r - l + 1 < min) {
                    min = r - l + 1;
                    ans = s.substring(l, r + 1);
                }

                // Remove left character
                windowMap[s.charAt(l)]--;
                l++;
            }
        }

        return ans;
    }
}