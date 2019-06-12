public class SegmentTree<E> {

    private E[] tree;
    private E[] data;


    public SegmentTree(E[] arr){
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[])new Object[4 * arr.length];
    }

    public int getSize(){
        return data.length;
    }

    /**
     * 返回指定索引的值
     * @param index 指定索引
     * @return 索引对应的值
     */
    public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    /**
     * 返回线段树中左孩子索引值
     * @param index 指定父索引
     * @return 左孩子索引值
     */
    private int leftChild(int index){
        return 2 * index + 1;
    }

    /**
     * 返回线段树中右孩子索引值
     * @param index 指定父索引
     * @return 右孩子索引值
     */
    private int rightChild(int index){
        return 2 * index + 2;
    }


}
