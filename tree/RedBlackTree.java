package tree;

public class RedBlackTree<Key extends Comparable<Key>,Value> {
	//���ڵ�
	private Node root;
	//��¼����Ԫ�صĸ���
	private int N;
	//��ɫ����
	private static final boolean RED=true;
	//��ɫ����
	private static final boolean BLACK=false;
	
	//�����
	private class Node{
		//�洢��
		public Key key;
		//�洢ֵ
		private Value value;
		//��¼���ӽ��
		public Node left;
		//��¼���ӽڵ�
		public Node right;
		//���丸�ڵ�ָ���������ӵ���ɫ
		public boolean color;
		
		public Node(Key key,Value value,Node left,Node right,boolean color) {
			this.key=key;
			this.value=value;
			this.left=left;
			this.right=right;
			this.color=color;
		}
		
	}
	//��ȡ����Ԫ�صĸ���
			public int size() {
				return N;
			}
			
			//�жϵ�ǰ���ĸ�ָ�������Ƿ�Ϊ��ɫ
			private boolean isRed(Node x) {
				if(x==null) {
					return false;
				}
				return x.color==RED;
			}
			
			//����ת
			private Node rotateLeft(Node h) {
				//��ȡh�������ӽ�㣬��ʾΪx
				Node x=h.right;
				//��x�������ӽ���Ϊh�������ӽ��
				h.right=x.left;
				//��h��Ϊx�������ӽ��
				x.left=h;
				//��x����color���Ե���h����color����
				x.color=h.color;
				//��h����color���Ա�Ϊ��ɫ
				h.color=RED;
				return x;
				
			}
			
			//����ת
			private Node rotateRight(Node h) {
				//��ȡh�������ӽڵ㣬��ʾx
				Node x=h.right;
				//��x�������ӽӵ��ǳ�Ϊh�������ӽڵ�
				h.left=x.right;
				//��h��Ϊx�������ӽ��
				x.right=h;
				//��x����color���Ե���h����color����
				x.color=h.color;
				//��x����color���Ա�Ϊ��ɫ
				h.color=RED;
				return x;
			}
			
			//��ɫ��ת���൱����ɲ��4-���
			private void flipColors(Node h) {
				//��ǰ����Ϊ��ɫ
				h.color=RED;
				//���ӽ������ӽ���Ϊ��ɫ
				h.left.color=BLACK;
				h.right.color=BLACK;
			}
			
			//������������ɲ������
			public void put(Key key,Value val) {
				root=put(root,key,val);
				//���ڵ����ɫ���Ǻ�ɫ
				root.color=BLACK;
			}
			
			//��ָ�����У���ɲ�����������������Ԫ�غ��µ���
			private Node put(Node h,Key key,Value val) {
				//�ж�h�Ƿ�Ϊ�գ����Ϊ����ֱ�ӷ���һ����ɫ�Ľ��Ϳ�����
				if(h==null) {
					//����+1
					N++;
					return new Node(key,val,null,null,RED);
				}
				//�Ƚ�h���ļ���key�Ĵ�С
				int cmp=key.compareTo(h.key);
				if(cmp<0) {
					//��������
					h.left=put(h.left,key,val);
				}else if(cmp>0) {
					//��������
					h.right=put(h.right,key,val);
				}else {
					//����ֵ���滻
					h.value=val;
				}
				//��������������ǰ���h�����ӽ��Ϊ��ɫ�����ӽڵ�Ϊ��ɫ����Ҫ����
				if(isRed(h.right)&&!isRed(h.left)) {
					h=rotateLeft(h);
				}
				//��������������ǰ���h�����ӽ������ӽ������ӽ��Ϊ��ɫ����Ҫ����
				if(isRed(h.left)&&isRed(h.left.left)) {
					h=rotateRight(h);
				}
				//��ɫ��ת����ǰ�������ӽ������ӽ�㶼Ϊ��ɫʱ����Ҫ��ɫ��ת
				if(isRed(h.left) && isRed(h.right)) {
					flipColors(h);
				}
				return h;
			}
			
			//����key���������ҳ���Ӧ��ֵ
			public Value get(Key key) {
				return get(root,key);
			}
			
			//��ָ������x�У�����key��Ӧ��ֵ
			public Value get(Node x,Key key) {
				if(x==null) {
					return null;
				}
				
				//�Ƚ�x���ļ���key�Ĵ�С
				int cmp=key.compareTo(x.key);
				if(cmp<0) {
					return get(x.left,key);
				}else if(cmp>0) {
					return get(x.right,key);
				}else {
					return x.value;
				}
				
			}

}
