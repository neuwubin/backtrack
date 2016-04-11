
public class Main {

	public static void main(String[] args) {
		
		int a[][] = {{0,0,0,0},{0,0,1,0},{1,0,1,0},{1,0,0,0}};
		Solution s= new Solution(a,new Node(3,3));
		s.findWay(new Node(0,0),0);
		if(!s.flag)
			System.out.println("²»¿É´ï");
		
	}
}
