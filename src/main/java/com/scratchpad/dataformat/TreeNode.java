package com.scratchpad.dataformat;

public class TreeNode {

	private TreeNode lChild;

	private int data;

	private TreeNode rChild;

	public TreeNode() {

	}

	public TreeNode(TreeNode lChild, int data, TreeNode rChild) {
		this.lChild = lChild;
		this.rChild = rChild;
		this.data = data;
	}

	public TreeNode getlChild() {
		return lChild;
	}

	public void setlChild(TreeNode lChild) {
		this.lChild = lChild;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getrChild() {
		return rChild;
	}

	public void setrChild(TreeNode rChild) {
		this.rChild = rChild;
	}

}
