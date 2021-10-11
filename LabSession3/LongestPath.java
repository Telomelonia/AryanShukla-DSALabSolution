package LabSession3;

import java.util.*;

class LongestPath
{
	static class Node 
	{
		Node leftNode;
		Node rightNode;
		int nodeData;
	}
	static Node newNode(int nodeData) 
    {
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
	}
	public static ArrayList<Integer> LongestPath(Node root) {

		// If root = null return a empty set 
		if (root == null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}
		// Recursion of root.rightNode
		ArrayList<Integer> rightNode = LongestPath(root.rightNode);

		// Recursion of root.leftNode
		ArrayList<Integer> leftNode = LongestPath(root.leftNode);

		// size comparison of the two ArrayList
        //according to which current node is inserted
		if (rightNode.size() < leftNode.size()) 
        {
			leftNode.add(root.nodeData);
		}    
        else 
        {
			rightNode.add(root.nodeData);
		}
		// Return desired ArrayList
		return (leftNode.size() > rightNode.size() ? leftNode : rightNode);
	}





	// Driver Code
	public static void main(String[] args) 
    {
		Node root = newNode(100);
		root.leftNode = newNode(20);
		root.rightNode = newNode(130);
		root.leftNode.leftNode = newNode(10);
		root.leftNode.rightNode = newNode(50);
		root.rightNode.leftNode = newNode(110);
		root.rightNode.rightNode = newNode(140);
		root.leftNode.leftNode.leftNode = newNode(5);


		ArrayList<Integer> output = LongestPath(root);
		int size = output.size();

		System.out.print(output.get(size - 1));
		for (int i = size - 2; i >= 0; i--) 
        {
			System.out.print(" -> " + output.get(i));
		}
	}
}
