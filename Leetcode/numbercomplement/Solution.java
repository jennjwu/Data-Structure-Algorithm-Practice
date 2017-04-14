class Solution {
	public int findComplement(int num) {
		System.out.println("num is " + num);
		String b = Integer.toBinaryString(num);
		System.out.println("binary is " + b);

		String bComp = "";
		for (int j = 0; j < b.length(); j++) {
			if (b.charAt(j) == "1".charAt(0)) {
				bComp += "0";
			} else {
				bComp += "1";
			}
		}
		System.out.println("binary complement is " + bComp);
		return Integer.parseInt(bComp, 2);
    }
}