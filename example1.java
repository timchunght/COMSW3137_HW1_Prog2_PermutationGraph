import java.awt.*;
import java.applet.*;
import java.util.ArrayList;

import graph.*;

public class example1 extends Applet 
{

      Graph2D graph;
      DataSet data1;
      DataSet data2;
      Axis    xaxis;
      Axis    yaxis_left;
      Axis    yaxis_right;
      int count = 0;
      int n;
      int np = 100000;
      ArrayList<Double> dataAL = new ArrayList<Double>();
      double[] d1;
      double[] d2;
      int MAXLENGTH = 18;
      boolean end = false;

      public void init() 
      {
        //double x,y;

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
       
        
        n = 100;
        count = 0;
        end = false;
        while(count < MAXLENGTH)
        {
        	if(end == false)
        	{
	        	 t.startTiming();
	             alg1.generate(n);
	             t.endTiming();
	             //double elapsedTime = t.getElapsedTime();
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
	             //double elapsedTime = t.getElapsedTime();
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
        /**
        d1 = new double[al.size()];
        for(int k = 0; k < d1.length; k++ )
        {
        	d1[k] = al.get(k);
        	System.out.println(al.get(k));
        }
        **/
        /**
        for(i = 0, n = 100; i < 2 * MAXPOINTS; i += 2, n *= 2) 
        {
            // If algorithm time is over 30 seconds, just set the next sets
            // as 30 to keep y-axis limited to 30 seconds.
          
            if(end == false)
            {
           
                t.startTiming();
                alg1.generate(n);
                t.endTiming();
                //double elapsedTime = t.getElapsedTime();
                System.out.println("n: " + n);
                System.out.println("ElapsedTime: "+ t.getElapsedTime());
                
                // If time is over 30 seconds, set point as 30 seconds and
                // flip boolean to save time.
                if (t.getElapsedTime() > 30) 
                {
                    end = true;
                    d1[i] = n;
                    d1[i+1] = 30;
                }
                // Otherwise store data in array.
                else
                {
                	System.out.println(i);
                    d1[i] = n;
                    d1[i+1] = t.getElapsedTime();
                }
            }
            else
            {
            	d1[i] = d1[i-2];
                d1[i+1] = d1[i-1];
            }
        }
        **/
        /**
        t= new TimeInterval();
        t.startTiming();
        for(i=0; i<MAXPOINTS; i++){
        	x=i;
        	y=i*i;
        	d2[i*2]=x; d2[i*2+1]=y;
        }
        t.endTiming();
        System.out.println("time to generate " + MAXPOINTS + " values of Y=X*X is " + t.getElapsedTime()/1000.0);
        **/
        
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
        data2.legend(200,120,"Y=X*X, quadratic");
        data2.legendColor(Color.black);

        
       
        
        xaxis = graph.createAxis(Axis.BOTTOM);
        xaxis.attachDataSet(data1);
        xaxis.attachDataSet(data2);
        xaxis.setTitleText("N values");
        xaxis.setTitleFont(new Font("TimesRoman",Font.PLAIN,20));
        xaxis.setLabelFont(new Font("Helvetica",Font.PLAIN,15));
/*
**      Attach the first data set to the Left Axis
*/
        
        yaxis_left = graph.createAxis(Axis.LEFT);
        yaxis_left.attachDataSet(data1);
        yaxis_left.attachDataSet(data2);
        yaxis_left.setTitleText("T VALUES");
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


