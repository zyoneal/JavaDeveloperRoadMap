package behavioral.chainOfResponsibility.ExampleCafe;

public abstract class WierdCafeVisitor {

    public WierdCafeVisitor cafeVisitor;

    public WierdCafeVisitor(WierdCafeVisitor cafeVisitor) {
        this.cafeVisitor = cafeVisitor;
    }

    public void handleFood(Food food) {
        if (cafeVisitor != null) {
            cafeVisitor.handleFood(food);
        }
    }

    public WierdCafeVisitor getCafeVisitor() {
        return cafeVisitor;
    }

    public void setCafeVisitor(WierdCafeVisitor cafeVisitor) {
        this.cafeVisitor = cafeVisitor;
    }
}
