import java.util.Queue;
import java.util.*;

public class BinaryTree
{
        private Node root;

        BinaryTree(String val)
        {
            root = new Node(val);
        }

        BinaryTree()
        {
            root = null;
        }

        public static String serializeTree(Node root)
        {
            //convert this tree into a string which can be deserialized to the same tree.
            /*
                                1                                                   0,0
                        2                 3                         1,0                         1,1
                                    4           5         2,0             2,1             2,2         2,3

                [1,2,3,null,null,4,5]
       
            */

           
            Queue<Node> queue = new LinkedList<>();
            Stack<String> stack = new Stack<>();
            
            queue.add(root);

            while(!queue.isEmpty())
            {
                Node temp = queue.poll();

                stack.push(temp.val);

                if(temp.val != null)
                {
                    if(temp.left == null)
                    {  
                        queue.add(new Node(null));
                    }
                    else
                        queue.add(temp.left);  
                }
                
                if(temp.val != null)
                {
                    if(temp.right == null)
                    {  
                        queue.add(new Node(null));
                    }
                    else
                        queue.add(temp.right);    
                }

            }

            while(stack.peek() == null)
            {
                stack.pop();
            }

            return stack.toString();
        }

/*
   0 = 1                            1                                                               0      
   1 = 2                    2                 3                                     1                           2               
   2 4                                4             5                       3              4            5               6                                                                              
   3 8                            6       7     8       9                7       8       9     10     11      12      13      14   

*/  
        public static Node formulateTree(String[] nodeString,int index)
        {
            if(index >= nodeString.length)
                return null;

            if(nodeString[index].equals("null"))
                return null;

            Node newNode = new Node(nodeString[index]);

            //left = 2n +1 and right = 2n + 2
            newNode.left = formulateTree(nodeString, (2 * index) + 1);

            newNode.right = formulateTree(nodeString, (2 * index) + 2 );

            return newNode;
        }

        
        public static Node deserializeTree(String inputString)
        {
                String[] nodeString = new String[inputString.length()];
                String actualString = inputString.substring(1, inputString.length() - 1);
                nodeString = actualString.split(", ");

                Node tempNode = formulateTree(nodeString,0);
                
                return tempNode;
            
        }


        public void inOrder(Node node)
        {
            if(node == null)
            {
                System.out.println("empty");
            }

            if(node.left != null)
                inOrder(node.left);
            
            System.out.println(node.val);
        
            if(node.right != null)
                inOrder(node.right);
        }        


        public Node firstCommonAncestor(Node currentNode,Node node1, Node node2)
        {
            if(currentNode == null)
                return null;

            if(currentNode.val == node1.val || currentNode.val == node2.val)
                return currentNode;

            Node leftNode = firstCommonAncestor(currentNode.left, node1, node2);
            Node rightNode = firstCommonAncestor(currentNode.right, node1, node2);

            if(leftNode != null && rightNode != null)
                return currentNode;

            return leftNode != null ? leftNode : rightNode;
        }

        public boolean isBinarySearchTree(Node node)
        {
           
            // if(node == null)
            // {
            //     return true;
            // }

            // if(node.left != null)
            // {
            //     if(node.val < node.left.val)
            //         return false;
            // }

            // if(node.right != null)
            // {
            //     if(node.val > node.right.val)
            //         return false;
            // }  
                
            // if(!isBinarySearchTree(node.left) || !isBinarySearchTree(node.right))
            //     return false;

            return true;
            
        }

        public int height(Node node)
        {
            if(node == null)    
                return 0;
            
            //only checking on root....need to check on every node.

            int lHeight = height(node.left);
            int rHeight = height(node.right);

            return Math.max(lHeight, rHeight) + 1;
        }


        public boolean isBalanced(Node node)
        {
            if(node == null)
                return true;

            int l = height(node.left);
            int r = height(node.right);

            if((Math.abs(l - r) <= 1) && isBalanced(node.left) && isBalanced(node.right))
                return true;
            
            return false;
        }

        public void DFS(Node node)
        {
            if(node == null)
            {
                System.out.println("Empty!");
            }
            
            if(node.left != null)
                DFS(node.left);
            
            if(node.right != null)
                DFS(node.right);

        }

        static class Node {
            String val;
            Node left;
            Node right;

            public Node(String x) { 
                this.val = x; 
                this.left = this.right = null;
            }

            public Node() { 
                this.val = null; 
                this.left = this.right = null;
            }
        }
   
        


        public static void main(String[] args)
        {
            BinaryTree treeObj = new BinaryTree("1");
    
            treeObj.root.left = new Node("2");
            treeObj.root.left.left = new Node("6");
            treeObj.root.left.right = new Node("7");
            treeObj.root.right = new Node("3");
            treeObj.root.right.right = new Node("5");
            treeObj.root.right.left = new Node("4");
            

            System.out.println("Height of tree " + treeObj.height(treeObj.root));
            System.out.println("Tree is balanced? " + treeObj.isBalanced(treeObj.root));
                      
            System.out.println(serializeTree(treeObj.root));

            System.out.println(treeObj.firstCommonAncestor(treeObj.root, treeObj.root.right.left, treeObj.root.left.right).val);
            deserializeTree(serializeTree(treeObj.root));
        }
}


