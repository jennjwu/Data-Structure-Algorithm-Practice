class Solution {
	public boolean detectCapitalUse(String word) {
		char[] wordAsArr = word.toCharArray();

		if (wordAsArr.length == 1) {
			return true;
		} else {
			boolean capitalCase = false;
			
			// first and second character are both capital
			if (Character.isUpperCase(wordAsArr[0]) && Character.isUpperCase(wordAsArr[1])) {
				capitalCase = true;
			}

			for (int i = 1; i < wordAsArr.length; i++) {
				if (capitalCase && Character.isUpperCase(wordAsArr[i]) == true) {
					continue;
				} else if (!capitalCase && Character.isLowerCase(wordAsArr[i]) == true) {
					continue;
				} else {
					return false;
				}
			}

			return true;
		}
    }
}