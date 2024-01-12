class YashKaBST {
//  The Structure of a Node in BST
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;          //   Root Node reference

//  Constructor to create Root Node
    public YashKaBST(int data) {
        this.root = new Node(data);
    }

//  Insert an new Data into the Binary Search Tree (BST)
    public void insertData(int data) {
        Node newNode = new Node(data);
        Node temp = root;
        Node prev = root;
        while (temp != null) {
            if (data <= temp.data) {
                prev = temp;
                temp = temp.left;
            } else {
                prev = temp;
                temp = temp.right;
            }
        }
        if (data <= prev.data) {
            prev.left = newNode;
        } else {
            prev.right = newNode;
        }
    }

//  Print elements seperated by spaces in InOrder form
    public void printInOrder() {

        System.out.println(inDisplay(root));

    }

//  Returns string of elements seperated by spaces in InOrder form 
    private String inDisplay(Node node) {

        if (node == null)
            return "";

        return inDisplay(node.left) + "" + node.data +" " + inDisplay(node.right);
    }

//  to allow user to print it Using print / println methods
    public String toString() {

        return "[ " + inDisplay(root).strip().replaceAll(" ", ", ") + " ]";

    }

}

public class BSTImplementation {
    public static void main(String[] args) {
        YashKaBST myTree = new YashKaBST(10);
        myTree.insertData(3);
        myTree.insertData(11);
        myTree.insertData(4);
        myTree.insertData(1);
        myTree.insertData(13);

        // myTree.printInOrder();

        System.out.println(myTree);
    }
}
