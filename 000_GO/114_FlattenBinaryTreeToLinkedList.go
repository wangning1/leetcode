package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func flatten(root *TreeNode) {
	if root == nil {
		return
	}

	flatten(root.Left)
	flatten(root.Right)
	leftNode := root.Left
	rightNode := root.Right

	root.Left = nil
	root.Right = leftNode
	tmp := root
	for tmp.Right != nil {
		tmp = tmp.Right
	}
	tmp.Right = rightNode
}
