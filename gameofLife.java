import java.util.Scanner;

public class gameofLife {
	public void calculate(int row,int column,int[][] inputArray,int round)
	{
		int returnedCount =0;
		for(int k =0;k<round;k++)
		{
			int[][] updatedArray = new int[row][column];
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<column;j++)
				{
					returnedCount = extractingNeighbours(i,j,row,column,inputArray);
					if(returnedCount==2)
						updatedArray[i][j] = inputArray[i][j];
					else if(returnedCount==3)
						updatedArray[i][j] = 1;
					else
						updatedArray[i][j] =0;
						
				}
			}
			inputArray = updatedArray;
		}
		int finalCount =0;
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				if(inputArray[i][j]==1)
					finalCount++;
			}
		}
		System.out.println(finalCount);
	}
	public int extractingNeighbours(int i,int j,int row,int column,int[][] array)
	{
				int count=0;
				if(i-1>=0 && j-1>=0)
				{
					if(array[i-1][j-1] == 1) {
						count++;
					}
				}
				if(i+1<row && j+1<column)
				{
					if(array[i+1][j+1] == 1) {
						count++;
					}
				}
				if(i-1>=0 && j+1<column)
				{
					if(array[i-1][j+1] == 1) {
						count++;
					}
				}
				if(i+1<row && j-1>=0)
				{
					if(array[i+1][j-1] == 1) {
						count++;
					}
				}
				if(i-1>=0)
				{
					if(array[i-1][j] == 1) {
						count++;
					}
				}
				if(i+1<row)
				{
					if(array[i+1][j] == 1) {
						count++;
					}
				}
				if(j+1<column)
				{
					if(array[i][j+1] == 1) {
						count++;
					}
				}
				if(j-1>=0)
				{
					if(array[i][j-1] == 1) {
						count++;
					}
				}
				
				return count;
			
	}
	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		int row = scan.nextInt();
		int column = scan.nextInt();
		
		int [][] inputArray = new int[row][column];
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				inputArray[i][j] = scan.nextInt();
			}
		}
		int round =  scan.nextInt();
		gameofLife obj = new gameofLife();
		obj.calculate(row, column, inputArray,round);
	}

}
