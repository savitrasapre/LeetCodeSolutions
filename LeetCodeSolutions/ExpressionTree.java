import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ExpressionTree 
{
    Node root;

    ExpressionTree()
    {
        root = null;
    }

    ExpressionTree(String inputExpression)
    {
        // (10 / 4) + ((5 + 9) * 2)


        //TODO: construct BST using a String.

    }

    public Node constructTree(Character character)
    {
        if(character == '(')
        {
            //start of subtree.


        }
        else
        {

        }

        return node;
    }


    enum NodeType  { 
        addition('+'),
        subtraction('-'),
        division('/'),
        multiplication('*'),
        numeric(' ');
    
        char sign;
        private NodeType(char sign)
        {
            this.sign = sign;
        }

        static NodeType forSign(char c)
        {
            for (NodeType n : NodeType.values()) {
                
                if(n.sign == c)
                {
                    return n;
                }
            }
            return numeric;
        }
    
    }

    public int evalute(Node node)
    {
        if(node == null) 
            return 0;
        
        int leftTreeVal = 0;
        int rightTreeVal = 0;
        
        if(node.left != null)
           leftTreeVal = evalute(node.left);

        if(node.right != null)
           rightTreeVal = evalute(node.right);
        
        return resolve(node, leftTreeVal, rightTreeVal);
    }

    public int resolve(Node node,int left,int right)
    {
        switch (node.type) {
            case addition:   return left + right;
            case subtraction:   return left - right;
            case multiplication:   return left * right;
            case division:   return left / right;
            default:    return node.value;
        }
        
    }
     

    static class Node
    {
        NodeType type;
        int value;
        Node left;
        Node right;

        Node(int v)
        {
            this.value = v;
            this.left = this.right = null;
            this.type = NodeType.numeric;
        }

        Node(int v,Node left, Node right)
        {
            this.value = v;
            this.left = left;
            this.right = right;
            this.type = NodeType.numeric;
        }

        Node(char operation)
        {
            this.type = NodeType.forSign(operation);
            this.left = this.right = null;
        }

        Node(char operation,Node left,Node right)
        {
            this.type = NodeType.forSign(operation);
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        ExpressionTree tree = new ExpressionTree("3+((5+9)*2)");

        // tree.root =         new Node('+',
        //             new Node(3),        new Node('*', 
        //                             new Node('+',
        //                         new Node(5),new Node(9)), new Node(2)));


       // System.out.println(tree.root.left.type.sign);
        //System.out.println(tree.evalute(tree.root));
        
    }
}