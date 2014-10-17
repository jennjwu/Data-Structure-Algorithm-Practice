/*CC Ch1 1.1*/
package ch1;

public class Ch1_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        boolean value = isUniqueChar("Toooooomy");
        System.out.println(value);
        value = isUniqueChar("abc1832)5=/.,");
        System.out.println(value);
    }
    
    
    //ASCII has 256 unique characters
    //Unicode has ~107,000 characters
    
    public static boolean isUniqueChar(String str) {
        if (str.length() > 256 ) {
            return false;
        }
        
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) { //In char_set already (ie. in string)
                return false;
            }
            char_set[val] = true;
        }
        return true;
        
    }
    
    
    
}
