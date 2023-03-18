package Example;

public interface Priceable extends Deliverable, Orderable {

    default int calcPrice() {
        return calcOrderPrice() + calcDeliveryPrice();
    }

    static void doSmth() {
    }

}
