import java.util.Arrays;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    /**
     * 带参构造函数
     * @param capacity 循环队列初始容量
     */
    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = tail = size = 0;
    }

    /**
     * 无参构造函数，初始容量为10
     */
    public LoopQueue(){
        this(10);
    }

    /**
     * 获取队列容量大小
     * @return 容量大小
     */
    private int getCapacity(){
        return data.length - 1;
    }

    /**
     * 获取元素个数
     * @return 元素个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 是否为空
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 入队
     * @param e 入队元素
     */
    @Override
    public void enqueue(E e) {
        // 如果队列已满（if中为判断循环队列是否是满队列）
        if( (tail + 1) % data.length == front )
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    /**
     * 扩容操作
     * @param newCapacity 容积大小
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity+1];
        for(int i = 0; i<size; i++){
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 出队
     * @return 出队元素
     */
    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        E ret = data[front];

        data[front] = null;
        front = (front+1)%data.length;
        size++;

        // 缩容
        if(size == getCapacity()/4 && getCapacity()/2 != 0){
            resize(getCapacity()/2);
        }

        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        sb.append("front [");
        for(int i = front; i != tail; i = (i+1)%data.length){
            sb.append(data[i]);
            if((i+1) % data.length != tail)
                sb.append(", ");
        }
        sb.append("] tail");
        return sb.toString();
    }
}
