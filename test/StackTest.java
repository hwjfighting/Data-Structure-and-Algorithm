package test;

import linear.Stack;

public class StackTest {
	public static void main(String[] args) {
		//����ջ����
		Stack<String> stack=new Stack<>();
		//����ѹջ
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.push("e");
		for (String string : stack) {
			System.out.println(string);
		}
		
		
		//���Ե�ջ
		String result = stack.pop();
		System.out.println("������Ԫ�أ�"+result);
		System.out.println("ʣ��Ԫ�صĸ���"+stack.size());
	}
}
