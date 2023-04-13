package listnode;


import java.util.Objects;

public class DoubleListNode {
    int val;
    DoubleListNode next;
    DoubleListNode pre;

    DoubleListNode() {
    }

    DoubleListNode(int val) {
        this.val = val;
    }

    public DoubleListNode(int val, DoubleListNode next, DoubleListNode pre) {
        this.val = val;
        this.next = next;
        this.pre = pre;
    }

    public void setDouble(DoubleListNode next, DoubleListNode pre){
        this.next = next;
        this.pre = pre;
    }






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleListNode that = (DoubleListNode) o;
        return val == that.val && Objects.equals(next, that.next) && Objects.equals(pre, that.pre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next, pre);
    }
}
