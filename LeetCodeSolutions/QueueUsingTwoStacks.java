import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class QueueUsingTwoStacks
{
    
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    

    private void enqueue(int data)
    {
       stack1.push(data);
    }

    private void adjust()
    {
        if(stack2.empty()){
            while(!stack1.empty())
            {
                stack2.push(stack1.pop());
            }
        }
    }

    private int peek()
    {
        adjust();
        return stack2.peek();
    }

    private void dequeue()
    {
        adjust();
        stack2.pop();
    }

    

    public static void main(String[] args) {
        QueueUsingTwoStacks q = new QueueUsingTwoStacks();

        q.enqueue(42);
        q.dequeue();
        q.enqueue(14);
        System.out.println(q.peek());
        q.enqueue(28);
        System.out.println(q.peek());
        q.enqueue(60);
        q.enqueue(78);
        q.dequeue();
        q.dequeue();

        


    }

}