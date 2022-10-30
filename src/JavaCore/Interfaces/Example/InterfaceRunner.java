package JavaCore.Interfaces.Example;

public class InterfaceRunner {

    public static void main(String[] args) {
        Priceable pizza = new Pizza("Neapoletana", 2, 20, Size.S);
        Priceable phone = new CellPhone("Motorolla", "XT132", 3, 100);
        Priceable fridge = new Fridge("LG", "E90", 1, 300);

        printDeliveryPrice(pizza);
        printDeliveryPrice(phone);
        printDeliveryPrice(fridge);

    }

    private static void printDeliveryPrice(Priceable priceable) {
        System.out.println("Delivery price " + priceable.calcDeliveryPrice());
        System.out.println("Order price " + priceable.calcOrderPrice());
        System.out.println("Price " + priceable.calcPrice());
    }

}
