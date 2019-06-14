import java.util.TreeMap;

public class Trie {

    private class Node{

        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie(){
        this.root = new Node();
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    /**
     * 向trie中添加一个单词
     * @param word 添加的单词
     */
    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if(!cur.isWord) {   // 如果trie之前没有该单词
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 判断trie中是否存在字符串word
     * @param word 待判断的字符串
     * @return 是否存在
     */
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 判断trie中是否存在以prefix为前缀的单词
     * @param prefix 判断的前缀
     * @return 是否存在
     */
    public boolean isPrefix(String prefix){
        Node cur = root;
        for(int i = 0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }

}
