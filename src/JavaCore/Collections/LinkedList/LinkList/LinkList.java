package JavaCore.Collections.LinkedList.LinkList;

public class LinkList {

    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int id) {
        Link newLink = new Link(id);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList(){
        System.out.println("List (fist --> last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }

    public Link find(int key) {
        Link current = first;
        while (current.data != key) {
            if (current.next == null) return null;
            else current = current.next;
        }
        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link prev;
        while (current.data != key) {
            if (current.next == null) return null;
            else {
                prev = current;
                current = current.next;
            }
            if (current == first) {
                first = first.next;
            } else {
                prev.next = current.next;
            }
        }
        return current;
    }

}
