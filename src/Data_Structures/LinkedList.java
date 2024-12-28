package Data_Structures;

public class LinkedList {

    //CREATE NODE CLASS
    static class Node {
        //ATTRIBUTES IN NODES
        int data;
        Node next;

        //HEAD & TAIL NODES
        Node head = null;
        Node tail = null;

        //INSERT OPERATION
        void add(int data) {
            Node newNode = new Node();
            newNode.data = data;
            if(head != null) {
                tail.next = newNode;
                tail = newNode;
            } else {
                head = tail = newNode;
            }
        }

        //REMOVE OPERATION
        void remove() {
            if(head == null) {
                System.out.println("Can't remove elements because list is empty!");
            } else if (head != tail) {
                Node temp_head = head;
                while (head != null) {
                    try {
                        if (head.next == tail) {
                            tail = head;
                            head.next = null;
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Warning: " + e);
                    }
                    head = head.next;
                }
                head = temp_head;
            } else {
                head = null;
                System.out.println("List is empty");
            }
        }

        //SEARCH OPERATION
        void search(int data) {
            Node temp_head = head;
            boolean found = false;
            while (head != null) {
                if(head.data == data)
                    found = true;
                head = head.next;
            }
            if(found)
                System.out.println("The value is here!");
            else
                System.out.println("The value is not here!");
        }

        //PRINT OPERATION
        void print() {
            Node temp_head = head;
            while(head != null) {
                System.out.print(head.data +" ");
                if(head.next != null) {
                    head = head.next;
                } else {
                    break;
                }
            }
            head = temp_head;
            System.out.println();
        }
    }

    public static void main(String[] args) {

        //CREATE NODE CLASS OBJECT AS A LINKED LIST
        Node list = new Node();
        //LINKED LIST OPERATIONS
        list.add(10);
        list.add(20);
        list.add(30);
        list.print();

        list.add(40);
        list.add(50);
        list.print();

        list.remove();
        list.remove();
        list.remove();
        list.remove();
        list.remove();

        list.remove();
        list.remove();
        list.print();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.print();

        list.search(50);
        list.search(1);
    }

}
