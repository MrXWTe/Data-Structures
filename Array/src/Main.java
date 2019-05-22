/**
 * 数组的创建和遍历
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 数组的创建与赋值
         */
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int[] scores = new int[]{10, 20, 30};

        /**
         * 普通for循环遍历
         */
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }

        /**
         * foreach循环遍历
         */
        for(int score : scores){
            System.out.println(score);
        }

        Array arr1 = new Array(20);
        for(int i = 0; i<10; i++){
            arr1.addLast(i);
        }
        System.out.println(arr1);
    }
}
