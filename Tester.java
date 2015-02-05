import java.util.ArrayList;


public class Tester 
{
	public static void main(String[] args)
	{
		
		ArrayList<Double> al = new ArrayList<Double>();
		boolean end = false;
        int n = 100;
        TimeInterval t = new TimeInterval();
        Algorithm1 alg1 = new Algorithm1();
        double[] d1;
        /**
        while(end == false)
        {
        	 t.startTiming();
             alg1.generate(n);
             t.endTiming();
             //double elapsedTime = t.getElapsedTime();
             System.out.println("n: " + n);
             System.out.println("ElapsedTime: "+ t.getElapsedTime());
             al.add((double) n);
             al.add(t.getElapsedTime());
             
             if(t.getElapsedTime() >= 30)
             {
            	 end = true;
             }
             
             n = n* 2;
             
        	
        }
        
        d1 = new double[al.size()];
        for(int k = 0; k < d1.length; k++ )
        {
        	d1[k] = al.get(k);
        	System.out.println(al.get(k));
        }
        **/
        al.add((double) 1);
        al.add(100.0);
        al.add(200.0);
        System.out.println(al);
        al.clear();
        System.out.println(al);
        
        Algorithm2 alg2 = new Algorithm2();
        alg2.generate(10);
        
        
        
	}

}
