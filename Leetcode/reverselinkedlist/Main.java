class Main {
	public static void main(String[] args){
		Solution s = new Solution();
		
		ListNode test = new ListNode(1);
		test.next = new ListNode(2);
		test.next.next = new ListNode(3);
		test.next.next.next = new ListNode(4);
		test.next.next.next.next = new ListNode(5);

		ListNode curr = test;
		while (curr != null) {
			System.out.println(curr.val);	
			curr = curr.next;
		}

		ListNode r = s.reverseList(test);
		curr = r;
		while (curr != null) {
			System.out.println(curr.val);	
			curr = curr.next;
		}
	}
}