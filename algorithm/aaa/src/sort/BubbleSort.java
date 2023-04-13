package sort;

/**
 * 冒泡排序 最大末尾
 * 两两比较
 */
public class BubbleSort {

    //每次排好循环最后的数据 由于j+1存在 所以 只用循环 0---n-1
    public static int[] sort(int[] arry) {
        int n = arry.length;
        //每次主循环时 子循环数量减一
        for (int i = 0; i < n -1; i++) {
            for (int j = 0; j < n - i -1 ; j++) {
                if (arry[j] > arry[j + 1]) {
                    int tmp = arry[j];
                    arry[j] = arry[j + 1];
                    arry[j + 1] = tmp;
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
            System.out.print(arr[i]+",");
        }
        System.out.println();

    }


}
