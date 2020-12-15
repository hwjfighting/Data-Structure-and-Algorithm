package test;



import linear.Queue;

public class PagerFoldingTest {

	public static void main(String[] args) {
		//ģ����ֽ���̣�������
		Node<String> tree=createTree(3);
		//����������ӡÿ�����
		printTree(tree);
		
		
	}
	//ͨ��ģ�����N��ֽ��������
	public static Node<String> createTree(int N){
		//������ڵ�
		Node<String> root=null;
		for(int i=0;i<N;i++) {
			//1.���ǵ�һ�ζ���
			if(i==0) {
				root=new Node<>("down",null,null);
				continue;
			}
			//2.��ǰ���ǵ�һ�ζ���
			//����һ���������У�ͨ�����������˼�룬�ҵ�Ҷ�ӽ�㣬Ҷ�ӽ������ӽڵ�
			Queue<Node> queue=new Queue<>();
			queue.enqueue(root);
			while(!queue.isEmpty()) {
				//�Ӷ����е���һ�����
				Node<String> tmp=queue.dequeue();
				//��������ӽ�㣬������ӽ�㣬���뵽������
				if(tmp.left!=null) {
					queue.enqueue(tmp.left);
				}
				//��������ӽ�㣬������ӽ�㣬���뵽������
				if(tmp.right!=null) {
					queue.enqueue(tmp.right);
				}
				//���ͬʱû�����ӽ������ӽڵ㣬��ô֤���ý����Ҷ�ӽ�㣬ֻ��Ҫ���ý��������ӽ������ӽڵ�
				if(tmp.left==null&&tmp.right==null) {
					tmp.left=new Node<String>("down",null,null);
					tmp.right=new Node<String>("up",null,null);
				}
			}
			
		}
		return root;	
	}
	
	//��ӡ����ÿһ�����
	public static void printTree(Node<String> root) {
		//��Ҫʹ������������
		if(root==null) {
			return;
		}
		//��ӡ��������ÿ�����
		if(root.left!=null) {
			printTree(root.left);
		}
		//��ӡ��ǰ���
		System.out.print(root.item+" ");
		//��ӡ��������ÿ�����
		if(root.right!=null) {
			printTree(root.right);
		}
	}
	
	public static class Node<T> {
		public T item; //�洢Ԫ��
		public Node left;
		public Node right;
		
		public Node(T item,Node left,Node right) {
			this.item=item;
			this.left=left;
			this.right=right;
		}
	}

}
