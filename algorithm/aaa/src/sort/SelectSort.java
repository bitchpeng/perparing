package sort;

/**
 * 选择排序 最小优先
 */
public class SelectSort {


    public static int[] sort(int[] arry) {
        //
        for (int i = 0; i < arry.length; i++) {
            for (int j = i; j < arry.length; j++) {
                //找到最小的
                if (arry[j] < arry[i]) {
                    int temp = arry[j];
                    arry[j] = arry[i];
                    arry[i] = temp;
                }

            }
        }
        return arry;
    }


    public static void main(String[] args) {
        int[] ints = new int[]{5, 2, 4, 213, 32, 88, 234, 786, 678, 2, 42, 35,};
        print(ints);
        int[] sort = sort(ints);
        print(sort);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();

    }


}
