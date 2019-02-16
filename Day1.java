import java.awt.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
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
