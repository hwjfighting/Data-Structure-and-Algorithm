package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import graph.Edge;
import graph.EdgeWeightedGraph;
import graph.KruskalMST;
import linear.Queue;

public class KruskalMSTTest {

	public static void main(String[] args) throws Exception {
		//׼��һ����Ȩ����ͼ
		//����һ�������ȡ��BufferReader
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("txt\\min_create_tree_test.txt")));
		int total = Integer.parseInt(br.readLine());
		EdgeWeightedGraph G = new EdgeWeightedGraph(total);
		
		int edgeNumbers = Integer.parseInt(br.readLine());
		for(int e = 1;e<=edgeNumbers;e++) {
			String line = br.readLine();
			
			String[] strs = line.split(" ");
			
			int v = Integer.parseInt(strs[0]);
			int w = Integer.parseInt(strs[1]);
			
			double weight = Double.parseDouble(strs[2]);
			
			//������Ȩ�����
			Edge edge = new Edge(v,w,weight);
			G.addEdge(edge);
		}
		
		//����һ��kruskalMST���󣬼����Ȩ����ͼ�е���С������
		KruskalMST kruskalMST = new KruskalMST(G);
		
		//��ȡ��С�������е����б�
		Queue<Edge> edges = kruskalMST.edges();
		
		//������ӡ���еı�
		for (Edge e : edges) {
			int v = e.either();
			int w = e.other(v);
			double weight = e.weight();
			System.out.println(v+"-"+w+":"+weight);
		}
	
	}

}
