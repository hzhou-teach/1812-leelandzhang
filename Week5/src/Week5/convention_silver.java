//Leeland Zhang
//I looked at the solution and I had the exact same idea for the
//'greedy' algorithm, where we take a max amount of time, and then
//see if its viable or not by going through each bus, either it
//exceeds the max time or it equals to the max seating of cows
//I just didn't get binary search part, so I had a lot of time outs.
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class convention_silver 
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("convention.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("convention.out"));
		int n=sc.nextInt();
		int m=sc.nextInt();
		double c=sc.nextDouble();
		long[] times=new long[n];
		for(int i=0; i<n; i++)
		{
			times[i]=sc.nextLong();
		}
		sc.close();
		//--------------------------------------------------------------
		Arrays.sort(times);
		long[] difference=new long[n-1];
		for(int i=0; i<n-1; i++)
		{
			difference[i]=times[i+1]-times[i];
		}
		//---------------------------------------------------------------
		long max=0;
		long temp=0;
		int count=0;
		for(int i=0; i<n-1; i++)
		{
			count++;
			temp+=difference[i];
			if(count==c-1)
			{
				if(temp>max)
				{
					max=temp;
				}
				temp=0;
				i++;
				count=0;
			}
		}
		boolean exit=false;
		int count1=0;
		while(1!=0)
		{
			count=0;
			temp=0;
			long min=0;
			for(int i=0; i<n-1;i++)
			{
				if(difference[i]>max)
				{
					exit=true;
					break;
				}
				count1++;
				temp+=difference[i];
				if(temp>=max||count1==c||i==n-2)
				{
					if(temp-difference[i]>min)
						min=temp-difference[i];
					count++;
					temp=0;
					count1=0;
				}
				if(count>m)
				{
					exit=true;
					break;
				}
			}
			if(exit)
				break;
			max=min;
		}
		pr.println(max);
		pr.close();
	}
}
