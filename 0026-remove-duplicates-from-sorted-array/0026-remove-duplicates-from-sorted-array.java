class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // Edge case: empty array

        int k = 1; // Pointer for the next unique element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // Check if it's a new unique element
                nums[k] = nums[i]; // Place unique element at position 'k'
                k++; // Move k to the next position
            }
        }
        return k; // Number of unique elements
    }
}
