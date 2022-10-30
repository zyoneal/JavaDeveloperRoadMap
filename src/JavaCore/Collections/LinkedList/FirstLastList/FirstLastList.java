package JavaCore.Collections.LinkedList.FirstLastList;

public class FirstLastList {

    private Link first;

    private Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    // Вставка элемента в начало списка
    public void insertFirst(long value) {
        Link newLink = new Link(value);
        if (isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;

    }

    // Вставка элемента в конец списка
    public void insertLast(long value) {
        Link newLink = new Link(value);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            last = newLink;
        }
    }

    // удаление первого элемента
    public void deleteFirst() {
        if (first.next == null)
            last = null;
        first = first.next;

    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first; // От начала списка
        while (current != null) // Перемещение до конца списка
        {
            current.displayLink(); // Вывод данных
            current = current.next; // Переход к следующему элементу
        }
        System.out.println("");
    }

}
