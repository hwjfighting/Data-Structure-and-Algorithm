package test;

import tree.BinaryTree;

public class BinaryTreeTest {
	public static void main(String[] args) {
		//�������������Ҷ���
		BinaryTree<Integer,String> tree=new BinaryTree();
		
		//���Բ���
		tree.put(1, "����");
		tree.put(2, "����");
		tree.put(3, "����");
		System.out.println("������Ϻ�Ԫ�صĸ���"+tree.size());
		
		//���Ի�ȡ
		System.out.println("��2��Ӧ��Ԫ���ǣ�"+tree.get(2));
		
		//����ɾ��
		tree.delete(3);
		System.out.println("ɾ�����Ԫ�ظ�����"+tree.size());
		System.out.println("ɾ�����3��Ӧ��Ԫ�أ�"+tree.get(3));
	}

}
