package com.opensam.ft;

import java.util.ArrayList;
import java.util.List;

public class HorizontalDistance {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.right.right = new Node(45);
		HorizontalDistance h = new HorizontalDistance();
		System.out.println("Distance between 45 and 20 is : "
+ h.findDistance(root, 45, 20));
	}

	public int findDistance(Node root, int i, int j) {
		int x = pathLength(root, i) - 1;
		int y = pathLength(root, j) - 1;
		
		int lcaData = findLCA(root, i, j).data;
		int z = pathLength(root, lcaData) -1;
		return x + y -2*z;
	}

	private Node findLCA(Node root, int i, int j) {
		if(root != null){
			if(root.data == i || root.data == j ){
				return root;
			}
			
			Node left = findLCA(root.left,i,j);
			Node right = findLCA(root.right,i,j);
			
			if(left!=null && right !=null){
				return root;
			} else if(left!=null){
				return left;
			} else {
				return right;
			}
		}
		return null;
	}

	private int pathLength(Node root, int i) {
		if(root != null){
			int x = 0;
			
			if((root.data == i) || (x = pathLength(root.left, i)) > 0 || (x = pathLength(root.right, i)) > 0){
				return x + 1;
			}
		}
		return 0;
	}

}
