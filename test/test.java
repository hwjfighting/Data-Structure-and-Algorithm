package test;

import linear.TowWayLinkList;

public class test {
	public static void main(String[] args) {
		/*SequenceList<String> s1=new SequenceList<>(2);
		
		s1.insert("A");
		s1.insert("B");
		
//		System.out.println(s1.length());
		
		s1.insert(0, "C");
//		System.out.println(s1.length());
		System.out.println("===================");
		
		for (String s : s1) {
			System.out.println(s);
		}
		
		System.out.println("===================");
		
		System.out.println(s1.get(2));
		
		s1.insert("A");
		
		System.out.println(s1.indexOf("A"));
		
		s1.clear();
		System.out.println(s1.length());
		*/
		
		/*LinkList<String> s1=new LinkList<>();
		
		s1.insert("A");
		s1.insert("B");
		
//		System.out.println(s1.length());
		
		s1.insert(0, "C");
//		System.out.println(s1.length());
		System.out.println("===================");
		
		for (String s : s1) {
			System.out.println(s);
		}
		
		System.out.println("===================");
		
		System.out.println(s1.get(2));
		
		s1.insert("A");
		
		System.out.println(s1.indexOf("A"));
		
		s1.clear();
		System.out.println(s1.length());
		*/
		
		
		TowWayLinkList<String> s1=new TowWayLinkList<>();
		
		s1.insert("A");
		s1.insert("B");			
		s1.insert(0, "C");
		System.out.println("===================");
		
		for (String s : s1) {
			System.out.println(s);
		}
		
		System.out.println("===================");
		
		System.out.println("����2����Ԫ�أ�"+s1.get(2));
		
		s1.insert("A");
		
		System.out.println("AԪ�ص�һ�γ��ֵ�λ�ã�"+s1.indexOf("A"));
		
		System.out.println("��һ��Ԫ�أ�"+s1.getFirst());
		System.out.println("���һ��Ԫ�أ�"+s1.getLast());
		
		s1.clear();
		System.out.println("���ȣ�"+s1.length());
		
		
	}
}
