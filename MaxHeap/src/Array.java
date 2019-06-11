public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity 数组容量
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认容量为传入数组的容量capacity=10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return 元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组容量
     * @return 数组容量
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 数组长度是否为0
     * @return 是否为0
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向指定位置添加元素
     * @param index 添加的位置
     * @param e 添加的元素
     */
    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Added failed. Require index>0 and index < size");

        if(size == data.length)
            resize(2 * data.length);

        for(int i = size - 1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 向末尾添加元素
     * @param e 添加的元素
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 在开头添加一个元素
     * @param e 添加的元素
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 获取数组中index位置的元素
     * @param index 指定索引
     * @return 指定索引元素
     */
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Added failed. Require index>0 and index < size");
        return data[index];
    }

    /**
     * 获取数组中最后一个元素
     * @return 数组最后一个元素
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 获取数组中第一个元素
     * @return 数组第一个元素
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 修改指定索引的元素
     * @param index 指定索引
     * @param e 修改的元素
     */
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Added failed. Require index>0 and index < size");
        data[index] = e;
    }

    /**
     * 是否包含某元素
     * @param e 指定的元素
     * @return 是否存在
     */
    public boolean contains(E e){
        for(int i = 0; i<size; i++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * 查找数组元素中e的索引，如果不存在该元素，则返回-1
     * @param e 元素
     * @return 索引
     */
    public int find(E e){
        for(int i = 0; i<size; i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     * @param index 删除元素的索引
     * @return 删除元素的值
     */
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Added failed. Require index>0 and index < size");
        E ret = data[index];

        for(int i = index+1; i<size; i++)
            data[i-1] = data[i];

        size--;
        data[size] = null;

        if(size == data.length / 4 && data.length / 2 != 0)     //防止复杂度震荡
            resize(data.length / 2);
        return ret;
    }

    /**
     * 删除数组中第一个元素
     * @return 删除的元素
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除数组中最后一个元素
     * @return 删除的元素
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 从数组中删除元素e
     * @param e 删除的元素
     */
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    /**
     * 返回数组的字符串形式
     * @return 数组的字符串
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append('[');
        for(int i = 0; i<size; i++){
            sb.append(data[i]);
            if(i != size - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 交换数组中的元素
     * @param i 第一个交换元素
     * @param j 第二个交换元素
     */
    public void swap(int i, int j){

        if(i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal.");

        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    /**
     * 扩容方法
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i<size; i++)
            newData[i] = data[i];
        data = newData;
    }


}
