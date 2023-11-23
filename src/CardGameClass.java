import java.util.HashMap;
import java.util.Random;

public class CardGameClass {

    DeckClass deck;
    PlayerClass playerA;
    PlayerClass playerB;

    CardGameClass(){
        deck = new DeckClass();
        playerA = new PlayerClass(deck, 0);
        playerB = new PlayerClass(deck, 0);
    }


    public void gameStart(){
        System.out.println("Before game start number of Deck Card: "+deck.deck.size());
        int i = 1;
        while (playerA.handCard.size() == 5 && playerB.handCard.size() == 5){
            Random random = new Random();
//            if i odd number then A will choose otherwise B choose card
            if(i%2!=0){
                checkSumValue(playerA.handCard.get(random.nextInt(playerA.handCard.size())), playerB, playerA);
            }
            else {
                checkSumValue(playerB.handCard.get(random.nextInt(playerB.handCard.size())), playerA, playerB);
            }
            i++;
        }
//        Print All value After Game End
        System.out.println("After Game End Number of Deck Card: "+deck.deck.size());
        System.out.println("Number of Round: "+i);
        System.out.println("Player A number of Hand Card: "+playerA.handCard.size());
        System.out.println("Player B number of Hand Card: "+playerB.handCard.size());
        int playerAPoint = playerA.getPoint();
        int playerBPoint = playerB.getPoint();
        if(playerBPoint<playerAPoint){
            System.out.println("Winner is Player A point: "+playerAPoint);
            System.out.println("Player B point: "+playerBPoint);
        } else if (playerBPoint>playerAPoint) {
            System.out.println("Winner is Player B point: "+playerBPoint);
            System.out.println("Player A point: "+playerAPoint);
        }
        else {
            System.out.println("Match Tie");
        }
    }

    private void checkSumValue(CardClass firstPlayerChooseCard, PlayerClass secondPlayerCards, PlayerClass firstPlayerCards){
        HashMap<Integer, CardClass> map = new HashMap<>();
        //check if player A or B value is same two card sum of A or B
        for(int i = 0;i<secondPlayerCards.handCard.size();i++){
            CardClass opponentFirstCard = secondPlayerCards.handCard.get(i);
            if(map.containsKey(firstPlayerChooseCard.getCardValue()-opponentFirstCard.getCardValue())){
                CardClass opponentSecondCard = map.get(firstPlayerChooseCard.getCardValue()-opponentFirstCard.getCardValue());
                firstPlayerCards.increasePoint();
                firstPlayerCards.handCardDiscard(firstPlayerChooseCard);
                secondPlayerCards.handCardDiscard(opponentFirstCard);
                secondPlayerCards.handCardDiscard(opponentSecondCard);
                break;
            }
            else{
                map.put(secondPlayerCards.handCard.get(i).getCardValue(), secondPlayerCards.handCard.get(i));
            }
        }
//        if not same
        if(map.size()==5){
            secondPlayerCards.increasePoint();
            firstPlayerCards.handCardDiscard(firstPlayerChooseCard);
        }

//        drawback card from deck
        firstPlayerCards.handCardDrawn(deck, 5-firstPlayerCards.handCard.size());
        secondPlayerCards.handCardDrawn(deck, 5-secondPlayerCards.handCard.size());
    }
}
