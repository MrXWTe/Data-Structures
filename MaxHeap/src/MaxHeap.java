public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    /**
     * 带有初始容量的构造器
     * @param capacity 初始容量
     */
    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }


    public MaxHeap(){
        data = new Array<>();
    }

    /**
     * 通过数组构造最大堆
     * @param arr 数组
     */
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(arr.length - 1); i>=0; i--){
            siftDown(i);
        }
    }

    /**
     * 返回堆中元素个数
     * @return 个数
     */
    public int size(){
        return data.getSize();
    }

    /**
     * 判断堆中是否为空
     * @return 是否为空
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     * @param index 指定的索引
     */
    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k){

        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0 ){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 取出堆中最大元素
    public E extractMax(){

        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    // 看堆中的最大元素
    public E findMax(){
        if(data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    private void siftDown(int k){

        while(leftChild(k) < data.getSize()){
            int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
            if( j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0 )
                j ++;   // data[j] 是 leftChild 和 rightChild 中的最大值


            // 边界判断，判断成功表示找到k值所在位置
            if(data.get(k).compareTo(data.get(j)) >= 0 )
                break;
            // 判断失败交换父子元素
            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 替换操作，替换堆顶元素以及传入参数
     * @param e 传入参数
     * @return 堆顶元素
     */
    public E replace(E e){
        E ret = findMax();

        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
