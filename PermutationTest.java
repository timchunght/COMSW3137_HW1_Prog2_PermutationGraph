import java.awt.*;
import java.applet.*;
import java.util.ArrayList;
import graph.*;

public class PermutationTest extends Applet 
{

      Graph2D graph;
      DataSet data1;
      DataSet data2;
      DataSet data3;
      Axis    xaxis;
      Axis    yaxis_left;
      Axis    yaxis_right;
      int count = 0;
      int n = 100;
      ArrayList<Double> dataAL = new ArrayList<Double>();
      double[] d1;
      double[] d2;
      double[] d3;
      int MAXLENGTH = 17;
      boolean end = false;

      public void init() 
      {
       
        setSize(600, 600);
        graph = new Graph2D();
        graph.drawzero = false;
        graph.drawgrid = false;
        graph.borderTop = 50;
        graph.borderRight=100;
        setLayout( new BorderLayout() );
        add("Center", graph);
        TimeInterval t= new TimeInterval();
        Algorithm1 alg1 = new Algorithm1();
        Algorithm2 alg2 = new Algorithm2();
        Algorithm3 alg3 = new Algorithm3();


        while(count < MAXLENGTH)
        {
        	if(end == false)
        	{
	        	 t.startTiming();
	             alg1.generate(n);
	             t.endTiming();
	             System.out.println("n: " + n);
	             System.out.println("ElapsedTime: "+ t.getElapsedTime());
	             dataAL.add((double) n);
	             
	             
	             if(t.getElapsedTime() >= 30)
	             {
	            	 dataAL.add(30.0);
	            	 end = true;
	             }
	             else
	             {
	            	 dataAL.add(t.getElapsedTime());
	             }
             
             
        	}
        	else
        	{
        		System.out.println("n: " + n);
        		System.out.println("ElapsedTime: 30");
        		dataAL.add((double) n);
        		dataAL.add(30.0);
        	}
        	 n = n* 2;
             count++;
             
        	
        }
        
        d1 = convertALToArr(dataAL, d1);
        dataAL.clear();
        
        n = 100;
        count = 0;
        end = false;
        while(count < MAXLENGTH)
        {
        	if(end == false)
        	{
	        	 t.startTiming();
	             alg2.generate(n);
	             t.endTiming();
	             System.out.println("n: " + n);
	             System.out.println("ElapsedTime: "+ t.getElapsedTime());
	             dataAL.add((double) n);
	             
	             
	             if(t.getElapsedTime() >= 30)
	             {
	            	 dataAL.add(30.0);
	            	 end = true;
	             }
	             else
	             {
	            	 dataAL.add(t.getElapsedTime());
	             }
             
             
        	}
        	else
        	{
        		System.out.println("n: " + n);
        		System.out.println("ElapsedTime: 30");
        		dataAL.add((double) n);
        		dataAL.add(30.0);
        	}
        	 n = n* 2;
             count++;
             
        	
        }
        
        d2 = convertALToArr(dataAL, d2);
        dataAL.clear();
        
        n = 100;
        count = 0;
        end = false;
        while(count < MAXLENGTH)
        {
        	if(end == false)
        	{
	        	 t.startTiming();
	             alg3.generate(n);
	             t.endTiming();
	             System.out.println("n: " + n);
	             System.out.println("ElapsedTime: "+ t.getElapsedTime());
	             dataAL.add((double) n);
	             
	             
	             if(t.getElapsedTime() >= 30)
	             {
	            	 dataAL.add(30.0);
	            	 end = true;
	             }
	             else
	             {
	            	 dataAL.add(t.getElapsedTime());
	             }
             
             
        	}
        	else
        	{
        		System.out.println("n: " + n);
        		System.out.println("ElapsedTime: 30");
        		dataAL.add((double) n);
        		dataAL.add(30.0);
        	}
        	 n = n* 2;
             count++;
             
        	
        }
        
        d3 = convertALToArr(dataAL, d3);
        dataAL.clear();
    
        data1 = graph.loadDataSet(d1, d1.length/2);
        data1.linestyle = 1;
        data1.linecolor   =  new Color(0,255,0);
        data1.marker    = 1;
        data1.markerscale = 1;
        data1.markercolor = new Color(0,0,255);
        data1.legend(200,100,"Alg1");
        data1.legendColor(Color.black);
        
        
        data2 = graph.loadDataSet(d2, d2.length/2);
        data2.linestyle = 1;
        data2.linecolor   =  new Color(255,0,0);
        data2.marker    = 1;
        data2.markerscale = 1;
        data2.markercolor = new Color(0,0,255);
        data2.legend(200,120,"Alg2");
        data2.legendColor(Color.black);

        data3 = graph.loadDataSet(d3, d3.length/2);
        data3.linestyle = 1;
        data3.linecolor   =  new Color(255,0,255);
        data3.marker    = 1;
        data3.markerscale = 1;
        data3.markercolor = new Color(0,0,255);
        data3.legend(200,140,"Alg3");
        data3.legendColor(Color.black);

        
        xaxis = graph.createAxis(Axis.BOTTOM);
        xaxis.attachDataSet(data1);
        xaxis.attachDataSet(data2);
        xaxis.attachDataSet(data3);
        xaxis.setTitleText("N number of values");
        xaxis.setTitleFont(new Font("TimesRoman",Font.PLAIN,20));
        xaxis.setLabelFont(new Font("Helvetica",Font.PLAIN,15));
    
        yaxis_left = graph.createAxis(Axis.LEFT);
        yaxis_left.attachDataSet(data1);
        yaxis_left.attachDataSet(data2);
        yaxis_left.attachDataSet(data3);
        yaxis_left.setTitleText("Time in Seconds");
        yaxis_left.setTitleFont(new Font("TimesRoman",Font.PLAIN,20));
        yaxis_left.setLabelFont(new Font("Helvetica",Font.PLAIN,15));
        yaxis_left.setTitleColor( new Color(0,0,255) );
      
      
      }
      
      public static double[] convertALToArr(ArrayList<Double> al, double[] arr)
      {
    	  arr = new double[al.size()];
          for(int i = 0; i < arr.length; i++ )
          {
        	  
	          	arr[i] = al.get(i);
	          	System.out.println(al.get(i));
        	  
          }
          
          return arr;
      }
      
 }


