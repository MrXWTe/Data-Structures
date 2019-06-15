public class UnionFind1 implements UF{

    private int[] id;

    public UnionFind1(int size){
        id = new int[size];

        // 初始化数组时，首先每个数字对应不同集合
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 查找元素p所对应的集合编号
     */
    private int find(int p){
        if(p < 0 || p >= id.length)
            throw new IllegalArgumentException("p is out of bound.");
        return id[p];
    }


    /**
     * 查看元素p和元素q是否所属同一个集合
     * @param p 待查元素
     * @param q 待查元素
     * @return 是否处于同一个集合
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }


    /**
     * 合并元素p和元素q所属元素集合
     * @param p 待合并元素
     * @param q 待合并元素
     */
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if(pId == qId){
            return;
        }
        for(int i = 0; i<id.length; i++){
            if(id[i] == pId)
                id[i] = qId;
        }
    }
}
