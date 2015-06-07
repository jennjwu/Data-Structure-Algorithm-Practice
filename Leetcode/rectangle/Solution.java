package Leetcode.rectangle;

/**
 * Created by jennjwu on 6/7/15.
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A)*(D-B);
        int area2 = (G-E)*(H-F);
        int total_with_overlap = area1 + area2;

        int overlap_x = 0, overlap_y = 0, overlap = 0;

        //complete overlay
        if(A == E && B == F && C == G && D == H){
            return area1;
        }
        else if (E >= A && E <= C && G >= A && G <= C
                        && F >= B && F <= D && H >= B && H <= D){ //rect2 inside rect1
            return area1;
        }
        else if (A >= E && A <= G && C >= E && C <= G
                        && B >= F && B <= H && D >= F && D <= H){ //rect1 inside rect2
            return area2;
        }
        else{
            //for x-axis
            if(E >= A && E <= C && G >= A && G <= C){
                overlap_x = G - E;
            }
            else if (A >= E && A <= G && C >= E && C <= G){
                overlap_x = C - A;
            }
            else if ((E >= A && E <= C) || (C >= E && C <= G)){
                overlap_x = C - E;
            }
            else if ((A >= E && A <= G) || (G >= A && G <= C)){
                overlap_x = G - A;
            }

            //for y-axis
            if(F >= B && F <= D && H >= B && H <= D){
                overlap_y = H - F;
            }
            else if (B >= F && B <= H && D >= F && D <= H){
                overlap_y = D - B;
            }
            else if ((H >= B && H <= D) || (B >= F && B <= H)){
                overlap_y = H - B;
            }
            else if ((F >= B && F <= D) || (D >= F && D <= H)){
                //System.out.println("here");
                overlap_y = D - F;
            }

            //System.out.println("areas are: " + area1 + " " + area2);

            overlap = overlap_x * overlap_y;
            //System.out.println(overlap_x + " " + overlap_y);
            System.out.println("overlap is: " + overlap);
            return total_with_overlap - overlap;
        }
    }
}
