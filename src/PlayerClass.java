import java.util.ArrayList;
import java.util.List;

public class PlayerClass {


    List<CardClass> handCard;
    int point;
    PlayerClass(DeckClass deck, int inisialPoint){
        handCard = new ArrayList<>(5);
        for(int i = 0;i<5;i++){
            handCard.add(deck.takeDeckCard());
        }
        this.point = inisialPoint;
    }

    public List<CardClass> getHandCard() {
        return handCard;
    }

    public int getPoint() {
        return point;
    }

    public void increasePoint(){
        point++;
    }

    public void handCardDrawn(DeckClass deckCard, int numberOfCardNeed){
        for(int i = 0;i<numberOfCardNeed;i++){
            CardClass deckC = deckCard.takeDeckCard();
            if(deckC!=null){
                handCard.add(deckC);
            }
            else {
                break;
            }
        }
    }

    public void handCardDiscard(CardClass card){
        handCard.remove(card);
    }
}
