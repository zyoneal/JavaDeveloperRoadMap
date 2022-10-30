package JavaCore.Collections.CardsExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsRunner {

    public static void main(String[] args) {
//        List<String> collors = new ArrayList<>();
//        collors.add("yellow");
//        collors.add("blue");
//        collors.add("green");
//        collors.add("black");
//        collors.add("red");
//        System.out.println("List before sorting " + collors);
//        Collections.sort(collors);
//        System.out.println("List after sorting " + collors);

        List<Card> deckOfCards = new ArrayList<>();
        for (Card.Face face : Card.Face.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                deckOfCards.add(new Card(suit, face));
            }
        }

        System.out.println("Original dec of cards: ");
        printOutput(deckOfCards);
        Collections.shuffle(deckOfCards);
        Collections.sort(deckOfCards);
        Card card = new Card(Card.Suit.SPADES, Card.Face.QUEEN);
        int i = Collections.binarySearch(deckOfCards, card);
        if (i >= 0) {
            System.out.println("Card was found at position " + i);
        } else System.out.println("Card was not found");


//        System.out.println("\n\nCards after shuffle");
//        printOutput(listOfCards);
//        Collections.sort(listOfCards);
//        System.out.println("\n\nCards after sort");
//        printOutput(listOfCards);
//        // ЧЕРЕЗ КОМПАРАТОР
//        Collections.sort(listOfCards,Collections.reverseOrder());
//        System.out.println("\n\nCards after sort reverse order");
//        printOutput(listOfCards);
//        Collections.sort(listOfCards,new CardComparator());
//        System.out.println("\n\nCards after card comparator");
//        printOutput(listOfCards);
    }

    private static void printOutput(List<Card> listOfCards) {
        for (int i = 0; i < listOfCards.size(); i++) {
            System.out.printf("%-20s %s", listOfCards.get(i), (i + 1) % 4 == 0 ? "\n" : " ");
        }
    }

}
