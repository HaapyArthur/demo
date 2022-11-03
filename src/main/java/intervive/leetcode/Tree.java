package intervive.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static intervive.leetcode.TreeNode.build;

public class Tree {

    static class mWidthOfBinaryTree {
        public static int widthOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            int res = 1;
            Queue<TreeNode> queue = new LinkedList<>();
            LinkedList<Integer> list = new LinkedList<>();
            list.add(1);
            queue.add(root);
            while (queue.size() > 0) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    Integer curIndex = list.removeFirst();
                    if (curr != null) {
                        TreeNode left = curr.left;
                        TreeNode right = curr.right;
                        if (left != null) {
                            list.add(curIndex * 2);
                            queue.add(left);
                        }
                        if (right != null) {
                            list.add(curIndex * 2 + 1);
                            queue.add(right);
                        }
                    }
                }
                // list 中 size 为 1 的情况下，宽度也为 1，没有必要计算。
                if (list.size() >= 2) {
                    res = Math.max(res, list.getLast() - list.getFirst() + 1);
                }

            }
            return res;
        }

        public static void main(String[] args) {
            int[] arr = {5, 4, 2, 1, 3, 6, 7};
            TreeNode root = build(arr, 0, 6);
            int res = widthOfBinaryTree(root);
            System.out.println(res);
        }
    }
}
