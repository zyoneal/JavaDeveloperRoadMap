package LinkedList.LinkList;

public class Link {

    public int data;

    public Link next;

    public Link(int id) {
        data = id;
    }

    public void displayLink() {
        System.out.print("{" + data + "}");
    }

}
