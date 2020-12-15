package test;

import linear.Queue;
import tree.BinaryTree;

public class BinaryTreeErgodic {

	public static void main(String[] args) {
		//����������
		BinaryTree<String,String> tree=new BinaryTree<>();
		//�������������
		tree.put("E", "5");
		tree.put("B", "2");
		tree.put("G", "7");
		tree.put("A", "1");
		tree.put("D", "4");
		tree.put("F", "6");
		tree.put("H", "8");
		tree.put("C", "3");
		
		//����
		Queue<String> keys=tree.preErgodic();
		for (String string : keys) {
			System.out.print(string);
		}
		System.out.println("===============");
		
		Queue<String> keys2=tree.midErgodic();
		for (String string : keys2) {
			System.out.print(string);
		}
		System.out.println("===============");
		
		
		Queue<String> keys3=tree.afterErgodic();
		for (String string : keys3) {
			System.out.print(string);
		}
		
		System.out.println("==============");
		Queue<String> keys4=tree.layerErgodic();
		for (String string : keys4) {
			System.out.print(string);
		}
		System.out.println("============");
		System.out.println(tree.maxDepth());

	}

}
