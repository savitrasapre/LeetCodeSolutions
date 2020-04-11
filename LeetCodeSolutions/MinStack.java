import java.util.*;


class MinStack {
    
    private static Node node;
    private int min = Integer.MAX_VALUE;
    Stack<Node> stack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int x) {
        if(x <= min)
        {
            min = x;
        }
        node = new Node(x,min);
        stack.push(node);
    }
    
    public void pop() {
            if(!stack.empty()){
                stack.pop();
            }
            else
            {
                throw new NoSuchElementException();
            }
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
        return stack.peek().currentMinimum;
    }

    private class Node {
        int value;
        int currentMinimum;

        private Node(int v,int min)
        {
            this.value = v;
            this.currentMinimum = min;
        }
    }
}