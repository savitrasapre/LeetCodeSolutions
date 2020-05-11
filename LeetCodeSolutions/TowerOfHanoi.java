import java.util.Stack;

class TowerOfHanoi
{
    
    public static Stack solution(Stack<Integer> A, Stack<Integer> B, Stack<Integer> C) {
        
        if(C.size() == 4 && A.size() == 0 && B.size() == 0)
            return C;
        
        //if B is "viable" then A.pop onto B
        //if C is viable then A.pop onto C

        if()


    }


    public static void main(String[] args) {
        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();
        Stack<Integer> C = new Stack<>();

        A.push(4);
        A.push(3);
        A.push(2);
        A.push(1);

        System.out.println(solution(A, B, C));


    }
}