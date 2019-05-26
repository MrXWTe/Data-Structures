public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    /**
     * 带参构造
     * @param capacity 队列初始容量
     */
    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    /**
     * 无参构造
     */
    public ArrayQueue(){
        array = new Array<>(10);
    }

    /**
     * 获取元素个数
     * @return 元素个数
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 是否为空
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 队列容量
     * @return 队列容量
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 入队
     * @param e 入队元素
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 出队
     * @return 出队元素
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 查看队列首元素
     * @return 首元素
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue:");
        sb.append("front [");
        for(int i = 0; i<array.getSize(); i++){
            sb.append(array.get(i));
            if(i != array.getSize() - 1)
                sb.append(", ");
        }
        sb.append("] tail");
        return sb.toString();
    }
}
