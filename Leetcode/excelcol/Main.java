package excelcol;

public class Main {

    public static void main(String[] args) {
        Excelcol test = new Excelcol();
        int a = 0;
        String[] tester = new String[]{"A", "Y", "AA", "BA", "CA", "BA", "AAA"};
        for (String i : tester){
            a = test.titleToNumber(i);
            System.out.println(i + " " + a);
        }
    }
}
