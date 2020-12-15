package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import graph.DepthFirstPaths;
import graph.Graph;
import linear.Stack;

public class DepthFirstPathsTest {

	public static void main(String[] args) throws Exception {
		//������ȡ��BufferReader
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("txt\\road_find.txt")));
	
		//��ȡ��һ������6
		int total=Integer.parseInt(br.readLine());
		
		//���ݵ�һ�����ݹ���һ��ͼGraph
		Graph G=new Graph(total);
		//��ȡ�ڶ�������
		int edgeNumbers=Integer.parseInt(br.readLine());
		//����ͨ��ѭ����ȡÿһ���߹������������㣬����addEdge��������ӱ�
		for(int i=1;i<=edgeNumbers;i++) {
			String edge=br.readLine();
			String[] str=edge.split(" ");
			int v=Integer.parseInt(str[0]);
			int w=Integer.parseInt(str[1]);
			G.addEdge(v, w);
		}
		
		//����·�����Ҷ��󣬲��������Ϊ0��
		DepthFirstPaths paths=new DepthFirstPaths(G,0);
		//����pathTo(4) �ҵ������0���յ�4��·��������stack
		Stack<Integer> path=paths.pathTo(4);
		StringBuilder sb=new StringBuilder();
		//����ջ����
		for(Integer v:path) {
			sb.append(v+"-");
		}
		sb.deleteCharAt(sb.length()-1);
		
		System.out.println(sb);
		
	}

}
