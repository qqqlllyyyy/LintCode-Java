/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<Integer>();
        helper(root, path, 0, target, result);
        return result;
    }
    
    private void helper(TreeNode root, List<Integer> path, int current_sum, int target, List<List<Integer>> result) {
        // if (root == null || current_sum + root.val > target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (current_sum + root.val == target && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(path));
        }
        helper(root.left, path, current_sum + root.val, target, result);
        helper(root.right, path, current_sum + root.val, target, result);
        path.remove(path.size() - 1);
    }
}

/*
    注意每个path必须是从root到leaf
    并且每个节点并不知道是否为负，所以第31行不能用30行的命令
    其实我这个解法有点不straight-forward，答案的解法如下，会在一开始先把root加入path中。
    两种方法都可以，想清楚就行。
*/
