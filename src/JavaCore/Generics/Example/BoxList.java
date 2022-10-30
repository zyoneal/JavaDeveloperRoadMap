package JavaCore.Generics.Example;

import java.util.List;

public interface BoxList<E, T> extends List<E> {

    T calcSum(E element, T element2);

}
