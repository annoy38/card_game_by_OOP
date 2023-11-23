public class CardClass {


    private String cardType;
    private int cardValue;

    CardClass(String cardType, int cardValue){
        this.cardType = cardType;
        this.cardValue = cardValue;
    }

    public String getCardType() {
        return cardType;
    }

    public int getCardValue() {
        return cardValue;
    }
}
