package test;

import tree.RedBlackTree;

public class RedBlackTreeTest {
	public static void main(String[] args) {
		//���������
		RedBlackTree<String,String> tree=new RedBlackTree<>();
		
		//�����в���Ԫ��
		tree.put("1", "����");
		tree.put("2", "����");
		tree.put("3", "����");
		
		//�����л�ȡԪ��
		String r1=tree.get("1");
		System.out.println(r1);
		String r2=tree.get("2");
		System.out.println(r2);
		String r3=tree.get("3");
		System.out.println(r3);
		
		
	
	}
}
