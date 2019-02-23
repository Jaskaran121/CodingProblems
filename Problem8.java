import java.util.*;
import java.util.stream.Collectors;
//A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
//This solution uses o(n2).
public class Problem8 {
	public int calculate(Node root)
	{
		if(root==null)
			return 0;
		Queue<Node> queue = new LinkedList<>();
		int count=0;
		
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size>0)
			{
				Node top = queue.remove();
				if(calculateSubTreeSize(top))
					{
						
					count++;
					}
				
				if(top.left!=null) {
					
					queue.add(top.left);
					
				}
				if(top.right!=null) {
					queue.add(top.right);	
				}
					
				size--;
			}
		}
		
		return count;
	}

	public Boolean calculateSubTreeSize(Node top)
	{
		List<Integer> myList = new ArrayList<>();
		if(top.left!=null && top.left.data!=top.data)
			return false;
		if(top.right!=null && top.right.data!=top.data)
			return false;
		preOrderTraversal(top,myList);
		if(myList.size()==1)
			return true;
		else {
			Set<Integer> set = new LinkedHashSet<>();
			set.addAll(myList);

			for (Integer s : set) {
			    Collections.frequency(myList, s);
			}
			if(set.size()==1)
				return true;
		}
		return false;
	}
	
	public List<Integer> preOrderTraversal(Node top,List<Integer> myList){
		
		if(top!=null) {
			myList.add(top.data);
			preOrderTraversal(top.left,myList);
			preOrderTraversal(top.right,myList);
		}
		return myList;
	}
	public static void main(String[] args) {
		Node root = new Node(0);
		root.left = new Node(1);
		root.right = new Node(0);
		root.right.right = new Node(0);
		root.right.left = new Node(1);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(1);
		Problem8 obj =new Problem8();
		System.out.println(obj.calculate(root));
	}
}

class Node{
	int data;
	Node left;
	Node right;
	
	
	Node(int data)
	{
		this.data = data;
		this.left = null;
		this.right =null;
	}
}
