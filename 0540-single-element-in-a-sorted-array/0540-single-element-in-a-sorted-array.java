class Solution {
    public int singleNonDuplicate(int[] nums) {
           int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Make sure mid is even
            if (mid % 2 == 1) {
                mid--;
            }

            // Compare pair: nums[mid] and nums[mid + 1]
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }

        // When low == high, we found the single element
        return nums[low];
    }
}