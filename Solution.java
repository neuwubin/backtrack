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
		//count用于计数，将对应节点添加到list并且验重,用于打印
		//节点验重，如果已经遍历过直接返回，防止环形回路
		for(int i=0;i<count;i++){
			if(node.get(i).equals(start))
				return;
		}
		//将节点添加到指定位置
		if(node.size()-1<count){
			node.add(start);
		}else
			node.set(count,start);
		//如果遍历到尾节点
		if(start.equals(end)){
			flag = true;
			for(int i=0;i<count+1;i++){
				System.out.print("("+node.get(i).getX()+","+node.get(i).getY()+")\t");
			}
			System.out.println();
		}else{
			//分别朝不同方向前进
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
