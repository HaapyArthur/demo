package intervive.leetcode;

public class ListNode {

    ListNode next;

    int val;

    public ListNode() {
    }

    public ListNode(int val){
        this.val = val;
    }

    public static ListNode build(int[] arr){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int i : arr){
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void print(ListNode head){
        if (head == null) return;
        StringBuffer stringBuffer = new StringBuffer();
        while(head != null){
            stringBuffer.append(head.val);
            head = head.next;
            if (head != null){
                stringBuffer.append("-->");
            }
        }
        System.out.println(stringBuffer.toString());
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("gc !");
    }

    public static void main(HWString[] args) {
      ListNode listNode = new ListNode();
      listNode = null;
      System.gc();
    }


}
