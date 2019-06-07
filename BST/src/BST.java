public class BST<E extends Comparable<E>> {

    /**
     * 结点类
     */
    private class Node{
        public E e;
        public Node left;
        public Node right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    /**
     * 无参构造函数
     */
    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 获取树的结点数量
     * @return 树的结点数量
     */
    public int size(){
        return size;
    }

    /**
     * 是否为空
     * @return 是否为空
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 二叉搜索树：添加元素
     * @param e 待添加的元素
     */
    public void add(E e){
        add(root, e);
    }

    /**
     * 添加元素的递归调用
     * @param node 比较的结点
     * @param e 添加的元素
     * @return 结点
     */
    private Node add(Node node, E e){
        if(node == null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }

    /**
     * 判断元素 e 是否在树中
     * @param e 判断的元素
     * @return 是否包含
     */
    public boolean contains(E e){
        return contains(root, e);
    }

    /**
     * 判断元素 e 是否在树中的递归调用
     * @param node 当前结点
     * @param e 判断的元素
     * @return 是否包含
     */
    public boolean contains(Node node, E e){
        if(root == null)
            return false;

        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else // e.compareTo(node.e) > 0
            return contains(node.right, e);
    }
}
