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
		//创建一副加权有向图
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
		//创建DijstraSP对象，查找最短路径树
		DijkstraSP dijstraSP = new DijkstraSP(G,0);
		
		//查找最短路径,0->6的最短路径
		Queue<DirectedEdge> edges = dijstraSP.pathTo(6);
		
		//遍历打印
		for (DirectedEdge edge : edges) {
			System.out.println(edge.from()+"->"+edge.to()+":"+edge.weight());
		}
		
	}
}
