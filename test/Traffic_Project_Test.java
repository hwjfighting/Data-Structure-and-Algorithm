package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import uf.UF_Tree_Weighted;;

public class Traffic_Project_Test {
	public static void main(String[] args) throws Exception{
		
		//����һ�������ȡ��BufferReader
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("txt\\traffic_project.txt")));
		
		//��ȡһ������20
		int totalNumber=Integer.parseInt(br.readLine());
		
		//����һ�����鼯����
		UF_Tree_Weighted uf=new UF_Tree_Weighted(totalNumber);
		
		//��ȡ�ڶ�������7
		int roadNumber=Integer.parseInt(br.readLine());
		
		//ѭ����ȡ7����·
		for(int i=1;i<=roadNumber;i++) {
			String line=br.readLine();
			String[] str=line.split(" ");
			int p=Integer.parseInt(str[0]);
			int q=Integer.parseInt(str[1]);
			
			//���ò��鼯�����union������������������
			uf.union(p, q);
			
		}
		
				
		//��ȡ��ǰ���鼯�з��������-1�Ϳ��Եõ�����Ҫ�޽��ĵ�·����Ŀ
		int roads=uf.count()-1;
		
		System.out.println("����Ҫ�޽�"+roads+"����·������ʵ�ֳ�ͨ����");
	}
	

}
