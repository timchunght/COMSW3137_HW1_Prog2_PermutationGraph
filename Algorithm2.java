import java.util.Random;


public class Algorithm2 
{
	private Random randGenerator = new Random();
	private int[] dataSet;
	private boolean[] used;

	
	public Algorithm2()
	{

	}
	
	public void generate(int length)
	{
		used = new boolean[length];
		dataSet = new int[length];
		
		for(int i = 0; i < length; i++)
		{
			int tempInt = randGenerator.nextInt(length) + 1;
			while(used[tempInt - 1] == true)
			{
				tempInt = randGenerator.nextInt(length) + 1;
			}
			used[tempInt - 1] = true;
			dataSet[i] = tempInt;
			//System.out.println(tempInt);
		}
		
	}
	
	
	
}
