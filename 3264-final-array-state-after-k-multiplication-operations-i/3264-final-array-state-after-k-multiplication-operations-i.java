class Solution {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        for (int j = 0; j < k; j++) {
            // Find the index of the smallest element in the array
            int minIndex = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }

            // Multiply the smallest element by the multiplier
            nums[minIndex] *= multiplier;
        }

        return nums;
    }
}