package Others.percentage;

import java.util.HashMap;

/**
 * Created by jennjwu on 11/6/15.
 */
public class Main {
    public static String getItem(HashMap<String, Double> input){
        Double prob = Math.random()*100;
        System.out.println(prob);

        Double p = 0.0;
        for(String key: input.keySet()) {
            p += input.get(key); //get probability of item
            if (prob <= p) {
                return key;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        HashMap magic = new HashMap();
        magic.put("Box", 25.0);
        magic.put("Sword", 25.0);
        magic.put("Potion", 30.0);
        magic.put("Knife", 20.0);

        String item = getItem(magic);
        System.out.println("Your item is " + item);

        HashMap items = new HashMap();
        items.put("hair dryer", 10.0);
        items.put("bag", 5.0);
        items.put("laptop", 15.0);
        items.put("clothes", 10.0);
        items.put("air", -5.0);
        items.put("textbook", 20.0);
        items.put("shoes", 15.0);
        items.put("blanket", 30.0);

        String home = getItem(items);
        System.out.println("You picked: " + home);
    }

}
