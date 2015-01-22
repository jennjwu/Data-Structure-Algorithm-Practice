package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    ArrayList<Card> deck;
    int currentBJ;
    
    public Deck() {
        deck = new ArrayList<>();
        currentBJ = 0;
    }
    
    public void createDeck(){ 
        int cardNo = 0;
        for (int i = 0; i < 4; i++) {
            int cardSuitNum = i % 4;
            String cardSuit = "";
            switch(cardSuitNum) {
                case 0:
                    cardSuit = "spade";
                    break;
                case 1:
                    cardSuit = "diamond";
                    break;
                case 2:
                    cardSuit = "hearts";
                    break;
                case 3:
                    cardSuit = "clubs";
                    break;
            }
            
            for (int j = 0; j < 13; j++){
                int cardVal = j % 13;
                Card newCard = new Card(cardVal,cardSuit);
                deck.add(newCard);
                cardNo++; //counter for cards
            }
        }
    }
    
    public void printDeck(){
        System.out.println("---deck---");
        for (Card s: deck){
            System.out.println(s.getCard());
        }
        System.out.println("----------");
    }
    
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }
    
    public void hitMe() {
        Random rand = new Random();
        int randInt = rand.nextInt(deck.size());
        Card cardGot = deck.get(randInt);
        currentBJ += cardGot.getDenom();
        System.out.println("Card: " + cardGot.getCard());
        System.out.println("BJ: " + currentBJ);
        deck.remove(cardGot);
        
        //System.out.println(deck.size());
        checkBJ();
        
        
    }
    
    public void stay(){
        System.out.println("BJ: " + currentBJ);
        checkBJ();
    }
    
    public void checkBJ() {
        if (currentBJ > 21) {
            System.out.println("Sorry, you lose");
            currentBJ = 0;
        }
        else {
            System.out.println("Let's see what the dealer has");
        }
    }
}
