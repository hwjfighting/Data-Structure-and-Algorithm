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
		
		System.out.println("索引2处的元素："+s1.get(2));
		
		s1.insert("A");
		
		System.out.println("A元素第一次出现的位置："+s1.indexOf("A"));
		
		System.out.println("第一个元素："+s1.getFirst());
		System.out.println("最后一个元素："+s1.getLast());
		
		s1.clear();
		System.out.println("长度："+s1.length());
		
		
	}
}
