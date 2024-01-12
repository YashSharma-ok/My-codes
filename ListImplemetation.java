class MyLinkedList {
    // Structure of a Node in Linked list
    class Node {
        int data;
        Node next;

        public Node(int x) {
            this.data = x;
        }
    }

    private Node header; // Header to point first element of this linked list
    private Node endOfList;

    // constructor for Linked list with no element
    public MyLinkedList() {
    }

    // constructor for Linked list with first element
    public MyLinkedList(int data) {
        Node newNode = new Node(data);
        header = newNode;
        endOfList = newNode;
    }

    // Method to add an element at First position in Linked list
    public void insertAtFirst(int x) {
        Node newNode = new Node(x);
        newNode.next= header;
        header = newNode;
    }

    // Method to add an element at its correct first sorted position in Linked list
    public void insertAtCorrect(int x) {
        Node newNode = new Node(x);

        if (header == null) {
            header = newNode;
        } else if (header.data > x) {
            insertAtFirst(x);
        } else {
            Node temp = header;
            while (temp.next != null && temp.next.data < x) {
                temp = temp.next;

            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        if (newNode.next == null)
            endOfList = newNode;
    }

    public void appendAtEnd(int x) {
        Node newNode = new Node(x);

        if (header == null) {
            header = newNode;
        } else {
            endOfList.next = newNode;
        }
        endOfList = newNode;
    }

    // Return string To print elements using println / print method
    public String toString() {
        String res = "[ ";
        Node temp = header;
        int count = 0;
        while (temp != null) {
            res = res + temp.data;
            count += 1;
            if (temp.next != null) {
                res = res + ", ";
            }
            temp = temp.next;
        }
        System.out.println(count);
        res = res + " ]";
        return res;
    }

}

public class ListImplemetation {
    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();
        for (int j = 100; j >= 1; j--) {

            list1.insertAtCorrect((int)(Math.random()*100));
            list2.appendAtEnd((int)(Math.random()*100));
        }

        System.out.println(list1);
        System.out.println(list2);

    }
}
