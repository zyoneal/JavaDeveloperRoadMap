package JavaCore.Collections.LinkedList.TodoListExample;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ToDoList {

    // private List<String> toDoList = new ArrayList<>();
    private LinkedList<String> toDoList = new LinkedList<>();

    public void addToList(String task) {
        toDoList.add(task);
    }

    // Добавление в алфавитном порядке
    private boolean addInAlphabeticalOrder(String task) {
        ListIterator<String> stringListIterator = toDoList.listIterator();
        while (stringListIterator.hasNext()) {
            int compare = stringListIterator.next().compareTo(task);
            if (compare == 0) {
                System.out.println("Task already exist in the list");
                return true;
            } else if (compare > 0) {
                stringListIterator.previous();
                stringListIterator.add(task);
                return true;
            }
        }
        toDoList.add(task);
        return true;
    }

    public void addToListAtPosition(int i, String task) {
        toDoList.add(i, task);
    }

    public void printList() {
        //==================================================

        // for (int i = 0; i < toDoList.size(); i++) {
        //     System.out.println(i + " " + toDoList.get(i));
        // }

        //==================================================

        //for (String s : toDoList) {
        //    System.out.println(s);
        //}

        // ===========================================

        Iterator<String> iterator = toDoList.iterator();
        while (iterator.hasNext()) {
            System.out.println("Element " + iterator.next());
        }

    }

    public void changeTask(int index, String task) {
        toDoList.set(index, task);
    }

    public void removeTask(String task) {
        toDoList.remove(task);
    }

    public void getPriority(String task) {
        toDoList.indexOf(task);
    }

}
