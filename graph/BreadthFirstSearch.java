package graph;

import linear.Queue;

public class BreadthFirstSearch {
	//���������㣬ֵ��ʾ��ǰ�����Ƿ��Ѿ�������
	private boolean[] marked;
	//��¼�ж��ٸ�������s������ͨ
	private int count;
	//�����洢�������ڽӱ�ĵ�
	private Queue<Integer> waitSearch;
	
	
	
	//������������������ʹ�ù����������Gͼ��s������������ڶ���
	public BreadthFirstSearch(Graph G,int s) {
		this.marked=new boolean[G.V()];
		this.count=0;
		this.waitSearch=new Queue<Integer>();
		bfs(G,s);
	}
	
	//ʹ�ù�����������ҳ�Gͼ��v������������ڶ���
	private void bfs(Graph G,int v) {
		//�ѵ�ǰ����v��ʶΪ������
		marked[v]=true;
		//�ö���v������У�������
		waitSearch.enqueue(v);
		//ͨ��ѭ����������в�Ϊ�գ���Ӷ����е���һ���������Ķ����������
		while(!waitSearch.isEmpty()) {
			//����һ���������Ķ���
			Integer wait=waitSearch.dequeue();
			
			//����wait������ڽӱ�
			for(Integer w:G.adj(wait)) {
				if(!marked[w]) {
					bfs(G,w);
				}
				
			}
		}
		
		//����ͨ�Ķ���+1
		count++;
	}
	
	//�ж�w������s�����Ƿ���ͨ
	public boolean marked(int w) {
		return marked[w];
	}
	
	//��ȡ�붥����ͨ�����ж��������
	public int count() {
		return count;
	}

}
