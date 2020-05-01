import java.util.*;


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


    public Node insertRecursively(Node node,int value)
    {
        if(node == null)
        {   
            return new Node(value);
        }
        if(value < node.val) 
            node.left = insertRecursively(node.left, value);
        else
            node.right = insertRecursively(node.right, value);
        
        return node;
    }


    public void inOrderSuccessor(Node node)
    {
    
        Node currentPtr = node;
        if(currentPtr.right != null)
        {
            //find min in right subtree.

            Node minPtr = node.right;
            while(minPtr.left != null)
            {
                minPtr = minPtr.left;
            }
            System.out.println(minPtr.val);
            return;
        }
        else
        {
            //go up using the parent pointer.
            Node parentPtr = node.parent;

            while(parentPtr != null)
            {
                currentPtr = parentPtr;
                parentPtr = parentPtr.parent;
            }
            System.out.println(currentPtr.val);
        }

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
        newNode.parent = temp;

    }


    public int height(Node node)
    {
        if(node == null)
        {
            return 0;
        }
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
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
        Node parent;

        Node(int x)
        {
            this.val = x;
            this.parent = this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] input = {20,8,22,4,12,10,14};

        for(int i : input)
        {
            tree.insert(i);

        }

        //Constructing Tree based on CTCI's 2nd question.

        // tree.insert(input[input.length/2]);
        // for (int i = 0; i < input.length/2; i++) {
        //     tree.insert(input[i]);
        // }
        // for (int i = input.length/2 + 1; i < input.length; i++) {
        //     tree.insert(input[i]);
        // }

        System.out.println("Height of tree is: " + tree.height(tree.root));
        
        tree.inOrderSuccessor(tree.root.left.right.right);

        //tree.printTree();
    }
}


