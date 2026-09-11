class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        right[n - 1] = height[n - 1];

        // Maximum height to the left of each position
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        // Maximum height to the right of each position
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        int volume = 0;

        for (int i = 1; i < n - 1; i++) {
            int currentVolume =
                Math.min(left[i], right[i]) - height[i];

            volume += currentVolume;
        }

        return volume;
    }
}