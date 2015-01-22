/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author jennjwu
 */
public class Card {
    private int denom;
    private String rank;
    
    public Card(int d, String r) {
        denom = d+1;
        rank = r; //bc modulus gives 0 - 12
    }
    
    public void setDenom(int d) {
        denom = d;
    }
    
    public int getDenom() {
        return denom;
    }
    
    public void setRank(String r) {
        rank = r;
    }
    
    public String getRank(){
        return rank;
    }
    
    public String getCard(){
        String desc;
        switch(denom){
            case 1:
                desc = "A";
                break;
            case 11:
                desc = "J";
                break;
            case 12:
                desc = "Q";
                break;
            case 13:
                desc = "K";
                break;
            default:
                desc = Integer.toString(denom);
        }
        return desc + " of " + rank;
    }
    
    
    
}
