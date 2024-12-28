package Data_Structures;//IMPORT LINKED LIST PACKAGE
import java.util.LinkedList;

public class LinkedList_package {
    public static void main(String[] args) {

        //CREATE A LINKED LIST
        LinkedList<Integer> numbers = new LinkedList<>();

        //INSERT DATA
        numbers.add(10);
        numbers.add(2, 20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        //REMOVE DATA
        numbers.remove();
        numbers.remove(3);

        //INSERT OPTIONS
        numbers.addFirst(5);
        numbers.addLast(35);

    }
}
