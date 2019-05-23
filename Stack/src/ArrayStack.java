public class ArrayStack<E> implements Stack<E>{

    Array<E> array;

    /**
     * 带参构造函数，用指定参数初始化容器
     * @param capacity 指定容量
     */
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    /**
     * 无参构造函数，初始容量为0
     */
    public ArrayStack(){
        array = new Array<>();
    }

    /**
     * 返回栈深度
     * @return 栈深度
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断栈是否为空
     * @return 栈是否为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 计算栈的容量
     * @return 栈的容量
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 入栈
     * @param e 入栈的元素
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 出栈
     * @return 出栈元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶元素
     * @return 栈顶元素
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Stack:");
        sb.append("[");
        for(int i = 0; i<array.getSize(); i++){
            sb.append(array.get(i));
            if(i != array.getSize() - 1)
                sb.append(", ");
        }
        sb.append("] top");

        return sb.toString();
    }
}
