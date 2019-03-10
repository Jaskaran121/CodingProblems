import java.util.Scanner;
////The game of life is a game which is played on a field of cells. Cells are arranged in a rectangular grid. Each cell has at most eight
//neighbours, i.e. adjacent cells. Each cell in the field is either occupied by an organism or is blank.
//The objectiveofthe game isto simulate the life ofthe organisms present
//in the field, generation after generation. The only work of the organism
//isto either reproduce or die!
//The rules of reproduction are given asfollows (examplesin figure):
//1. If an organism has 0 or 1 neighbours, it will die out of loneliness in
//the next generation
//2. If an organism has 4 or more neighbours, it will die of crowding in
//the next generation
//3. If an organism has 2 or 3 neighbours, it will prosper and survive into
//the next generation
//4. If an unoccupied cell has exactly three neighbours, then an
//organism takes birth in the next generation
//You are required to write a Java program which simulatesthe life of the
//organisms and outputs the state of the field after 'N' generations.
//Here input 0 means a blank cell and input 1 means a neighbouring cell is present.
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
