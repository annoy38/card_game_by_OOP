import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckClass {

    List<CardClass> deck;
    DeckClass(){
        deck = new ArrayList<>();
        for(int i = 1;i<=10;i++){
            this.deck.add(new CardClass("H", i));
        }
        for(int i = 5;i<=15;i++){
            this.deck.add(new CardClass("C", i));
        }
        for(int i = 10;i<=20;i++){
            this.deck.add(new CardClass("D", i));
        }
        Collections.shuffle(deck);
    }

    public CardClass takeDeckCard(){
        if(!deck.isEmpty()){
            return deck.remove(0);
        }
        return null;
    }
}
