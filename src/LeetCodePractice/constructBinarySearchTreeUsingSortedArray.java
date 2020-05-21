package LeetCodePractice;

public class constructBinarySearchTreeUsingSortedArray {

    TreeNode constructTree(int [] nums, int left, int right){

        if(left > right) return null;

        int mid = (left+right)/2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = constructTree(nums, left, mid-1);
        root.right = constructTree(nums,mid+1,right);

        return root;

    }
}
