import java.awt.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
//Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

//For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
public class Day1 {
	public Boolean calculate(int[] array,int k) {
		for(int i=0;i<array.length;i++)
		{
			if(array[i]<=k) {
				int secondNumber = k-array[i];
				int index = Arrays.stream(array).boxed().collect(Collectors.toList()).indexOf(secondNumber);
				if(index!=-1 && index!=i)
					return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		
		int[] array = new int[] {10, 15, 3, 7};
		Scanner scan = new Scanner(System.in);
		
		
		
		int k = scan.nextInt();
		Day1 obj = new Day1();
		System.out.println(obj.calculate(array, k));
	}

}
