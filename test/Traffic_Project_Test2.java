package test;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.InputStreamReader;

import graph.DepthFirstSearch;
import graph.Graph;

public class Traffic_Project_Test2 {
	public static void main(String[] args) throws Exception {
		//����һ�������ȡ��BufferReader
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("txt\\traffic_project.txt")));
		//��ȡһ������20
		int totalNumber=Integer.parseInt(br.readLine());
		//����һ��ͼGraph����
		Graph G=new Graph(totalNumber);
		
		//��ȡ�ڶ�������7
		int roadNumber=Integer.parseInt(br.readLine());
		//ѭ����ȡ���޴Σ�7������ȡ�Ѿ��޺õĵ�·
		for(int i=1;i<=roadNumber;i++) {
			String road=br.readLine();
			String[] str=road.split(" ");
			int v=Integer.parseInt(str[0]);
			int w=Integer.parseInt(str[1]);
			//����ͼ��addEdge�������ѱ���ӵ�ͼ�У���ʾ�Ѿ��޽��õĵ�·
			G.addEdge(v, w);
		}
		//����һ������������������������Ϊ����9
		DepthFirstSearch search=new DepthFirstSearch(G,9);
		//����markd�������ж�8�����10�����Ƿ��������ͨ
		System.out.println("����8�Ͷ���9�Ƿ���ͨ"+search.marked(8));
		System.out.println("����10�Ͷ���9�Ƿ���ͨ"+search.marked(10));
		
		
	}

}
