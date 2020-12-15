package heimaSort;
/*
 * Comparable接口介绍
 * 需求：1.定义个学生类Student ，具有年龄age和姓 名username两个属性，并通过Comparable接口提供比较规则 ;
2.定义测试类Test，在测试类Test中定义测试方法Comparable getMax(Comparable c1,Comparable C2)完成测试
 */

public class Student implements Comparable<Student>{
	private String username;
	private int age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [username=" + username + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Student o) {
		return this.getAge()-o.getAge();
	}
	
}
