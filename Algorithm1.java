import java.util.Random;


public class Algorithm1 
{
	private Random randGenerator = new Random();
	private int[] dataSet;

	
	public Algorithm1()
	{

	}
	
	public void generate(int length)
	{
		
		dataSet = new int[length];
		for(int i = 0; i < length; i++)
		{
			int tempInt = randGenerator.nextInt(length) + 1;
			while(exist(dataSet, tempInt))
			{
				tempInt = randGenerator.nextInt(length) + 1;
			}
			
			dataSet[i] = tempInt;
		}
		
	}
	
	private boolean exist(int[] dataSet, int newInt)
	{
		for(int num : dataSet)
		{
			if(num == newInt)
			{
				return true;
			}
		}
	
		return false;
	}
	
}
