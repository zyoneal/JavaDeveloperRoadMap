package behavioral.iterator;//Шаблон проектирования Итератор предоставляет универсальный последовательный доступ к элементам коллекции.
// Хорош в тех случаях, когда необходимо реализовать единый механизм перебора элементов коллекций,
// не зависящий от способа реализации ни одной из этих коллекций.

public class IteratorApp {

    public static void main(String[] args) {
        Tasks c = new Tasks();

        Iterator it = c.getIterator();

        while (it.hasNext()) {
            System.out.println((String) it.next());
        }
    }

}

interface Iterator {

    boolean hasNext();

    Object next();

}

interface Container {

    Iterator getIterator();

}

class Tasks implements Container {

    String[] tasks = {"Построить дом", "Родить сына", "Посадить дерево"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator {

        int index = 0;

        @Override
        public boolean hasNext() {
            if (index < tasks.length) return true;
            return false;
        }

        @Override
        public Object next() {
            return tasks[index++];
        }

    }

}

