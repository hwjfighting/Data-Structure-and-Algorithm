package linear;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T>{
	//��¼ͷ���
	private Node head;
	//��¼����ĳ���
	private int N;
	
	//�����
	private class Node{
		//�洢����
		T item;
		//��һ�����
		Node next;
		public Node(T item,Node next) {
			this.item=item;
			this.next=next;
		}
	}
	
	public LinkList() {
		//��ʼ��ͷ���
		this.head=new Node(null,null);
		//��ʼ��Ԫ�ظ���
		this.N=0;
	}
	
	//�������
	public void clear() {
		head.next=null;
		this.N=0;
	}
	
	//��ȡ����ĳ���
	public int length() {
		return N;
	}
	
	//�ж������Ƿ�Ϊ��
	public boolean isEmpty() {
		return N==0;
	}
	
	//��ȡָ��λ��i����Ԫ��
	public T get(int i) {
		//ͨ��ѭ������ͷ��㿪ʼ�����ң�һ����i�Σ��Ϳ����ҵ���Ӧ��Ԫ��
		Node n=head.next;
		for(int index=0;index<i;index++) {
			n=n.next;
		}
		return n.item;
	}
	
	//�����������Ԫ��t
	public void insert(T t) {
		//�ҵ���ǰ���Ľ��
		Node n=head;
		while(n.next!=null) {
			n=n.next;
		}
		
		//�����½��
		Node newNode=new Node(t,null);
		
		//�õ�ǰ���һ����㣬ָ���½��
		n.next=newNode;
		
		//Ԫ�ظ���+1
		N++;
	}
	
	//��ָ��λ��i�������Ԫ��t
	public void insert(int i,T t) {
		//�ҵ�iλ�õ�ǰһ�����
		Node pre=head;
		for(int index=0;index<=i-1;index++) {
			pre=pre.next;
		}
		
		//�ҵ�iλ�õĽ��
		Node curr=pre.next;
		
		//�����½�㣬�����½����Ҫָ��ԭ��iλ�õĽ��
		Node newNode=new Node(t,curr);
		
		//ԭ��iλ�õ�ǰһ���ڵ�ָ���½��
		pre.next=newNode;
		
		//Ԫ�صĸ���+1
		N++;
		
		
	}
	
	//ɾ��ָ��λ��i����Ԫ�أ������ر�ɾ����Ԫ��
	public T remove(int i) {
		//�ҵ�iλ�õ�ǰһ�����
		Node pre=head;
		for(int index=0;index<=i-1;index++) {
			pre=pre.next;
		}
		//�ҵ�iλ�õĽ��
		Node curr=pre.next;
		
		//�ҵ�iλ�õ���һ�����
		Node nextNode=curr.next;
		//ǰһ���ڵ�ָ����һ�����
		pre.next=nextNode;
		//Ԫ�ظ���-1
		N--;
		return curr.item;
	}
	
	//����Ԫ��t�������е�һ�γ��ֵ�λ��
	public int indexOf(T t) {
		Node n=head;
		for(int i=0;n.next!=null;i++) {
			n=n.next;
			if(n.item.equals(t)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LIterator();
	}
	
	private class LIterator implements Iterator{
		private Node n;
		public LIterator() {
			this.n=head;
		}

		@Override
		public boolean hasNext() {
			
			return n.next!=null;
		}

		@Override
		public Object next() {
			n=n.next;
			return n.item;
		}
		
	}
	
	//������ת��������
	public void reverse() {
		//�жϵ�ǰ�����Ƿ�Ϊ����������ǿ�������������У�������ǣ���������ص�reverse�������з�ת
		if(isEmpty()) {
			return;
		}
		reverse(head.next);
		
	}
	
	//��תָ���Ľ��curr,���ѷ�ת��Ľ�㷵��
	public Node reverse(Node curr) {
		if(curr.next==null) {
			head.next=curr;
			return curr;
		}
		//�ݹ�ķ�ת��ǰ���curr����һ����㣬����ֵ��������ת�󣬵�ǰ������һ�����
		Node pre=reverse(curr.next);
		//�õ�ǰ������һ������Ϊ��ǰ���curr��
		pre.next=curr;
		//�ѵ�ǰ������һ������Ϊnull
		curr.next=null;
		return curr;
	}

}
