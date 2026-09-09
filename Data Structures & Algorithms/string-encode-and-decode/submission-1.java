class Solution {

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();

        for (String str : strs) {
            int size = str.length();

            s.append(size);
            s.append("!");
            s.append(str);
        }

        return s.toString();
    }

    public List<String> decode(String str) {

        List<String> ans = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            // Find the !
            int j = i;

            while (str.charAt(j) != '!') {
                j++;
            }

            // Get length
            int len = Integer.parseInt(str.substring(i, j));

            // Move after !
            j++;

            // Get the actual string
            String word = str.substring(j, j + len);

            ans.add(word);

            // Move to next encoded string
            i = j + len;
        }

        return ans;
    }
}