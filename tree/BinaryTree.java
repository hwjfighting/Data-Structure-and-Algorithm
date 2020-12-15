package tree;

import linear.Queue;

public class BinaryTree<Key extends Comparable<Key>,Value> {
	//��¼���ڵ�
	private Node root;
	//��¼����Ԫ�صĸ���
	private int N;
	private class Node{
		//�洢��
		public Key key;
		//�洢ֵ
		private Value value;
		//��¼���ӽڵ�
		public Node left;
		//��¼���ӽڵ�
		public Node right;
		
		public Node(Key key,Value value,Node left,Node right) {
			this.key=key;
			this.value=value;
			this.left=left;
			this.right=right;
		}
		
	}
	
	//��ȡ����Ԫ�صĸ���
	public int size() {
		return N;
	}
	
	//���������Ԫ��key-value
	public void put(Key key,Value value)  {
		root=put(root,key,value);
	}
	
	//��ָ������x�����key-value,���������Ԫ�غ��µ���
	public Node put(Node x,Key key,Value value) {
		//���x����Ϊ��
		if(x==null) {
			N++;
			return new Node(key,value,null,null);
		}
		//���x������Ϊ��
		//�Ƚ�x���ļ���key�Ĵ�С
		
		int cmp=key.compareTo(x.key);
		if(cmp>0) {
			//���key����x���ļ����������x����������
			x.right=put(x.right,key,value);
		}else if(cmp<0) {
			//���keyС��x���ļ����������x����������
			x.left=put(x.left,key,value);
		}else {
			//���key����x���ļ������滻x����ֵΪvalue����
			x.value=value;
		}
		
		return x;
	}
	//��ѯ����ָ��key��Ӧ��value
	public Value get(Key key) {
		return get(root,key);
	}
	
	//��ָ������x�У�����key��Ӧ��ֵ
	public Value get(Node x,Key key) {
		//x��Ϊnull
		if(x==null) {
			return null;
		}
		//x����Ϊnull
		//�Ƚ�x���ļ���key�Ĵ�С	
		int cmp=key.compareTo(x.key);
		if(cmp>0) {
			//���key����x���ļ����������x����������
			return get(x.right,key);
		}else if(cmp<0) {
			//���keyС��x���ļ����������x����������
			return get(x.left,key);
		}else {
			//���key����x���ļ������滻x����ֵΪvalue����
			return x.value;
		}
	
	}
	
	//ɾ������key��Ӧ��value
	public void delete(Key key) {
		delete(root,key);
	}
	
	//ɾ��ָ����x�е�key��Ӧ��value��������ɾ���������
	public Node delete(Node x,Key key) {


		//x��Ϊnull
		if(x==null) {
			return null;
		}
		//x����Ϊnull
		//�Ƚ�x���ļ���key�Ĵ�С	
		int cmp=key.compareTo(x.key);
		if(cmp>0) {
			//���key����x���ļ����������x����������
			x.right=delete(x.right,key);
		}else if(cmp<0) {
			//���keyС��x���ļ����������x����������
			x.left=delete(x.left,key);
		}else {
//			Ԫ�ظ���-1
			N--;
			//���key����x���ļ������������ɾ���ڵ㶯����Ҫɾ���Ľڵ����x
			//���ҵ�����������С�Ľ��
			if(x.right==null) {
				return x.left;
			}
			if(x.left==null) {
				return x.right;
			}
			
			Node minNode=x.right;
			while(minNode.left!=null) {
				minNode=minNode.left;
			}
			
			//ɾ������������С�Ľ��
			Node n=x.right;
			while(n.left!=null) {
				if(n.left.left==null) {
					n.left=null;
				
				}else {
					//�任n��㼴��
					n=n.left;
				}
			}
			//��x������������ΪminNode��������
			minNode.left=x.left;
			//��x������������ΪminNode��������
			minNode.right=x.right;
			//��x���ĸ��ڵ�ָ��minNode
			x=minNode;
			
		
		}
		return x;
	}
	//�ҳ�����������С�ļ�
	public Key min() {
		return min(root).key;
	}
	
	//��ָ����x���ҳ���С�����ڵĽ��
	private Node min(Node x) {
		//��Ҫ�ж�x����û�����ӽ�㣬����У�����������ң����û�У���x������С�����ڵĽ��
		if(x.left!=null) {
			return min(x.left);
		}else {
			return x;
		}
		
	}
	//�ҳ������������ļ�
	public Key max() {
		return max(root).key;
	}
	
	//��ָ����x���ҳ��������ڵĽ��
	private Node max(Node x) {
		//��Ҫ�ж�x����û�����ӽ�㣬����У�����������ң����û�У���x������С�����ڵĽ��
		if(x.left!=null) {
			return min(x.left);
		}else {
			return x;
		}
		
	}
	
	//ʹ�������������ȡ�����������еļ�
	public Queue<Key> preErgodic(){
		Queue<Key> keys=new Queue<>();
		preErgodic(root,keys);
		return keys;
		
	}
	//ʹ�������������ȡָ����x�����м������ŵ�keys������
	private void preErgodic(Node x,Queue<Key> keys) {
		if(x==null) {
			return; 
		}
		//��x����key�ŵ�keys��
		keys.enqueue(x.key);
		//�ݹ����x����������
		if(x.left!=null) {
			preErgodic(x.left,keys);
		}
		//�ݹ����x����������
		if(x.right!=null) {
			preErgodic(x.right,keys);
		}
	}
	
	//ʹ�����������ȡ�������еļ�
	public Queue<Key> midErgodic(){
		Queue<Key> keys=new Queue<>();
		midErgodic(root,keys);
		return keys;		
	}
	
	//ʹ�������������ȡָ����x�����еļ�������ŵ�key��
	private void midErgodic(Node x,Queue<Key> keys) {
		if(x==null) {
			return;
		}
		//�ȵݹ飬���������еļ��ŵ�keys��
		if(x.left!=null) {
			midErgodic(x.left,keys);
		}
		//�ѵ�ǰ���x�ļ��ŵ�keys��
		keys.enqueue(x.key);
		//�ٵݹ飬���������еļ��ŵ�keys��
		if(x.right!=null) {
			midErgodic(x.right,keys);
		}
	}
	
	
	//ʹ�ú��������ȡ�������еļ�
	public Queue<Key> afterErgodic(){
		Queue<Key> keys=new Queue<>();
		afterErgodic(root,keys);
		return keys;		
	}
	
	//ʹ�ú����������ȡָ����x�����еļ�������ŵ�key��
	private void afterErgodic(Node x,Queue<Key> keys) {
		if(x==null) {
			return;
		}
		//�ȵݹ飬���������еļ��ŵ�keys��
		if(x.left!=null) {
			afterErgodic(x.left,keys);
		}
		//�ٵݹ飬���������еļ��ŵ�keys��
		if(x.right!=null) {
			afterErgodic(x.right,keys);
		}
		//�ѵ�ǰ���x�ļ��ŵ�keys��
		keys.enqueue(x.key);
		
	}
	
	//ʹ�ò����������ȡ�����������еļ�
	public Queue<Key> layerErgodic(){
		//�����������У��ֱ�洢���еļ������еĽ��
		Queue<Key> keys=new Queue<>();
		Queue<Node> nodes=new Queue<>();
		
		//Ĭ�ϣ��������������ڵ�
		nodes.enqueue(root);
		
		while(!nodes.isEmpty()) {
			//�Ӷ����е���һ����㣬��key���뵽keys��
			Node n=nodes.dequeue();
			keys.enqueue(n.key);
			//�жϵ�ǰ��㻹��û�����ӽڵ㣬����У������nodes��
			if(n.left!=null) {
				nodes.enqueue(n.left);
			}
			//�жϵ�ǰ��㻹��û�����ӽڵ㣬����У������nodes��
			if(n.right!=null) {
				nodes.enqueue(n.right);
			}
		}
		return keys;
	}
	
	//��ȡ��������������
	public int maxDepth() {
		return maxDepth(root);
				
	}
	
	//��ȡָ����x��������
	private int maxDepth(Node x) {
		if(x==null) {
			return 0;
		}
		//x��������
		int max=0;
		//��������������
		int maxL=0;
		//��������������
		int maxR=0;
		
		//������������������
		if(x.left!=null) {
			maxL=maxDepth(x.left);
		}
		//������������������
		if(x.right!=null) {
			maxR=maxDepth(x.right);
		}
		
		max=maxL>maxR?maxL+1:maxR+1;
		
		return max;
	}
	
	
	
	
	
}
