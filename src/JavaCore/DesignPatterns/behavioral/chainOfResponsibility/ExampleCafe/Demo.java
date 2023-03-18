package JavaCore.DesignPatterns.behavioral.chainOfResponsibility.ExampleCafe;


import JavaCore.Collections.ArrayList.ArrayList;

public class Demo {

    public static void main(String[] args) {
        ArrayList<String> first = new ArrayList<>();
        first.add("Coffee");
        first.add("Milk");
        first.add("Sugar");
        ArrayList<String> second = new ArrayList<>();
        first.add("Coffee");
        first.add("Milk");
        ArrayList<String> third = new ArrayList<>();
        first.add("Meat");
        first.add("Water");
        first.add("Potato");
        ArrayList<String> fourth = new ArrayList<>();
        first.add("Water");
        first.add("Potato");
        ArrayList<String> five = new ArrayList<>();
        first.add("Meat");
        Food cappuccino1 = new Food("Cappuccino", first);
        Food cappuccino2 = new Food("Cappuccino", second);
        Food soup1 = new Food("Cappuccino", third);
        Food soup2 = new Food("Cappuccino", fourth);
        Food meat = new Food("Cappuccino", five);

        GirlFriend girlFriend = new GirlFriend(null);
        Me me = new Me(girlFriend);
        BestFriend bestFriend = new BestFriend(me);

        bestFriend.handleFood(cappuccino1);
        bestFriend.handleFood(cappuccino2);
        bestFriend.handleFood(soup1);
        bestFriend.handleFood(soup2);
        bestFriend.handleFood(meat);
    }
    
}
