package Example;

public class MyBox<X> {
    // поля инициализировать только параметром который находися в классе.
    X hello;

    public <T> MyBox(T param) {
        System.out.println(param.getClass().getSimpleName());
    }

    public static <U> U returnValue (U param) {
        return param;
    }

}
