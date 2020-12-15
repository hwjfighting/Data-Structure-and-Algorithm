package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import graph.DijkstraSP;
import graph.DirectedEdge;
import graph.EdgeWeightedDiagraph;
import linear.Queue;

public class DijstraSPTest {
	public static void main(String[] args) throws Exception {
		//����һ����Ȩ����ͼ
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("txt\\min_route_test.txt")));
		int total = Integer.parseInt(br.readLine());
		EdgeWeightedDiagraph G = new EdgeWeightedDiagraph(total);
		
		int edgeNumbers = Integer.parseInt(br.readLine());
		for(int i = 1;i<=edgeNumbers;i++) {
			String line = br.readLine();
			String[] strs = line.split(" ");
			int v = Integer.parseInt(strs[0]);
			int w = Integer.parseInt(strs[1]);
			
			double weight = Double.parseDouble(strs[2]);
			DirectedEdge e = new DirectedEdge(v,w,weight);
			G.addEdge(e);
		}
		//����DijstraSP���󣬲������·����
		DijkstraSP dijstraSP = new DijkstraSP(G,0);
		
		//�������·��,0->6�����·��
		Queue<DirectedEdge> edges = dijstraSP.pathTo(6);
		
		//������ӡ
		for (DirectedEdge edge : edges) {
			System.out.println(edge.from()+"->"+edge.to()+":"+edge.weight());
		}
		
	}
}
