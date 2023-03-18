package LinkedList.LinkList;

public class LinkListApp {

    public static void main(String[] args) {
        LinkList theList = new LinkList(); // Создание нового списка
        theList.insertFirst(22); // Вставка четырех элементов
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertFirst(88);
        theList.displayList(); // Вывод содержимого списка

        // while( !theList.isEmpty() ) // Пока остаются элементы,
        // {
        //     Link aLink = theList.deleteFirst(); // Удаление элемента
        //     System.out.print("Deleted "); // Вывод удаленного элемента
        //     aLink.displayLink();
        //     System.out.println("");
        // }

        Link f = theList.find(44); // Поиск элемента
        if (f != null)
            System.out.println("Found link with key " + f.data);
        else
            System.out.println("Can’t find link");
        Link d = theList.delete(66); // Удаление элемента
        if (d != null)
            System.out.println("Deleted link with key " + d.data);
        else
            System.out.println("Can’t delete link");

        theList.displayList(); // Вывод содержимого списка
    }

}
