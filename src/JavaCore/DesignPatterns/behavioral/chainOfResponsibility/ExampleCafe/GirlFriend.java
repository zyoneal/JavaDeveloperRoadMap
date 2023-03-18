package behavioral.chainOfResponsibility.ExampleCafe;

import java.util.Objects;

public class GirlFriend extends WierdCafeVisitor {
    public GirlFriend(WierdCafeVisitor cafeVisitor) {
        super(cafeVisitor);
    }

    @Override
    public void handleFood(Food food) {
        if(Objects.equals(food.name, "Cappuccino")) {
            System.out.println("GirlFriend: My lovely cappuccino!!!");
        }
        super.handleFood(food);
    }
}
