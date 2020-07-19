
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class teamwork_gold 
{
	static int K;
	static int N;
	public static class range
	{
		private int a;
		private int b;
		private int begrange;
		private int endrange;
		public range(int val, int pos) 
		{
			a=val;
			b=pos;
			if(b-K+1<0)
				begrange=0;
			else
			begrange=b-K+1;
			if(b+K-1>N-1)
				endrange=N-1;
			else
			endrange=b+K-1;
		}
		public int getval()
		{
			return a;
		}
		public int getpos()
		{
			return b;
		}
		public int getbegrange()
		{
			return begrange;
		}
		public int getendrange()
		{
			return endrange;
		}
		public void change(int x, int y)
		{
			begrange+=x;
			endrange+=y;
		}
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("teamwork.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("teamwork.out"));
		N=sc.nextInt();
		K=sc.nextInt();
		int[] skills=new int[N];
		int[] sorted=new int[N];
		Map <Integer, Integer> find=new HashMap<Integer,Integer>();
		for(int i=0; i<N; i++)
		{
			int temp=sc.nextInt();
			find.put(temp, i);
			skills[i]=temp;
			sorted[i]=temp;
		}
		sc.close();
		//-------------------------------------------------------------
		Arrays.sort(sorted);
		ArrayList<range> ranges=new ArrayList<range>();
		int count=0;
		boolean[] set=new boolean[N];
		ArrayList<ArrayList<Integer>> nested=new ArrayList<ArrayList<Integer>>(N);
		for(int i=0; i<N; i++)
		{
			nested.add(new ArrayList<Integer>());
		}
		int i=0;
		while(count<N)
		{
			if(set[find.get(sorted[i])])
			{
				continue;
			}
			ranges.add(new range(sorted[i],i));
			for(int j=ranges.get(i).getbegrange();j<=ranges.get(i).getendrange(); j++)
			{
				nested.get(j).add(sorted[i]);
			}
			for(int j=0;j<ranges.size()-1; j++)
			{
				if(ranges.get(j).getbegrange()<ranges.get(i).getendrange())
				{
					for(int k=ranges.get(j).getbegrange();k<=ranges.get(i).getendrange();k++)
					{
						if(set[k]!=true)
						{
							count++;
							set[k]=true;
						}
					}
				}
				else if(ranges.get(j).getendrange()>ranges.get(i).getbegrange())
				{
					for(int k=ranges.get(i).getbegrange();k<=ranges.get(j).getendrange();k++)
					{
						if(set[k]!=true)
						{
							count++;
							set[k]=true;
						}
					}
				}
			}
			i++;
		}
		//------------------------------------------------------------
		long ans=0;
		count=0;
		i=0;
		while(count<N)
		{
			long min=100000000;
			int best=0;
			for(int j=ranges.get(i).getbegrange();j<=ranges.get(i).getpos();j++)
			{
				long temp=0;
				for(int k=j; k<j+K;k++)
				{
					temp+=Collections.max(nested.get(k));
				}
				if(temp<min)
				{
					min=temp;
					best=j;
				}
			}
			for(int j=best;j<best+K;j++)
			{
				if(!set[j])
				{
					continue;
				}
				set[j]=false;
				for(int k=0; k<nested.get(j).size();k++)
				{
					if(nested.get(j).get(k)!=Collections.max(nested.get(j)))
					{
						k=0;
						nested.get(j).remove(k);
					}
				}
				ans+=ranges.get(i).getval();
			}
			i++;
		}
		pr.println(ans);
		pr.close();
	}
}
