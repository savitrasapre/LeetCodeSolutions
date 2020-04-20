import java.util.*;
import java.io.*;


class BST {

    Node root;

    BST(int val)
    {
        root = new Node(val);
    }

    BST()
    {
        root = null;
    }

    //considering unique values only. Duplicates can be a stretch feature.
    public void insert(int value)
    {
        Node newNode = new Node(value);

        if(root == null)
        {
            root = newNode;
            return;
        }
        Node current = root;
        Node temp = null;

        while (current != null) {
            temp = current;
            if(newNode.val < current.val)
            {                                                                                                                       
                current = current.left;
            }
            else
            {
                current = current.right;
            }
        }

        if(newNode.val > temp.val)
        {
            temp.right = newNode;
        }
        else
        {
            temp.left = newNode;
        }

    }

    public void createLinkedListForLevels()
    {
        
    }


    //basically DFS
    public void printTree()
    {
        if(root == null)
        {
            System.out.println("Empty tree!");
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        
        stack.push(root);

        while(!stack.empty())
        {
            Node temp = stack.pop();

            System.out.println(temp.val + " ");

            if(temp.right != null)
            {
                stack.push(temp.right);
            }
            
            if(temp.left != null)
            {
                stack.push(temp.left);
            }

        }

    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int x)
        {
            this.val = x;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] input = {1,2,3,4,5};

        //Constructing Tree based on CTCI's 2nd question.

        tree.insert(input[input.length/2]);
        for (int i = 0; i < input.length/2; i++) {
            tree.insert(input[i]);
        }
        for (int i = input.length/2 + 1; i < input.length; i++) {
            tree.insert(input[i]);
        }

        tree.printTree();

    }
}