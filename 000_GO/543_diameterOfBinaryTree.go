/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var maxDiameter = 0

func diameterOfBinaryTree(root *TreeNode) int {
	maxDiameter = 0
	maxDepth(root)
	return maxDiameter
}

func maxDepth(node *TreeNode) int {
	if node == nil {
		return 0
	}
	leftDepth := maxDepth(node.Left)
	rightDepth := maxDepth(node.Right)
	if maxDiameter < leftDepth + rightDepth{
		maxDiameter = leftDepth + rightDepth
	}
	return max(leftDepth, rightDepth) + 1

}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
