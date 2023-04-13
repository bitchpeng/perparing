package listnode;

import java.util.Stack;

public class ListNodeMain {

    //单向链表反转

    public static ListNode revert(ListNode head) {

        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //双向链表反转
    public static DoubleListNode revertDouble(DoubleListNode head) {

        DoubleListNode pre = null;
        DoubleListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    //输入一个链表的头结点，按照 从尾到头 的顺序返回节点的值。
    //输入：[2, 3, 5]
    //返回：[5, 3, 2]
    public static int[] listNode2Array(ListNode listNode) {
        int len = 0;
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
            len++;
        }
        int[] ints = new int[len];
        int i = 0;
        while (!stack.empty()) {
            ints[i++] = stack.pop();
        }
        return ints;


    }


    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留。
    //输入：1->1->1->2->3
    //输出：2->3


    //输入一个链表，输出该链表中倒数第 k 个结点。
    // 1. 双指针法 复制两个头节点 第一个走过k个值，然后两个链表同时遍历 当第二个链表为null 前面就是倒数第k个
    // 2. 压栈  遍历链表  压栈  从栈中pop第k个就是倒数第k个
    public static ListNode getByk(ListNode head,Integer k){
       ListNode frist=head;
       ListNode second=head;
       while (--k>0){
           frist=frist.next;
       }
       while (frist!=null){
           frist=frist.next;
           second=second.next;
       }
       return second;
    }

    //给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
    //复制两个头节点  第一个每次比第二个多走一部  当第一个追到第二个就说明有环形

    //输入一个链表，反转链表后，输出新链表的表头。
    //定义 head pre next

    //输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。


    //输入两个链表，找出它们的第一个公共结点。


    public static void main(String[] args) {
        ListNode prepar = prepar();
        int[] ints = listNode2Array(prepar);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

//        DoubleListNode doubleListNode = preparDouble();
//        DoubleListNode listNode = revertDouble(doubleListNode);
//        printDoubleListNode(listNode);


    }

    public static ListNode prepar() {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(8);
        System.out.print(listNode.val + ",");
        listNode.next = listNode1;
        System.out.print(listNode1.val + ",");
        listNode1.next = listNode2;
        System.out.print(listNode2.val + ",");
        listNode2.next = listNode3;
        System.out.println(listNode3.val);
        listNode3.next = null;
        return listNode;
    }

    public static DoubleListNode preparDouble() {
        DoubleListNode listNode = new DoubleListNode(1);
        DoubleListNode listNode1 = new DoubleListNode(5);
        DoubleListNode listNode2 = new DoubleListNode(2);
        DoubleListNode listNode3 = new DoubleListNode(8);

        listNode.setDouble(listNode1, null);
        listNode1.setDouble(listNode2, listNode);
        listNode2.setDouble(listNode3, listNode1);
        listNode3.setDouble(null, listNode2);

        System.out.println((listNode.pre == null ? "null" : listNode.pre.val) + "<---" + listNode.val + "--->" + listNode.next.val);
        System.out.println(listNode1.pre.val + "<---" + listNode1.val + "--->" + listNode1.next.val);
        System.out.println(listNode2.pre.val + "<---" + listNode2.val + "--->" + listNode2.next.val);
        System.out.println(listNode3.pre.val + "<---" + listNode3.val + "--->" + (listNode3.next == null ? "null" : listNode3.next.val));
        return listNode;
    }

    public static void printDoubleListNode(DoubleListNode listNode) {
        while (listNode != null) {
            System.out.println((listNode.pre == null ? "null" : listNode.pre.val) + "<---" + listNode.val + "--->" + (listNode.next == null ? "null" : listNode.next.val));
            listNode = listNode.next;
        }
        System.out.println();
    }


    public static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }

}
