package linear;

import java.util.Iterator;

public class TowWayLinkList<T> implements Iterable<T>{
	//首结点
	private Node head;
	//最后一个结点
	private Node last;
	//链表的长度
	private int N;
	
	
	//结点类
	private class Node{
		//存储数据
		public T item;
		//指向上一个结点
		public Node pre;
		//指向下一个结点
		public Node next;
		
		public Node(T item,Node pre,Node next) {
			this.item=item;
			this.pre=pre;
			this.next=next;
			
		}
	}
	
	public TowWayLinkList() {
		//初始化头结点和尾结点
		this.head=new Node(null,null,null);
		this.last=null;
		//初始化元素个数
		this.N=0;
	}
	
	//清空列表
	public void clear() {
		this.head=null;
		this.last=null;
		this.N=0;
	}
	
	//获取链表长度
	public int length() {
		return N;
	}
	
	//判断链表是否为空
	public boolean isEmpty() {
		return N==0;
	}
	
	//获取第一个元素
	public T getFirst() {
		if(isEmpty()) {
			return null;
		}
		return head.next.item;
	}
	
	//获取最后一个元素
	public T getLast() {
		if(isEmpty()) {
			return null;
		}
		return last.item;
	}
	
	//插入元素t
	public void insert(T t) {
		if(isEmpty()) {
			//如果链表为空
			//创建新结点
			Node newNode=new Node(t,head,null);
			//让新结点称为尾结点
			last=newNode;
			//头结点指向尾结点
			head.next=last;
		}else {
			//如果链表不为空
			//找出当前尾结点
			Node oldLast=last;
			//创建新结点
			Node newNode=new Node(t,oldLast,null);
			//让当前尾结点指向新节点
			oldLast.next=newNode;
			//新节点称为尾结点
			last=newNode;
		}
		//元素个数+1
		N++;
	}
	
	//向指定位置i处插入元素
	public void insert(int i,T t) {
		//找到i位置的前一个结点
		Node pre=head;
		for(int index=0;index<i;index++) {
			pre=pre.next;
		}
		//找到i位置的节点
		Node curr=pre.next;
		//创建新节点
		Node newNode=new Node(t,pre,curr);
		//让i位置的前一个结点的下一个结点变为新节点
		pre.next=newNode;
		//让i位置的前一个结点变为新结点
		curr.pre=newNode;
		//元素个数+1
		N++;
	} 
	
	//获取指定位置i处的元素
	public T get(int i) {
		Node n=head.next;
		for(int index=0;index<i;index++) {
			n=n.next;
		}
		return n.item;
		
	}
	
	//找到元素t在链表中第一次出现的位置
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
	
	
	//删除i处的元素，并返回该元素
	public T remove(int i) {
		//找到i位置的前一个结点
		Node pre=head;
		for(int index=0;index<i;index++) {
			pre=pre.next;
		}
		
		//找到i位置的结点
		Node curr=pre.next;
		//找到i位置的后一个结点
		Node nextNode=curr.next;
		//让i位置的前一个结点的后一个结点变为i位置的下一个结点
		pre.next=nextNode;
		//让i位置的下一个结点的上一个结点变为i位置的前一个结点
		nextNode.pre=pre;
		//元素个是-1
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
