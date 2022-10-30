package JavaCore.Collections.LinkedList.DoublyLinkedList;

public class DoublyLinkedList {

    private Link first;

    private Link last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long value) {
        Link newLink = new Link(value);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.prev = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long value) {
        Link newLink = new Link(value);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.prev = last;
        }
        last = newLink;
    }

    public boolean insertAfter(long key, long dd) {
        Link current = first;
        while (current.data != key) {
            current = current.next;
            if (current == null)
                return false;
        }
        Link newLink = new Link(dd);
        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.prev = newLink;
        }
        newLink.prev = current;
        current.next = newLink;
        return true;
    }

    public Link deleteFirst() {
        Link temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.prev = null;
        }
        first = first.next;
        return temp;
    }

    public Link deleteLast() {
        Link temp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.prev.next = null;
        }
        last = last.prev;
        return temp;
    }

    public Link deleteKey(long key) {
        Link current = first;
        while (current.data != key) {
            current = current.next;
            if (current == null)
                return null;
        }
        if (current == first)
            first = current.next;
        else

            current.prev.next = current.next;
        if (current == last)
            last = current.prev;
        else

            current.next.prev = current.prev;
        return current;
    }

    public void displayForward() {
        System.out.print("List (first-->last): ");
        Link current = first; // От начала списка
        while (current != null) // Перемещение до конца списка
        {
            current.displayLink(); // Вывод данных
            current = current.next; // Переход к следующему элементу
        }
        System.out.println("");
    }

    // -------------------------------------------------------------
    public void displayBackward() {
        System.out.print("List (last-->first): ");
        Link current = last; // От начала списка
        while (current != null) // Перемещение до конца списка
        {
            current.displayLink(); // Вывод данных
            current = current.prev; // Переход к следующему элементу
        }
        System.out.println("");
    }

}
