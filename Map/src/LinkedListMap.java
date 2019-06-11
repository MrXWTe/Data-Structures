public class LinkedListMap<K, V> implements Map<K, V>{

    /**
     * 内部类
     */
    public class Node{
        private K key;
        private V value;

        private Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value){
            this(key, value, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        this.dummyHead = new Node();
        this.size = 0;
    }

    /**
     * 获得Map的大小
     * @return Map大小
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Map是否为空
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获得指定key的结点
     * @param key 指定键
     * @return 结点
     */
    private Node getNode(K key){
        Node cur = dummyHead.next;

        while(cur != null){
            if(key.equals(cur.key))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    /**
     * Map是否包含指定键的键值对
     * @param key 指定键
     * @return 键值对
     */
    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    /**
     * 获取指定键的值
     * @param key 指定键
     * @return 值
     */
    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    /**
     * 添加键值对
     * @param key 指定键
     * @param value 指定值
     */
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }else{
            node.value = value;
        }
    }

    /**
     * 更新键值对
     * @param key 指定键
     * @param newValue 更新的值
     */
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        else
            node.value = newValue;
    }

    /**
     * 删除键值对
     * @param key 指定键
     * @return 删除键值对的值
     */
    @Override
    public V remove(K key){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.key.equals(key))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }

        return null;
    }
}
