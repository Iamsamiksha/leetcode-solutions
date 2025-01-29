class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify list creation
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with carry from previous iteration
            
            if (l1 != null) {
                sum += l1.val; // Add l1 node value
                l1 = l1.next; // Move to the next node in l1
            }
            
            if (l2 != null) {
                sum += l2.val; // Add l2 node value
                l2 = l2.next; // Move to the next node in l2
            }
            
            carry = sum / 10; // Compute carry for next iteration
            current.next = new ListNode(sum % 10); // Create new node with sum's last digit
            current = current.next; // Move to the next node
        }

        return dummy.next; // Return the result list
    }
}
