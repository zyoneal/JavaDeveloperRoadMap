package JavaCore.DesignPatterns.behavioral.chainOfResponsibility.ExampleCafe;

public class GirlFriend extends WierdCafeVisitor {
    public GirlFriend(WierdCafeVisitor cafeVisitor) {
        super(cafeVisitor);
    }

    @Override
    public void handleFood(Food food) {
        if(food.name == "Cappuccino") {
            System.out.println("GirlFriend: My lovely cappuccino!!!");
        }
        super.handleFood(food);
    }
}
