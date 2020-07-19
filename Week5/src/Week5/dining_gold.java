package Week5;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class dining_gold 
{
	public static int[] dijkstra(int[][] x, int n)
	{
		int[] y=new int[n-1];
		
		return y;
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("dining.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("dining.out"));
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		int[][] map=new int[m][3];
		for(int i=0; i<m; i++)
		{
			map[i][0]=sc.nextInt()-1;
			map[i][1]=sc.nextInt()-1;
			map[i][2]=sc.nextInt();
		}
		long[] food=new long[n];
		for(int i=0; i<k; i++)
		{
			int index=sc.nextInt()-1;
			food[index]+=sc.nextLong();
		}
		
	}
}
