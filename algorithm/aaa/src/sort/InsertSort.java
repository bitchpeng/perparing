package sort;

/**
 * 插入排序
 * 从第二个开始
 * 拿到一个数就逐个跟前面的数冒泡比较  小于就交换
 */
public class InsertSort {


    public static int[] sort(int[] arry) {
        //
        for (int i = 1; i < arry.length; i++) {
            //反向遍历
            //保存当前比较值
            int num=arry[i];
            for (int j = (i - 1); j >= 0; j--) {
                //j起始位置一直是i-1 可以为 0
                //遍历向后比较并位移 插入
                if (num < arry[j]) {
                    //前移
                    arry[j+1]=arry[j];
                    arry[j]=num;
                }
            }
        }
        return arry;
    }


    public static void main(String[] args) {
        int[] ints = new int[]{5, 2, 4, 213, 32, 88, 234, 786, 678, 2, 42, 35};
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
