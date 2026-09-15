class Solution {

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        int[] map = new int[128];

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int l = 0;
        int count = t.length();

        int min = Integer.MAX_VALUE;
        int start = 0;

        for (int r = 0; r < s.length(); r++) {

            char c = s.charAt(r);

            if (map[c] > 0) {
                count--;
            }

            map[c]--;

            while (count == 0) {

                if (r - l + 1 < min) {
                    min = r - l + 1;
                    start = l;
                }

                char left = s.charAt(l);

                map[left]++;

                if (map[left] > 0) {
                    count++;
                }

                l++;
            }
        }

        return min == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + min);
    }
}