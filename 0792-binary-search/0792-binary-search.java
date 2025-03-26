public class Solution {
    public static int search(int[] nums, int target) {
        for (int low = 0, high = nums.length - 1; low <= high; ) {
            int mid = (low + high) / 2;
            
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
