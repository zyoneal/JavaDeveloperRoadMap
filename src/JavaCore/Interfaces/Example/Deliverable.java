package JavaCore.Interfaces.Example;

@FunctionalInterface // функциональный интерфейс (только один метод) не может быть использован в лямбда выражениях
public interface Deliverable {

    int calcDeliveryPrice();

}
