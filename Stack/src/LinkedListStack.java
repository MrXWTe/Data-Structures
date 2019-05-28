public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    /**
     * 无参构造，初始化链表
     */
    public LinkedListStack(){
        list = new LinkedList();
    }

    /**
     * 获得栈的深度
     * @return 栈的深度
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * 栈是否为空
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 入栈
     * @param e 入栈元素
     */
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    /**
     * 出栈
     * @return 出栈元素
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }

    /**
     * 查看栈顶元素
     * @return 栈顶元素
     */
    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: top ");
        sb.append(list);
        return sb.toString();
    }
}
