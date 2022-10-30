package JavaCore.Generics;

public class ObjectHolder <T>{

    private T obj;

    public ObjectHolder(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

}
