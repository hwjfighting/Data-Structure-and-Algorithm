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
		//准备一幅加权无向图
		//构建一个缓冲读取流BufferReader
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
			
			//构建加权无向边
			Edge edge = new Edge(v,w,weight);
			G.addEdge(edge);
		}
		
		//创建一个kruskalMST对象，计算加权无向图中的最小生成树
		KruskalMST kruskalMST = new KruskalMST(G);
		
		//获取最小生成树中的所有边
		Queue<Edge> edges = kruskalMST.edges();
		
		//遍历打印所有的边
		for (Edge e : edges) {
			int v = e.either();
			int w = e.other(v);
			double weight = e.weight();
			System.out.println(v+"-"+w+":"+weight);
		}
	
	}

}
