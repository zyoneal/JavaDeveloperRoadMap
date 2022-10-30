package JavaCore.Collections.LinkedList.DoublyLinkedList;

public class Link {

    public long data;

    public Link next;

    public Link prev;

    public Link(long value) {
        data = value;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }

}
