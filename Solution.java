import java.util.ArrayList;
import java.util.List;


public class Solution {
	public boolean flag = false;
	int a[][];
	Node end;
	List<Node> node = new ArrayList<Node>();
	public Solution(int a[][],Node end){
		this.a = a;
		this.end = end;
	}
	public void findWay(Node start,int count) {
		//count���ڼ���������Ӧ�ڵ���ӵ�list��������,���ڴ�ӡ
		//�ڵ����أ�����Ѿ�������ֱ�ӷ��أ���ֹ���λ�·
		for(int i=0;i<count;i++){
			if(node.get(i).equals(start))
				return;
		}
		//���ڵ���ӵ�ָ��λ��
		if(node.size()-1<count){
			node.add(start);
		}else
			node.set(count,start);
		//���������β�ڵ�
		if(start.equals(end)){
			flag = true;
			for(int i=0;i<count+1;i++){
				System.out.print("("+node.get(i).getX()+","+node.get(i).getY()+")\t");
			}
			System.out.println();
		}else{
			//�ֱ𳯲�ͬ����ǰ��
			if((start.getX()+1)<a.length&&a[start.getX()+1][start.getY()]==0)
				findWay(new Node(start.getX()+1,start.getY()),count+1);
			if((start.getX()-1)>=0&&a[start.getX()-1][start.getY()]==0)
				findWay(new Node(start.getX()-1,start.getY()),count+1);
			if((start.getY()-1)>=0&&a[start.getX()][start.getY()-1]==0)
				findWay(new Node(start.getX(),start.getY()-1),count+1);
			if((start.getY()+1)<a[0].length&&a[start.getX()][start.getY()+1]==0)
				findWay(new Node(start.getX(),start.getY()+1),count+1);
		}
    }
}
