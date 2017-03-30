package com.scratchpad.service;

import com.scratchpad.dataformat.TreeNode;

public class BSTHelper {

	private static final int[] input = new int[] { 3, 1, 2, 1, -9, -2, 0, 11, 2, 6, 5, 7 };
	private static final int length = input.length;
	private static TreeNode root = null;

	public void initailize() {
		for (int i = 0; i < length; i++) {
			root = insertIntoBST(root, input[i]);
		}
		inorder(root);
	}

	private void inorder(TreeNode root) {
		if (root == null) {
			return;
		} else {
			inorder(root.getlChild());
			System.out.println(root.getData());
			inorder(root.getrChild());
		}
	}

	private TreeNode insertIntoBST(TreeNode root, int data) {
		if (root == null) {
			root = new TreeNode(null, data, null);
			return root;
		} else {
			if (data >= root.getData()) {
				root.setrChild(insertIntoBST(root.getrChild(), data));
			} else {
				root.setlChild(insertIntoBST(root.getlChild(), data));
			}
		}
		return root;
	}

	public void getHeight() {
		int height = findHeight(root);
		System.out.println("Height is : " + height);
	}

	private int findHeight(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int lHeight = findHeight(root.getlChild());
			int rHeight = findHeight(root.getrChild());
			return Math.max(lHeight, rHeight) + 1;
		}
	}

}
