import java.util.*;
import java.util.stream.Collectors;

//Given an array of integers, find the first missing positive integer in linear time and constant
//space. In other words, find the lowest positive integer that does not exist in the array. The
//array can contain duplicates and negative numbers as well.

public class Day2 {
	public int calculate(int[] array)
	{
		List<Integer> sortedList = Arrays.stream(array).boxed().filter(i->i>=0).sorted().collect(Collectors.toList());
		
		for(int i=0;i<sortedList.size()-1;i++) {
			if(sortedList.get(i+1)-sortedList.get(i)>1)
			{
				return sortedList.get(i)+1;
			}
		}
		return sortedList.get(sortedList.size()-1)+1;
	}
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int sizeArray = scan.nextInt();
	int[] array = new int[sizeArray];
	
	for(int i=0;i<sizeArray;i++)
	{
		array[i] = scan.nextInt();
	}
	
	Day2 obj = new Day2();
	System.out.println(obj.calculate(array));

	}

}
