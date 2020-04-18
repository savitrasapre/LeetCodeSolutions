

class BinaryTree 
{
        Node root;

        BinaryTree(int val)
        {
            root = new Node(val);
        }

        BinaryTree()
        {
            root = null;
        }

        public  void DFS(Node node)
        {
            if(node == null)
            {
                System.out.println("Empty!");
            }
            System.out.println(node.val);

            if(node.left != null)
                DFS(node.left);
            
            if(node.right != null)
                DFS(node.right);

        }

        private static class Node {
            int val;
            Node left;
            Node right;

            Node(int x) { 
                this.val = x; 
                this.left = this.right = null;
            }
        }
    
    
        public static void main(String[] args)
        {
            BinaryTree treeObj = new BinaryTree();

            treeObj.root = new Node(1);
            treeObj.root.left = new Node(2);
            treeObj.root.right = new Node(3);
            treeObj.root.left.left = new Node(4);
            treeObj.DFS(treeObj.root);

            
        }
}