package test;

import java.util.Scanner;

import uf.UF_Tree_Weighted;

public class UFTreeWeightedTest {
	public static void main(String[] args) {
		//�������鼯����
		UF_Tree_Weighted uf=new UF_Tree_Weighted(5);
		System.out.println("Ĭ������£����鼯���У�"+uf.count()+"������");
		
		//�ӿ���̨¼������Ҫ�ϲ���Ԫ�أ�����union�����ϲ����۲�ϲ��󲢲鼯�еķ����Ƿ����
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("�������һ��Ҫ�ϲ���Ԫ�أ�");
			int p=sc.nextInt();
			System.out.println("������ڶ���Ҫ�ϲ���Ԫ�أ�");
			int q=sc.nextInt();
			
			//�ж�������Ԫ���Ƿ��Ѿ���ͬһ����
			if(uf.connected(p, q)) {
				System.out.println(p+"Ԫ�غ�"+q+"Ԫ���Ѿ���ͬһ��������");
				continue;
			}
			uf.union(p, q);
			System.out.println("��ǰ���鼯�л��У�"+uf.count()+"������");
		}
	}
}

