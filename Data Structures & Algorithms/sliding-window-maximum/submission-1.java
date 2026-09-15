class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        int l = 0;
        int r = 0;
        int idx = 0;

        while (r < n) {

            // Remove elements outside the window
            while (!dq.isEmpty() && dq.peekFirst() < l) {
                dq.pollFirst();
            }

            // Remove smaller elements from back
            while (!dq.isEmpty()
                    && nums[dq.peekLast()] <= nums[r]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(r);

            // Window size = r - l + 1
            if (r - l + 1 == k) {

                ans[idx++] = nums[dq.peekFirst()];

                l++;
            }

            r++;
        }

        return ans;
    }
}