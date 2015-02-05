import java.util.Random;


public class Algorithm3 
{
	private Random randGenerator = new Random();
	private int[] dataSet;


	
	public Algorithm3()
	{

	}
	
	public void generate(int length)
	{
		
		dataSet = new int[length];
		
		for(int i = 0; i < length; i++)
		{
			
			dataSet[i] = i+1;
			
		}
		
		for(int i = 0; i < length; i++)
		{
			swapReferences(i, randGenerator.nextInt(length));
		}
		
		
		
	}
	
	private void swapReferences(int dataIndex, int randIndex)
	{
		int tempInt = dataSet[dataIndex];
		dataSet[dataIndex] = dataSet[randIndex];
		dataSet[randIndex] = tempInt;
	}
	
	
	
}
