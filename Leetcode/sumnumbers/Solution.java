class Solution {
	public int getSum(int a, int b) {
	    if (a == 0) {
	    	return b;
	    } else if (b == 0) {
	    	return a;
	    } else {
	    	// a XOR b
	    	int sum = a ^ b;
	    	int carry = (a & b) << 1;
	    	return getSum(sum, carry);
	    }
    }
}