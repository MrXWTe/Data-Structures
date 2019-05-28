import java.util.Random;

public class Main {

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i<5; i++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);


        System.out.println("********************比较数组栈和链表栈的性能差异****************************");
        int opCount = 500000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println("数组栈用时：" + testStack(arrayStack, opCount) + "s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println("链表栈用时：" + testStack(linkedListStack, opCount) + "s");

    }

    private static double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0; i<opCount; i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i = 0; i<opCount; i++){
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
