public class Main {

    public static void main(String[] args) {

        Integer[] nums = {-2, 1, 3, -5, 5, 1};

        /*SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });*/

        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a+b);
        //System.out.println(segmentTree);

        System.out.println(segmentTree.query(0, 4));

    }

}
