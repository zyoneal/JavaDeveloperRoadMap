package JavaCore.DesignPatterns.behavioral.chainOfResponsibility.ExampleCafe;

import java.util.ArrayList;
import java.util.List;

public class BestFriend extends WierdCafeVisitor{

    public List<Food> coffeeContainingFood;
    public BestFriend(WierdCafeVisitor cafeVisitor) {
        super(cafeVisitor);
        coffeeContainingFood = new ArrayList<>();
    }

    @Override
    public void handleFood(Food food) {
        if (food.ingradients.contains("Meat")){
            System.out.println("it was tasty");
        }
        if (food.ingradients.contains("Coffee")) {
            System.out.println("fine");
        }
        super.handleFood(food);
    }

    public List<Food> getCoffeeContainingFood() {
        return coffeeContainingFood;
    }

    public void setCoffeeContainingFood(List<Food> coffeeContainingFood) {
        this.coffeeContainingFood = coffeeContainingFood;
    }
}
