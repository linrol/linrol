package com.linrol.algorithm.dg;

public class NodeTraverse {

	/**
	 * Generate a random tree node
	 * @return
	 */
	public static Node makeRandomTreeNode(){
		Node root = new Node();
		root.setValue("-");
		
		Node subroot1 = new Node();
		subroot1.setValue("+");
		subroot1.setParentNode(root);
		root.setLeftNode(subroot1);
		
		Node subroot2 = new Node();
		subroot2.setValue("d");
		subroot2.setParentNode(root);
		root.setRightNode(subroot2);
		
		Node subroot3 = new Node();
		subroot3.setValue("a");
		subroot3.setParentNode(subroot1);
		subroot1.setLeftNode(subroot3);
		
		Node subroot4 = new Node();
		subroot4.setValue("*");
		subroot4.setParentNode(subroot1);
		subroot1.setRightNode(subroot4);
		
		Node subroot5 = new Node();
		subroot5.setValue("b");
		subroot5.setParentNode(subroot4);
		subroot4.setLeftNode(subroot5);
		
		Node subroot6 = new Node();
		subroot6.setValue("c");
		subroot6.setParentNode(subroot4);
		subroot4.setRightNode(subroot6);
		
		return root;
	}
	
	public static String toPrefixExpression(Node root){
		if(root == null) {
			return "";
		}
		return root.getValue() + toPrefixExpression(root.getLeftNode()) + toPrefixExpression(root.getRightNode());
	}
	
	public static void main(String[] args) {
		System.out.println(toPrefixExpression(makeRandomTreeNode()));
	}
}
