package JavaCore.Generics;

public class Main {

    public static void main(String[] args) {
        ObjectHolder<String> stringHolder = new ObjectHolder<>("Hello");
        String obj = stringHolder.getObj();
    }

}
