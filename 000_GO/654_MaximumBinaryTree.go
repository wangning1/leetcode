/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func constructMaximumBinaryTree(nums []int) *TreeNode {
	return doBuildTree(nums, 0, len(nums))
}

func doBuildTree(nums []int, start, end int) *TreeNode {
	if start >= end {
		return nil
	}
	rootIdx := start
	maxVal := nums[start]
	for i := start; i < end; i++ {
		if nums[i] > maxVal {
			maxVal = nums[i]
			rootIdx = i
		}
	}
	root := new(TreeNode)
	root.Val = maxVal
	root.Left = doBuildTree(nums, start, rootIdx)
	root.Right = doBuildTree(nums, rootIdx+1, end)
	return root
}
