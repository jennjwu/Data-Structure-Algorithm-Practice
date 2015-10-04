package Leetcode.anagram;

/**
 * Created by jennjwu on 10/4/15.
 */
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isAnagram("test", "ttes"));

        System.out.println(s.isAnagram("test", "ts"));

        System.out.println(s.isAnagram("test", "ttest"));

        System.out.println(s.isAnagram("test", "eess"));

        System.out.println(s.isAnagram("anagram","nagaram"));

        System.out.println(s.isAnagram("car","rat"));
    }
}
