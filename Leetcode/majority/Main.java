package majority;

public class Main {

    public static void main(String[] args) {
        int[] intArr = new int[]{4,5,1,1,5,1,2,5,5,5,5,5,3,1,1,2,2};

        /*for (int i = 0; i < intArr.length; i++){
            System.out.println(intArr[i]);
        }*/

        Majority tester = new Majority();
        System.out.println(tester.majorityElement(intArr));



    }
}
