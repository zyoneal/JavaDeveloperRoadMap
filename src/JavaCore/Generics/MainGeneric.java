public class MainGeneric {

    public static void main(String[] args) {
        ObjectHolder<String> stringHolder = new ObjectHolder<>("Hello");
        String obj = stringHolder.getObj();
    }

}
