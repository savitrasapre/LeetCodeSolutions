

class BinaryTree 
{
        int val;
        BinaryTree left;
        BinaryTree right;
        BinaryTree(int x,BinaryTree left,BinaryTree right) { 
            this.val = x; 
            this.left = left;
            this.right = right;
        }
    
        public int diameter(BinaryTree root)
        {
            return height(root.left) + height(root.right) + 2;
        }

        public int height(BinaryTree node)
        {
            
            if(node.left == null && node.right == null)
            {
                return 0;
            }
            
            int left = height(node.left);
            int right = height(node.right);
                
            if(left < right)
            { 
                return right + 1;
            }
            else
            {
                return left + 1;
            } 
            
        }

        public static void main(String[] args)
        {
            BinaryTree treeObj = 
                                    new BinaryTree(1,
                                new BinaryTree(2,
                            new BinaryTree(4,null,null), new BinaryTree(5, null, null)),            new BinaryTree(3,null,null));

            //System.out.println(treeObj.height(treeObj.left));
            //System.out.println(treeObj.height(treeObj.right));                
            System.out.println(treeObj.diameter(treeObj));
        }
}