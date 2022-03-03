package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	return compare(root.Left, root.Right)
}

func compare(node1, node2 *TreeNode) bool {
	if node1 == nil && node2 == nil {
		return true
	}

	if node1 == nil && node2 != nil {
		return false
	}

	if node1 != nil && node2 == nil {
		return false
	}

	if node1.Val != node2.Val {
		return false
	}

	return compare(node1.Left, node2.Right) && compare(node1.Right, node2.Left)
}
