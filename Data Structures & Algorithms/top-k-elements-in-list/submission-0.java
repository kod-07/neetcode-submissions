class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        List<Integer> ans = new ArrayList<>();

        HashMap<Integer, Integer> hm = new HashMap<>();

        // 1. Count frequency
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        // 2. Create buckets
        List<Integer>[] buckets = new List[nums.length + 1];

        // 3. Put numbers into their frequency bucket
        for (int num : hm.keySet()) {
            int frequency = hm.get(num);

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(num);
        }

        // 4. Traverse from highest frequency to lowest
        int count = 0;

        for (int i = buckets.length - 1; i >= 0 && count < k; i--) {

            if (buckets[i] != null) {

                for (int ele : buckets[i]) {

                    if (count < k) {
                        ans.add(ele);
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }

        // 5. Convert List<Integer> to int[]
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}