package intervive.leetcode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;

        this.left = left;
        this.right = right;
    }

    public static TreeNode build(int[] arr,int start,int end) {

        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left= build(arr,start,mid-1);
        root.right = build(arr,mid+1,end);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,2,1,3,6,7};
        TreeNode root = build(arr,0,6);
        System.out.println();
    }
}