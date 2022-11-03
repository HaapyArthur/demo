package intervive.leetcode;


import java.util.HashMap;
import java.util.Map;

public class LinkNode {

    /**
     * 找两个链表第一个共同节点
     */
    static class GetIntersectionNode {
        public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            ListNode head1 = headA;
            ListNode head2 = headB;

            while (head1 != head2) {
                head1 = head1 == null ? headB : head1.next;
                head2 = head2 == null ? headA : head2.next;

            }
            return head1;
        }

    }

    /**
     * 删除链表指定节点
     */
    static class DeleteNodeVal {

        public static ListNode DeleteNodeVal(ListNode head, int val) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode curr = dummy;
            while (curr != null && curr.next != null) {
                if (curr.next.val == val) {
                    curr.next = curr.next.next;
                }
                curr = curr.next;
            }
            return dummy.next;
        }
    }

    /**
     * 合并两个有序链表
     */
    static class MergeTwoSortedLink {

        public static ListNode mergeTwoSortedLink(ListNode headA, ListNode headB) {
            if (headA == null) return headB;
            if (headB == null) return headA;
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;

            while (headA != null && headB != null) {
                if (headA.val < headB.val) {
                    curr.next = new ListNode(headA.val);
                    headA = headA.next;
                } else {
                    curr.next = new ListNode(headB.val);
                    headB = headB.next;
                }
                curr = curr.next;
            }
            if (headA != null) {
                curr.next = headA;
            }
            if (headB != null) {
                curr.next = headB;
            }
            return dummy.next;
        }
    }

    // TODO: 2022/7/5
    static class DeleteDuplicateLink {
        // 1->2->3->3->3->4->5
        public static ListNode deleteDuplicates(ListNode head) {

            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode curr = head;

            while (curr != null && curr.next != null) {
                if (curr.val == curr.next.val) {
                    curr.next = curr.next.next;
                    //  curr = curr.next;
                } else {
                    curr = curr.next;
                }
            }
            return pre.next;

        }

        public static void main(HWString[] args) {
            int[] arr = {1, 2, 3, 3, 3, 4, 5};
            ListNode head = ListNode.build(arr);
            ListNode.print(head);

            ListNode afterRoate = deleteDuplicates(head);
            ListNode.print(afterRoate);
        }
    }

    static class Traverse {
        /* 递归遍历单链表 */
        static void traverse(ListNode head) {
            if (head == null) {
                return;
            }
            // 前序位置
            traverse(head.next);
            // 后序位置
            System.out.print(head.val+" ");
        }
        public static void main(HWString[] args) {
            int[] arr = {1, 2,  3, 4, 5};
            ListNode head = ListNode.build(arr);

            traverse(head);
        }
    }

    /**
     * 寻找中间节点
     */
    static class MiddleNode {
        public ListNode middleNode(ListNode head) {
            if (head == null) return null;
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }

    static class ReverseNode {
        public static ListNode reverse(ListNode head) {
            if (head == null) return null;
            ListNode pre = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }
    }

    // TODO: 2022/7/5
    static class DeleteNode {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;

        }
    }

    /**
     * 两数相加
     */
    class mAddTwoNumbers {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            int pre = 0;
            while (l1 != null || l2 != null) {
                int l1Val = 0;
                if (l1 != null) {
                    l1Val = l1.val;
                    l1 = l1.next;
                }
                int l2Val = 0;
                if (l2 != null) {
                    l2Val = l2.val;
                    l2 = l2.next;
                }
                int sum = (l1Val + l2Val) + pre;
                int currVal = sum % 10;
                pre = sum / 10;
                curr.next = new ListNode(currVal);
                curr = curr.next;
            }

            if (pre > 0) {
                curr.next = new ListNode(pre);
                curr = curr.next;
            }
            return dummy.next;
        }
    }

    /**
     * 删除链表的倒数第 N 个结点
     */
    class mRemoveNthFromEnd {
        //    -1-->1-->2-->3-->4-->5
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode first = dummy;
            ListNode second = dummy;
            while (n > 0) {
                first = first.next;
                n--;
            }
            while (first.next != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;

            return dummy.next;
        }
    }


    /**
     * 两两交换链表中的节点
     */
    // TODO: 2022/7/5
    static class mSwapPairs {
        public static ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode curr = dummy;
            while (curr.next != null && curr.next.next != null) {
                // 定义两个指针
                ListNode start = curr.next;
                ListNode end = curr.next.next;
                //
                curr.next = end;
                start.next = end.next;
                end.next = start;
                curr = start;
            }
            return dummy.next;
        }

        public static void main(HWString[] args) {
            int[] arr = {1, 2, 3, 4, 5, 6, 7};
            ListNode head = ListNode.build(arr);
            ListNode.print(head);

            ListNode afterRoate = swapPairs(head);
            ListNode.print(afterRoate);
        }
    }

    /**
     * 旋转链表
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置
     */
    // TODO: 2022/7/6
    static class mRotateRight {
        // 1-->2-->3-->4-->5
        // 4-->5-->1-->2-->3
        public static ListNode rotateRight(ListNode head, int k) {
            if (head == null || k == 0) return head;

            int n = 0;
            ListNode curr = head;
            while (curr != null) {
                curr = curr.next;
                n++;
            }
            k = k % n;
            int step = n - k - 1;

            ListNode first = head;
            while (step > 0) {
                first = first.next;
                step--;
            }
            ListNode start = first.next;
            ListNode end = start;
            first.next = null;
            while (end.next != null) {
                end = end.next;
            }
            end.next = head;
            return start;
        }

        public static void main(HWString[] args) {
            int[] arr = {1};
            ListNode head = ListNode.build(arr);
            ListNode.print(head);

            ListNode afterRoate = rotateRight(head, 1);
            ListNode.print(afterRoate);

        }
    }

    /**
     * 分隔链表
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     */
    static class mPartition {
        public static ListNode partition(ListNode head, int x) {
            ListNode smallHead = new ListNode(-1);
            ListNode bigHead = new ListNode(-1);

            ListNode small = smallHead;
            ListNode big = bigHead;
            ListNode curr = head;

            while (curr != null) {
                if (curr.val < x) {
                    small.next = new ListNode(curr.val);
                    curr = curr.next;
                    small = small.next;
                } else {
                    big.next = new ListNode(curr.val);
                    curr = curr.next;
                    big = big.next;
                }
            }
            big.next = null;
            small.next = bigHead.next;

            return smallHead.next;

        }

        public static void main(HWString[] args) {
            int[] arr = {1, 4, 3, 2, 5, 2};
            ListNode head = ListNode.build(arr);
            ListNode.print(head);

            ListNode afterPatition = partition(head, 3);
            ListNode.print(afterPatition);
        }
    }

    /**
     * 奇偶链表
     * 输入: head = [1,2,3,4,5]
     * 输出: [1,3,5,2,4]
     */
    // TODO: 2022/7/27
    static class mOddEvenList {
        public static ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode oddHead = head;
            ListNode odd = oddHead;
            ListNode evenHead = head.next;
            ListNode even = evenHead;
            while (even != null && even.next != null) {

                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return oddHead;


        }

        public static void main(HWString[] args) {
            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
            ListNode head = ListNode.build(arr);
            ListNode.print(head);
            ListNode oddEven = oddEvenList(head);
            ListNode.print(oddEven);
        }
    }

    /**
     * todo
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     */
    static class mSortList {
        // TODO: 2022/7/8
        public static ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = dummy.next;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode second = slow.next;
            slow.next = null;
            ListNode firsSortHalf = sortList(head);
            ListNode secondSortHalf = sortList(second);
            return MergeTwoSortedLink.mergeTwoSortedLink(firsSortHalf, secondSortHalf);
        }
        // 失败的版本
//        public static ListNode sort(ListNode head){
//            if ( head == null || head.next == null){
//                return head;
//            }
//            int mid = length/2;
//            int step = mid;
//            ListNode curr = head;
//            while (step > 0){
//                    curr = curr.next;
//                    step--;
//            }
//            ListNode first = head;
//            ListNode second = curr.next;
//            ListNode firsSortHalf = sort(first,mid);
//            ListNode secondSortHalf = sort(second,mid);
//            ListNode afterMerge = MergeTwoSortedLink.mergeTwoSortedLink(firsSortHalf,secondSortHalf);
//            return afterMerge;
//        }

        public static void main(HWString[] args) {
            int[] arr = {4, 2, 5, 4, 1, 3, 6, 8};
            ListNode head = ListNode.build(arr);
            ListNode sortedListNode = sortList(head);
            ListNode.print(sortedListNode);
        }
    }

    /**
     * 环形链表 II
     * 1.走a+nb步一定是在环入口
     * 2.第一次相遇时慢指针已经走了nb步
     */

    static class mDetectCycle {
        public static ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) return null;
            ListNode fast = head;
            ListNode slow = head;
            while (true) {
                if (head == null || head.next == null) return null;
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) break;
            }
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }

    /**
     * 有序链表转换二叉搜索树
     */
    static class mSortedListToBST {
        public static TreeNode sortedListToBST(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return new TreeNode(head.val);

            ListNode leftEnd = head;
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                if (fast != null && fast.next != null) {
                    leftEnd = leftEnd.next;
                }
                slow = slow.next;
            }
            ListNode rightHalf = slow.next;
            leftEnd.next = null;
            TreeNode root = new TreeNode(slow.val);
            TreeNode left = sortedListToBST(head);
            TreeNode right = sortedListToBST(rightHalf);
            root.left = left;
            root.right = right;
            return root;
        }

        public static void main(HWString[] args) {
            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
            ListNode head = ListNode.build(arr);
            ListNode.print(head);
            TreeNode treeNode = sortedListToBST(head);
            System.out.println();
        }
    }

    static class mLRUCache {

        private Map<Integer, DBLink> cache = new HashMap<>();
        int size;
        int capacity;
        DBLink head, tail;

        public mLRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new DBLink();
            tail = new DBLink();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DBLink node = cache.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.val;

        }

        public void put(int key, int value) {

            if (cache.containsKey(key)) {
                DBLink node = cache.get(key);
                node.val = value;
                moveToHead(node);

            } else {
                DBLink curr = new DBLink(key, value);
                cache.put(key, curr);

                if (size >= capacity) {
                    DBLink last = removeLast();
                    cache.remove(last.key);
                    addToHead(curr);

                } else {
                    addToHead(curr);

                    size++;
                }


            }

        }

        class DBLink {
            int val;
            int key;
            DBLink pre;
            DBLink next;

            public DBLink() {
            }

            public DBLink(int key, int val) {
                this.val = val;
                this.key = key;
            }
        }

        private void remove(DBLink node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;

        }

        private void addToHead(DBLink node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        private void moveToHead(DBLink node) {
            remove(node);
            addToHead(node);
        }

        private DBLink removeLast() {
            DBLink last = tail.pre;
            remove(last);
            return last;
        }

        public static void main(HWString[] args) {
            mLRUCache cache = new mLRUCache(3);
            cache.put(1, 2);
            cache.put(2, 2);
            cache.put(3, 2);

            cache.put(4, 2);
            cache.put(5, 2);
            System.out.println(cache.get(1));
            System.out.println(cache.get(2));
            System.out.println(cache.get(3));
            System.out.println(cache.get(4));

        }

    }


    static class Test {

        public static ListNode append(ListNode head) {
            ListNode curr = head;
            while (curr != null) {
                ListNode newNode = new ListNode(curr.val);
                newNode.next = curr.next;
                curr.next = newNode;
                curr = newNode.next;
            }
            ListNode.print(append(head));
            ListNode dummy = new ListNode(-1);
            ListNode node = dummy;
            ListNode p = head;
            while (p != null) {
                node.next = p.next;
                node = node.next;
                p.next = node.next;
                p = p.next;
            }
            return head;
        }

        public static void main(HWString[] args) {
            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
            ListNode head = ListNode.build(arr);
            ListNode.print(append(head));
        }
    }


    static class mCopyRandomList {
        public Node copyRandomList(Node head) {
//            if (head == null) return null;
//            Map<Node,Node> cache = new HashMap<>();
//            Node curr = head;
//            while (curr != null){
//                cache.put(curr,new Node(curr.val));
//                curr = curr.next;
//            }
//            curr = head;
//            while (curr != null){
//                curr.next = cache.get(curr.next);
//                curr.random = cache.get(curr.random);
//                curr = curr.next;
//            }
//            return cache.get(curr);
            // 追击节点 1->2->3 to 1->1->2->2->3->3
            if (head == null) {
                return null;
            }
            Node curr = head;
            while (curr != null) {
                Node newNode = new Node(curr.val);
                newNode.next = curr.next;
                curr.next = newNode;
                curr = newNode.next;
            }
            curr = head;
            while (curr != null) {
                if (curr.random != null) {
                    curr.next.random = curr.random.next;
                }
                curr = curr.next.next;
            }
            Node dummy = new Node(-1);
            Node node = dummy;
            Node p = head;
            while (p != null) {
                node.next = p.next;
                node = node.next;
                p.next = node.next;
                p = p.next;
            }
            return dummy.next;

        }

        class Node {
            int val;
            Node next;
            Node random;

            public Node(int val) {
                this.val = val;
                this.next = null;
                this.random = null;
            }
        }
    }

    static class mReverseBetween {
        public static ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode d = new ListNode(-1);
            d.next = head;
            ListNode curr = d;
            ListNode firstPartitionEnd = null;
            ListNode secondPartitionStart = null;
            ListNode secondPartitionEnd = null;
            int step = 0;
            while (right - 1 >= 0 && curr != null) {
                if ((left - 1) == step) {
                    secondPartitionStart = curr.next;
                    firstPartitionEnd = curr;
                }
                step++;
                curr = curr.next;
                right--;
            }
            ListNode last = curr.next;
            secondPartitionEnd = curr;
            curr.next = null;

            firstPartitionEnd.next = null;
            firstPartitionEnd.next = ReverseNode.reverse(secondPartitionStart);
            secondPartitionStart.next = last;
            return d.next;
        }

        public static void main(HWString[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            ListNode head = ListNode.build(arr);
            ListNode.print(head);
            ListNode node = reverseBetween(head, 2, 4);
            ListNode.print(node);
        }
    }

    //
// TODO: 2022/7/27
    class mReverseKGroup {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode d = new ListNode(-1);
            d.next = head;
            ListNode end = d;
            ListNode pre = d;

            while (end.next != null) {
                for (int i = 0; i < k && end != null; i++) {
                    end = end.next;
                }
                if (end == null) break;
                ListNode next = end.next;
                ListNode start = pre.next;
                end.next = null;
                pre.next = ReverseNode.reverse(start);
                start.next = next;
                pre = start;
                end = start;

            }
            return d.next;
        }
    }

//    class HMergeKLists {
//        public ListNode mergeKLists(ListNode[] lists) {
//
//        }
//    }

    public static void main(HWString[] args) {
        System.out.println(12 / 10);
        System.out.println(2 % 10);
    }


}
