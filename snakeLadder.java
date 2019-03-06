import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
//A snake Ladder game giving output as the winner of the game.
public class snakeLadder {
static int indexPlayerA = 0;
static int indexPlayerB = 0;
static HashMap<Integer,Integer> myMap = new HashMap<Integer,Integer>();
	public void calculate(ArrayList<Integer> inputList)
	{
		ArrayList<Integer> playerAList = new ArrayList<>();
		ArrayList<Integer> playerBList = new ArrayList<>();
		for(int i=0;i<inputList.size();i++)
		{
			if(i%2==0)
			{
				playerAList.add(inputList.get(i));
			}
			else
				playerBList.add(inputList.get(i));
		}
		
		int playerAPosition = calculatePlayerPosition(playerAList,"A");
		int playerBPosition = calculatePlayerPosition(playerBList,"B");
		if(playerAPosition>playerBPosition)
		{
			System.out.print("A " + playerAPosition);
		}
		else if(playerAPosition == playerBPosition)
		{
			if(indexPlayerA>indexPlayerB)
				System.out.print("B " + playerAPosition);
			else
				System.out.print("A " + playerBPosition);
		}
		else
			System.out.print("B " + playerBPosition);
	}
	
	public int calculatePlayerPosition(ArrayList<Integer> myList,String player) {
		int position = 1;
		
		for(int i=0;i<myList.size();i++)
		{
			if(myMap.containsKey(position + myList.get(i))) {
				position = checkSnakeLadder(myMap.get(position + myList.get(i)));
			}	
			else
			{
				if(position + myList.get(i)>100)
				{
					position = position;
				}
				else if(position + myList.get(i) == 100) {
					if(player.equals("A")) {
						indexPlayerA = i;
					}
					else
						indexPlayerB = i;
					return 100;
				}
				else {
					position = position + myList.get(i);
				}	
			}		
		}
		
		return position;
	}
	
	public int checkSnakeLadder(int position)
	{
		while(true)
		{
			if(myMap.containsKey(position)) {
				if(myMap.get(position)>100)
				{
					position = position;
				}
				else if(myMap.get(position) == 100) {
					return myMap.get(position);
				}
				else {
					position = myMap.get(position);
				}
			}
			if(!myMap.containsKey(position))
				break;
		}
		return position;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberofPairs = scan.nextInt();
		int[] array = new int[numberofPairs];
		for(int i=0;i<numberofPairs;i++)
		{
			int key = scan.nextInt();
			int value = scan.nextInt();
			myMap.put(key, value);
		}
		
		int numberofInputs = scan.nextInt();
		ArrayList<Integer> inputList = new ArrayList<>();
		for(int j=0;j<numberofInputs;j++)
		{
			inputList.add(scan.nextInt());
		}
		
		snakeLadder obj = new snakeLadder();
		obj.calculate(inputList);
	}

}
