package majority;

import java.util.Arrays;

/**
 * Created by jennjwu on 3/6/15.
 */
public class Majority {
    public int majorityElement(int[] num) {
        Arrays.sort(num);
        int majority = num[0];
        int count = 1;
        for(int i = 1; i < num.length; i++){
            if(count == 0) {
                majority = num[i];
                count++;
            }
            else if(majority != num[i]){
                count--;
            }
            else {
                count++;
            }
        }
        return majority;
    }
}
