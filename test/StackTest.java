package test;

import linear.Stack;

public class StackTest {
	public static void main(String[] args) {
		//创建栈对象
		Stack<String> stack=new Stack<>();
		//测试压栈
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.push("e");
		for (String string : stack) {
			System.out.println(string);
		}
		
		
		//测试弹栈
		String result = stack.pop();
		System.out.println("弹出的元素："+result);
		System.out.println("剩余元素的个数"+stack.size());
	}
}
