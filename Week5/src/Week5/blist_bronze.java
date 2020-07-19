//Leeland Zhang
//Took me 10 minutes
//Got all
//Difficulty 1
//I used a bronze method, so there's nothing to be proud of here.
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class blist_bronze 
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("blist.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("blist.out"));
		int n=sc.nextInt();
		int[] times=new int[1000];
		for(int i=0; i<n; i++)
		{
			int start=sc.nextInt();
			int end=sc.nextInt();
			int buckets=sc.nextInt();
			for(int j=start;j<=end;j++)//inclusive
			{
				times[j]+=buckets;
			}
		}
		sc.close();
		int max=0;
		for(int i=0; i<1000; i++)
		{
			if(times[i]>max)
				max=times[i];
		}
		pr.println(max);
		pr.close();
	}
}
