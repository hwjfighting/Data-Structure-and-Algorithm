package heimaSort;
/*
 * Comparable�ӿڽ���
 * ����1.�����ѧ����Student ����������age���� ��username�������ԣ���ͨ��Comparable�ӿ��ṩ�ȽϹ��� ;
2.���������Test���ڲ�����Test�ж�����Է���Comparable getMax(Comparable c1,Comparable C2)��ɲ���
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
