package blackjack;

import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {
        
        Deck myHand = new Deck();
        myHand.createDeck();
        //myHand.printDeck();
        myHand.shuffleDeck();
        //myHand.printDeck();
        
        System.out.print("Welcome to Blackjack. ");
        int input = 0;
        Scanner in = new Scanner(System.in);
        int choice;
        while (input != 3){
            System.out.println("What would you like to do?");
            System.out.println("1 - Hit Me");
            System.out.println("2 - Stay");
            System.out.println("3 - End");
            choice = in.nextInt();
            
            boolean play = true;
            
            switch(choice){
                case 1:
                    myHand.hitMe();
                    break;
                case 2:
                    myHand.stay();
                    break;
                case 3:
                    play = false;
                    return;
            }
        }
        
    }
    
    
}
