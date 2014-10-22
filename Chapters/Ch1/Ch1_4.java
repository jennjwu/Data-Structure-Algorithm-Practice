
package ch1;

public class Ch1_4 {
    public static void main(String[] args) {
        String test = "test one two three";
        System.out.println(test);
        replaceSpaces(test.toCharArray(), test.length());
        //System.out.println(test);
        
    }
    
    public static void replaceSpaces(char[] str, int length) {
        int spaceCount = 0;
        int newLength, i;
        
        for (i = 0; i < length; i++) {
            if (str[i] == ' '){
                spaceCount++;
            }
        }
        
        newLength = length + spaceCount *2;//replace one space with 2 char
        //calculates new length by adding additional spaces needed w/ replacement
        char[] str2 = new char[newLength];
//        str[newLength] = '\0';
        for (i = length-1; i >= 0; i--) {
            if (str[i] == ' ') {
                str2[newLength-1] = '0';
                str2[newLength-2] = '2';
                str2[newLength-3] = '%';
                newLength -= 3;
            }
            else {
                str2[newLength-1]=str[i];
                newLength--;
            }
        }
        
        System.out.println(str2);
        
    }
    
}
