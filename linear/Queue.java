package linear;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{
	//��¼�׽��
	private Node head;	
	//��¼���һ�����
	private  Node last;
	//��¼������Ԫ�صĸ���
	private int N;
	
	private class Node {
		public T item;
		public Node next;
		public Node(T item,Node next) {
			this.item=item;
			this.next=next;
		}
		
	}
	public Queue() {
		this.head=new Node(null,null);
		this.last=null;
		this.N=0;
	}
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return N==0;
	}
	//���ض�����Ԫ�صĸ���
	public int size() {
		return N;
	}
	//������в���Ԫ��t
	public void enqueue(T t) {
		if(last==null) {
			//��ǰβ���lastΪnull
			last=new Node(t,null);
			head.next=last;
		}else {
			//��ǰβ���Ϊlast��Ϊnull
			Node oldLast=last;
			last=new Node(t,null);
			oldLast.next=last;
		}
		//Ԫ�ظ���+1
		N++;
	}
	//�Ӷ������ó�һ��Ԫ��
	public T dequeue() {
		if(isEmpty()) {
			return null;
		}
		Node oldFirst=head.next;
		head.next=oldFirst.next;
		N--; 
		//��Ϊ��������ʵ����ɾ��Ԫ�أ������������е�Ԫ�ر�ɾ�����ˣ���Ҫ��ֵlast=null;
		if(isEmpty()) {
			last=null;
		}
		return oldFirst.item;
		
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new QIterator();
	}
	
	private class QIterator implements Iterator{
		private Node n;
		
		public QIterator() {
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
