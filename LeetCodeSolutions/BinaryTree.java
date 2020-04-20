
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
    
        public static void main(String[] args)
        {
            BinaryTree treeObj = new BinaryTree(1);
    
            treeObj.root.left = new Node(2);
            treeObj.root.right = new Node(3);
            treeObj.root.right.right = new Node(4);
            treeObj.root.right.left = new Node(5);
            treeObj.root.right.left.left = new Node(6);
            treeObj.root.right.left.right = new Node(7);
            
        

            
        }
}


