class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Step 1: Put all numbers into HashSet
        for (int n : nums) {
            set.add(n);
        }

        int max = 0;

        // Step 2: Check every number
        for (int n : set) {

            // n is the beginning of a sequence
            if (!set.contains(n - 1)) {

                int count = 1;
                int current = n;

                // Step 3: Keep looking for the next number
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                // Step 4: Update maximum
                max = Math.max(max, count);
            }
        }

        return max;
    }
}