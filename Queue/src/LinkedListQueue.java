public class LinkedListQueue<E> implements Queue<E>{

    /**
     * 内部类，链表主要结构
     */
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    /**
     * 无参构造，初始化参数
     */
    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 获取队列长度
     * @return 队列长度
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 队列是否为空
     * @return 队列是否为空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入队
     * @param e 入队元素
     */
    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 出队
     * @return 出队元素
     */
    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null)
            tail = null;

        size--;
        return retNode.e;
    }

    /**
     * 查看队首元素
     * @return 队首元素
     */
    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front ");

        for(Node cur = head; cur != null; cur = cur.next)
            sb.append(cur + "->");
        sb.append("NULL tail");

        return sb.toString();
    }

    public static void main(String[] args) {
        int opCount = 10;
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for(int i = 0; i<opCount; i++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
