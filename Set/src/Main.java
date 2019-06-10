public class Main {

    public static void main(String[] args) {
	// write your code here
        BST<Integer> bst = new BST<>();

        int[] nums = {2,5,1,9,6,3};

        for(int i : nums){
            bst.add(i);
        }

        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        //System.out.println(bst.toString());
    }
}
