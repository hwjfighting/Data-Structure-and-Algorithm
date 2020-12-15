package graph;

public class DepthFirstSearch {
	//���������㣬ֵ��ʾ��ǰ�����Ƿ��Ѿ�������
	private boolean[] marked;
	//��¼�ж��ٸ�������s������ͨ
	private int count;
	
	//�������������������ʹ����������ҳ�Gͼ��s������������ڶ���
	public DepthFirstSearch(Graph G,int s) {
		//��ʼ��marked����
		this.marked=new boolean[G.V()];
		//��ʼ��������s��ͨ�Ķ��������
		this.count=0;
		
		dfs(G,s);
	}
	
	//ʹ��������������ҳ�Gͼ��v������������ڶ���
	private void dfs(Graph G,int v) {
		//��v�����ʶΪ������
		marked[v]=true;
		
		for(Integer w: G.adj(v)) {
			//�жϵ�ǰw������û�б������������û�б�����������ݹ����dfs���������������
			if(!marked[w]) {
				dfs(G,w);
			}
		}
		
		//��ͨ��������+1
		count++;
	}
	
	//�ж�w������s�����Ƿ���ͨ
	public boolean marked(int w) {
		return marked[w];
	}
	
	//��ȡ�붥��s��ͨ�����ж��������
	public int count() {
		return count;
	}

}
