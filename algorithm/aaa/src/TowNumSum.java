import java.util.HashMap;
import java.util.Map;


public class TowNumSum {


    /**
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
     */
    public static int[] twoSum(int[] nums, int target) {

        int[] arr = new int[2];
        //转化成map  key值   value下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (Integer oldKey : map.keySet()) {
                int i1 = oldKey + nums[i];
                if (i1 == target) {
                    arr[0] = map.get(oldKey);
                    arr[1] = i;
                    break;
                }
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return arr;
    }

    public static int[] two2Sum(int[] nums, int target) {

        int[] indexs = new int[2];
        // 建立k-v ，一一对应的哈希表
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target - nums[i], i);
        }
        return indexs;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(t % 10);
            pre = pre.next;
            t /= 10;
        }

        return dummyHead.next;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
//
//        int[] ints = twoSum(new int[]{2, 4, 11, 3}, 6);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }

        ListNode listNode1 = new ListNode(2);

        ListNode listNode2 = new ListNode(4);

        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;


        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;


        addTwoNumbers(listNode1,listNode4);


    }


}
