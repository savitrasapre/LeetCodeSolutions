import java.util.*;


class MinStack {
    
    Stack<Node> stack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int x) {
        int min = Math.min(x, getMin());
        stack.push( new Node(x,min));
    }
    
    public void pop() {
            if(!stack.empty()){
                stack.pop();
            }
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
        if(stack.empty())
        {
            return Integer.MAX_VALUE;
        }
        else
        {
            return stack.peek().currentMinimum;
        }
        
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