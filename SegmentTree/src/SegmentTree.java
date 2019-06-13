public class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger){
        data = (E[])new Object[arr.length];
        this.merger = merger;
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[])new Object[4 * arr.length];

        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在treeIndex的位置创建表示区间[l...r]的线段树
     * @param treeIndex 指定索引
     * @param l 左索引
     * @param r 右索引
     */
    private void buildSegmentTree(int treeIndex, int l, int r){
        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }


    public E query(int queryL, int queryR){
        if(queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");
        return query(0, 0, data.length - 1, queryL, queryR);
    }


    /**
     * 在以treeID为根的线段树中[l...r] 的范围里，搜索区间[queryL...queryR]的值
     * @param treeIndex 当前结点所在树的索引
     * @param l 当前结点在线段中的左索引
     * @param r 当前结点在线段中的右索引
     * @param queryL 需要查询的左索引
     * @param queryR 需要查询的右索引
     * @return 查询的值
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR){
        if(l == queryL && r == queryR){
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(queryL >= mid + 1)
            query(rightTreeIndex, mid+1, r, queryL, queryR);
        else if(queryR <= mid)
            return query(leftTreeIndex, l ,mid, queryL, queryR);

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid +1, r, mid+1, queryR);
        return merger.merge(leftResult, rightResult);
    }


    public int getSize(){
        return data.length;
    }

    public void set(int index, E e){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");

        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int l, int r, int index, E e){

        if(l == r){
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(index >= mid + 1)
            set(rightTreeIndex, mid+1, r, index, e);
        else
            set(leftTreeIndex, l, mid, index, e);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i<tree.length; i++){
            if(tree[i] != null){
                sb.append(tree[i]);
            }else{
                sb.append("null");
            }

            if(i != tree.length - 1)
                sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }
}
