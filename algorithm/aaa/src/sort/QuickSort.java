package sort;

/**
 * 快排
 * 基准排序
 * 指定一个基准 将大于基准小于基准的分开
 * 逐个基准重新再基准
 */
public class QuickSort {

    public static int[] sort(int[] arry, int start, int end) {
        //基准
        int num = arry[start];
        int tail = start;
        boolean flag = false;//是否出现大于基准的数据
        for (int i = start + 1; i < end+1; i++) {
            if (num >= arry[i]) {
                //从start+1开始都能替换 替换一个少一个
                flag = true;
                if (i == (tail + 1)) {
                    tail = i;
                } else {
                    for (int j = tail + 1; j < i; j++) {
                        if (arry[j] > arry[i]) {
                            int temp = arry[j];
                            arry[j] = arry[i];
                            arry[i] = temp;
                            tail = j;
                            break;
                        }
                    }
                }
            }
        }
        //start 跟tail交换
        arry[start] = arry[tail];
        arry[tail] = num;

        if (flag) {
            sort(arry, start, tail);
            if (start != end) {
                sort(arry, tail + 1, end);
            }
        }

        return arry;
    }


    public static void main(String[] args) {
        int[] ints = new int[]{5, 2, 4, 213, 32, 88, 234, 1, 678, 2, 42, 35};
        print(ints);
        int[] sort = sort(ints, 0, ints.length - 1);
        print(sort);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();

    }


}
