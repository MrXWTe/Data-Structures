public class LinkedList<E> {

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

    private Node dummyHead; //虚拟头节点，不存放元素
    //private Node head;
    private int size;

    /**
     * 无参构造
     */
    public LinkedList(){
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表的元素个数
     * @return 元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断链表是否为空
     * @return 是否为空
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 在指定索引处添加元素
     * @param index 指定索引
     * @param e 添加的元素
     */
    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");


        Node prev = dummyHead;
        for(int i = 0; i < index; i++)
            prev = prev.next;

        /*
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        */
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 在链表首部添加元素，改变链表头
     * @param e 待添加的元素
     */
    public void addFirst(E e){
        /*
        Node node = new Node(e);
        node.next = head;
        head = node;
        */

        // 更为精炼的写法
        //head = new Node(e, head);
        add(0, e);
    }

    /**
     * 在链表末尾添加元素
     * @param e 待添加的元素
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 获得index索引上的元素
     * @param index 指定索引
     * @return 索引元素
     */
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++)
            cur = cur.next;

        return cur.e;
    }

    /**
     * 获得头节点元素
     * @return 头节点元素
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获得尾节点元素
     * @return 尾节点元素
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改指定索引的元素
     * @param index 指定索引
     * @param e 修改的元素
     */
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++)
            cur = cur.next;

        cur.e = e;
    }

    /**
     * 查看链表中是否有元素e
     * @param e 查看的元素
     * @return 是否存在
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur.next != null){
            if(cur.e == e)
                return true;
            cur = cur.next;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        /*
        Node cur = dummyHead.next;
        while(cur.next != null){
            sb.append(cur + "->");
            cur = cur.next;
        }
        */
        for(Node cur = dummyHead.next; cur != null; cur = cur.next)
            sb.append(cur + "->");
        sb.append("NULL");

        return sb.toString();
    }
}
