import org.graalvm.compiler.debug.CSVUtil.Escape;

public class BinaryTree
{
        private Node root;

        BinaryTree(int val)
        {
            root = new Node(val);
        }

        BinaryTree()
        {
            root = null;
        }

        public void inOrder(Node node)
        {
            if(node == null)
            {
                System.out.println("empty");
            }

            //if(node.val < node.left.val)
                //return false;

            if(node.left != null)
                inOrder(node.left);
            
            System.out.println(node.val);
        
            if(node.right != null)
                inOrder(node.right);
        }        

        public boolean isBinarySearchTree(Node node)
        {
           
            if(node == null)
            {
                return true;
            }

            if(node.left != null)
            {
                if(node.val < node.left.val)
                    return false;
            }

            if(node.right != null)
            {
                if(node.val > node.right.val)
                    return false;
            }  
                
            if(!isBinarySearchTree(node.left) || !isBinarySearchTree(node.right))
                return false;

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
            int val;
            Node left;
            Node right;

            public Node(int x) { 
                this.val = x; 
                this.left = this.right = null;
            }
        }
   
        /*
                                        1
                            2                     3
                                           5                4
                                         6    7          2
        */


        public static void main(String[] args)
        {
            BinaryTree treeObj = new BinaryTree(1);
    
            treeObj.root.left = new Node(2);
            treeObj.root.right = new Node(3);
            treeObj.root.right.right = new Node(4);
            treeObj.root.right.left = new Node(5);
            treeObj.root.right.left.left = new Node(6);
            treeObj.root.right.left.right = new Node(7);

            System.out.println("Height of tree " + treeObj.height(treeObj.root));
            System.out.println("Tree is balanced? " + treeObj.isBalanced(treeObj.root));
                        
        }
}


