package graph;

public class DirectedCycle {
	//���������㣬ֵ��ʾ��ǰ�����Ƿ��Ѿ�������
	private boolean[] marked;
	//��¼ͼ���Ƿ��л�
	private boolean hasCycle;
	//���������㣬ֻ��ջ��˼�룬��¼��ǰ������û���Ѿ�������������������·����
	private boolean[] onStack;
	
	//����һ�������󣬼��ͼG���Ƿ��л�
	public DirectedCycle(Digraph G) {
		//��ʼ��marked����
		this.marked = new boolean[G.V()];
		//��ʼ��hasCycle
		this.hasCycle = false;
		//��ʼ��onStack����
		this.onStack = new boolean[G.V()];
		
		//�ҵ�ͼ��ÿ�����㣬��ÿһ��������Ϊ��ڣ�����һ��dfs��������
		for(int v = 0;v<G.V();v++) {
			//�ж������ǰ���㻹û���������������dfs��������
			if(!marked[v]) {
				dfs(G,v);
			}
		}
	}
	
	//��������������������ͼG���Ƿ��л�
	private void dfs(Digraph G,int v) {
		//�Ѷ���v��ʾΪ������
		marked[v] = true;
		//�ѵ�ǰ�����ջ
		onStack[v] = true;
		
		//�����������
		for (Integer w : G.adj(v)) {
			//�ж������ǰ����wû�� �����ع���������ݹ����dfs������������������
			if(!marked[w]) {
				dfs(G,w);
			}
			//�����ǰ����w�Ƿ��Ѿ���ջ�У�����Ѿ���ջ�У�֤����ǰ����֮ǰ��������������״̬����ô������Ҫ����һ�Σ�֤����⵽����
			if(onStack[w]) {
				hasCycle = true;
				return;
			}
		}
		
		//�ѵ�ǰ����ջ
		onStack[v] = false;
	}
	
	//�ж�w������s�����Ƿ���ͨ
	public boolean hasCycle() {
		return hasCycle;
	}
	

}
