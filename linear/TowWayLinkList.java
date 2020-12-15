package linear;

import java.util.Iterator;

public class TowWayLinkList<T> implements Iterable<T>{
	//�׽��
	private Node head;
	//���һ�����
	private Node last;
	//����ĳ���
	private int N;
	
	
	//�����
	private class Node{
		//�洢����
		public T item;
		//ָ����һ�����
		public Node pre;
		//ָ����һ�����
		public Node next;
		
		public Node(T item,Node pre,Node next) {
			this.item=item;
			this.pre=pre;
			this.next=next;
			
		}
	}
	
	public TowWayLinkList() {
		//��ʼ��ͷ����β���
		this.head=new Node(null,null,null);
		this.last=null;
		//��ʼ��Ԫ�ظ���
		this.N=0;
	}
	
	//����б�
	public void clear() {
		this.head=null;
		this.last=null;
		this.N=0;
	}
	
	//��ȡ������
	public int length() {
		return N;
	}
	
	//�ж������Ƿ�Ϊ��
	public boolean isEmpty() {
		return N==0;
	}
	
	//��ȡ��һ��Ԫ��
	public T getFirst() {
		if(isEmpty()) {
			return null;
		}
		return head.next.item;
	}
	
	//��ȡ���һ��Ԫ��
	public T getLast() {
		if(isEmpty()) {
			return null;
		}
		return last.item;
	}
	
	//����Ԫ��t
	public void insert(T t) {
		if(isEmpty()) {
			//�������Ϊ��
			//�����½��
			Node newNode=new Node(t,head,null);
			//���½���Ϊβ���
			last=newNode;
			//ͷ���ָ��β���
			head.next=last;
		}else {
			//�������Ϊ��
			//�ҳ���ǰβ���
			Node oldLast=last;
			//�����½��
			Node newNode=new Node(t,oldLast,null);
			//�õ�ǰβ���ָ���½ڵ�
			oldLast.next=newNode;
			//�½ڵ��Ϊβ���
			last=newNode;
		}
		//Ԫ�ظ���+1
		N++;
	}
	
	//��ָ��λ��i������Ԫ��
	public void insert(int i,T t) {
		//�ҵ�iλ�õ�ǰһ�����
		Node pre=head;
		for(int index=0;index<i;index++) {
			pre=pre.next;
		}
		//�ҵ�iλ�õĽڵ�
		Node curr=pre.next;
		//�����½ڵ�
		Node newNode=new Node(t,pre,curr);
		//��iλ�õ�ǰһ��������һ������Ϊ�½ڵ�
		pre.next=newNode;
		//��iλ�õ�ǰһ������Ϊ�½��
		curr.pre=newNode;
		//Ԫ�ظ���+1
		N++;
	} 
	
	//��ȡָ��λ��i����Ԫ��
	public T get(int i) {
		Node n=head.next;
		for(int index=0;index<i;index++) {
			n=n.next;
		}
		return n.item;
		
	}
	
	//�ҵ�Ԫ��t�������е�һ�γ��ֵ�λ��
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
	
	
	//ɾ��i����Ԫ�أ������ظ�Ԫ��
	public T remove(int i) {
		//�ҵ�iλ�õ�ǰһ�����
		Node pre=head;
		for(int index=0;index<i;index++) {
			pre=pre.next;
		}
		
		//�ҵ�iλ�õĽ��
		Node curr=pre.next;
		//�ҵ�iλ�õĺ�һ�����
		Node nextNode=curr.next;
		//��iλ�õ�ǰһ�����ĺ�һ������Ϊiλ�õ���һ�����
		pre.next=nextNode;
		//��iλ�õ���һ��������һ������Ϊiλ�õ�ǰһ�����
		nextNode.pre=pre;
		//Ԫ�ظ���-1
		return curr.item;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new TIterator();
	}
	
	private class TIterator implements Iterator{
		private Node n;
		public TIterator() {
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
	


}
