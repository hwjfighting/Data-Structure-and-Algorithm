package heimaSort;
/*
 * 定义测试类Test，在测试类Test中定义测试方法Comparable getMax(Comparable c1,Comparable C2)完成测试
 */

public class TestComparable {
	public static void main(String[] args) {
		Student s1=new Student();
		s1.setUsername("张三");
		s1.setAge(18);
		Student s2=new Student();
		s2.setUsername("李四");
		s2.setAge(20);
		
		System.out.println(getMax(s1,s2));
		
	}
	public static Comparable getMax(Comparable c1,Comparable c2) {
		int result=c1.compareTo(c2);
		if(result>0)
			return c1;
		else
			return c2;
		
	}

}
