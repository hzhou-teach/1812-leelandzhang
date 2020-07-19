//I checked the answer after I gave up, I realized that my ideas were
//all correct, just my code was super innefecient, I knew I was going to 
//recieve a time out.
//For the gravity I had it so that i just check my vertical for zeroes 
//and then drop down all the numbers accordingly
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class mooyomooyo_silver 
{
	static void search(int x, int y)
	{
		if(rightdown(x,y)==3)
		{
			count+=2;
			seen[x+1][y]=true;
			seen[x][y+1]=true;
			search(x+1,y);
			search(x,y+1);
		}
		else if(rightdown(x,y)==2)
		{
			count++;
			seen[x][y+1]=true;
			search(x,y+1);
		}
		else if(rightdown(x,y)==1)
		{
			count++;
			seen[x+1][y]=true;
			search(x+1,y);
		}
	}
	static int rightdown(int x, int y)
	{
		int count=0;
		if(x<9&&horizontal[y][x+1]==horizontal[y][x])
		{
			count++;
		}
		if(y<N-1&&vertical[x][y]==vertical[x][y+1])
		{
			count+=2;
		}
		return count;
	}
	static int K;
	static int N;
	static int count=0;
	static int[][] horizontal;
	static int[][] vertical;
	static boolean[][] seen;
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("mooyomooyo.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("mooyomooyo.out"));
		N=sc.nextInt();
		K=sc.nextInt();
		horizontal=new int[N][10];
		vertical=new int[10][N];
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<10; j++)
			{
				int temp=sc.nextInt();
				horizontal[i][j]=temp;
				vertical[j][i]=temp;
			}
		}
		sc.close();
		//---------------------------------------------------------
		seen=new boolean[N][10];
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<10; j++)
			{
				if(horizontal[i][j]==0||seen[i][j]==true)
					continue;
				int count=0;
				boolean deleate[][]=new boolean[N][10];
				search(i,j);
				if(count>=K)
				{
					for(int a=0; a<N; a++)
					{
						for(int b=0; b<10; b++)
						{
							if(seen[a][b]==true)
								
						}
					}
				}
			}
		}
	}
}
